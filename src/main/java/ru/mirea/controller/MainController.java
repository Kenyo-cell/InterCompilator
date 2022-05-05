package ru.mirea.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.entity.ContextEntity;
import ru.mirea.entity.UserEntity;
import ru.mirea.service.ContextService;
import ru.mirea.service.IExecutionService;
import ru.mirea.service.UserService;

import java.io.IOException;

/**
 * Основной класс контроллера приложения для сетевого взаимодействия по протоколу HTTP
 */
@Controller
public class MainController {
    /**
     * Ссылка на объект класса сервиса, в котором реализована вся логика работы с сущностью пользователя
     */
    private final UserService userService;
    /**
     * Ссылка на объект класса сервиса, в котором реализована вся логика работы с сущностью контекста
     */
    private final ContextService contextService;
    /**
     * Ссылка на объект класса сервиса, в котором реализована логика поставки кода на исполнения в режиме очереди в конкретный контейнер
     */
    private final IExecutionService executionService;

    /**
     * @param userService
     * @param contextService
     * @param executionService
     */
    public MainController(UserService userService, ContextService contextService, IExecutionService executionService) {
        this.userService = userService;
        this.contextService = contextService;
        this.executionService = executionService;
    }

    /**
     * @param language параметр, указывающий на то, контейнер с поддержкой какого языка необходимо будет запустить
     * @param source параметр, содержащий в себе файл с исходным кодом
     * @param source параметр, содержащий в себе файл с входными данными
     * @return представление с файлом выходных данных
     * @throws IOException
     */
    @CrossOrigin
    @PostMapping("/submit")
    public ResponseEntity<?> execute(@RequestPart String language,
                                     @RequestPart(name = "code") MultipartFile source,
                                     @RequestPart(name = "code") MultipartFile input) throws IOException {
        System.out.println(source.getContentType());
        System.out.println(source.getOriginalFilename());
        System.out.println(new String(source.getBytes()));

        return ResponseEntity.ok("Ok");
    }

    /**
     * @param user содержит объект сущности пользователя без id для первоначальной регистрации
     * @return сущность пользователя с присвоенным id
     */
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(UserEntity user) {
        return null;
    }

    /**
     * @param user содержит объект сущности пользователя для внесения изменений в данные об учетной записи
     * @param id значение идентефикатора пользователя, по которому будут производиться изменения
     * @return обновленную сущность пользователя
     */
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(UserEntity user, @PathVariable long id) {
        return null;
    }

    /**
     * @param id значение идентефикатора пользователя, котоырй будет удален
     * @return идентификатор удаленного пользователя в качестве подтверждения операции
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        return null;
    }

    /**
     * @param id идентификатор пользователя, данные которого будут получены
     * @return сущность найденного пользователя
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        return null;
    }

    /**
     * @param context объект контекста работы пользователя для создания его в базе данных
     * @param userId идентификатор пользователя, которому присваивается новый контекст
     * @return созданный объкет контекста с присвоенным идентификатором
     */
    @PostMapping("/user/{userId}/context")
    public ResponseEntity<?> saveContext(ContextEntity context, @PathVariable long userId) {
        return null;
    }

    /**
     * @param context объект контекста работы пользователя для внесения изменений в БД
     * @param userId идентификатор пользователя, которому принадлежит объект
     * @param contextId идентификатор контекста, по которому будут производиться изменения
     * @return объект контекста для подтверждения обновления
     */
    @PutMapping("/user/{userId}/context/{contextId}")
    public ResponseEntity<?> updateContext(ContextEntity context,
                                           @PathVariable long userId,
                                           @PathVariable long contextId) {
        return null;
    }

    /**
     * @param userId идентификатор пользователя, которому принадлежит контекст
     * @param contextId идентифи контекста, который будет удален
     * @return идентификатор удаленного контекста для подтверждения удаления
     */
    @DeleteMapping("/user/{userId}/context/{contextId}")
    public ResponseEntity<?> deleteContext(@PathVariable long userId, @PathVariable long contextId) {
        return null;
    }

    /**
     * @param id идентификатор пользователя, информация о контекстах которого будет извлечена
     * @return список всех контекстов пользователя
     */
    @GetMapping("/user/{id}/context")
    public ResponseEntity<?> getContextsByUserId(@PathVariable long id) {
        return null;
    }

    /**
     * @param userId идентификатор пользователя, которому принадлежит конкретный контекст
     * @param contextId идентификатор конкретного контекста
     * @return найденный конкретный контекст
     */
    @GetMapping("/user/{userId}/context/{contextId}")
    public ResponseEntity<?> getContextByUserIdAndContextId(@PathVariable long userId, @PathVariable long contextId) {
        return null;
    }
}
