package br.com.treinaweb.ediaristas.controllers;

import java.io.IOException;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.treinaweb.ediaristas.services.FileService;

@Controller
@RequestMapping("/uploads")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping
    public ResponseEntity<Object> file(@RequestParam String filename) throws IOException {
        var file = fileService.carregar(filename);
        var contentType = URLConnection.guessContentTypeFromName(file.getFilename());

        return ResponseEntity.status(HttpStatus.OK)
            .header("Content-Type", contentType)
            .body(file.getInputStream().readAllBytes());
    }
    
}
