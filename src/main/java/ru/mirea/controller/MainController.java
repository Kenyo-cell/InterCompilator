package ru.mirea.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {
    @CrossOrigin
    @PostMapping("/submit")
    public ResponseEntity<String> sendToExecute(@RequestPart String language, @RequestPart MultipartFile file) throws IOException {
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(new String(file.getBytes()));
        return ResponseEntity.ok("Ok");
    }
}
