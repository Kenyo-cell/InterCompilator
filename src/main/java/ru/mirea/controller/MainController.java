package ru.mirea.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.entity.ContextEntity;
import ru.mirea.entity.UserEntity;
import ru.mirea.service.ContextService;
import ru.mirea.service.IExecutionService;
import ru.mirea.service.UserService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.stream.Collectors;

/**
 * Основной класс контроллера приложения для сетевого взаимодействия по протоколу HTTP
 */
@Controller
public class MainController {
    /**
     * Ссылка на объект класса сервиса, в котором реализована логика поставки кода на исполнения в режиме очереди в конкретный контейнер
     */
    private final IExecutionService executionService;

    /**
     * @param executionService
     */
    public MainController(IExecutionService executionService) {
        this.executionService = executionService;
    }

    /**
     * @param language параметр, указывающий на то, контейнер с поддержкой какого языка необходимо будет запустить
     * @param source   параметр, содержащий в себе файл с исходным кодом
     * @param source   параметр, содержащий в себе файл с входными данными
     * @return представление с файлом выходных данных
     * @throws IOException
     */
    @CrossOrigin
    @PostMapping("/submit")
    public ResponseEntity<String> execute(@RequestPart String language,
                                          @RequestPart(name = "code") MultipartFile source,
                                          @RequestPart(name = "input") MultipartFile input) throws IOException {

        byte[] result = executionService.execute(language, source.getInputStream(), input.getInputStream());

        return ResponseEntity.ok(new String(result));
    }
}