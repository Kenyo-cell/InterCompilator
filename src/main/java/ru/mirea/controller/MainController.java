package ru.mirea.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
    @PostMapping("/submit")
    public ResponseEntity<String> sendToExecute(@RequestPart String language, @RequestPart MultipartFile file) {
        System.out.println(file.getContentType());
        System.out.println(file.getName());
        return ResponseEntity.ok("Ok");
    }
}
