package ru.mirea.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.service.IExecutionService;

import java.io.IOException;

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