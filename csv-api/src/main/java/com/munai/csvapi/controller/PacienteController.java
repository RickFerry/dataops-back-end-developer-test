package com.munai.csvapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        File csvFile = new File("/tmp/" + file.getOriginalFilename());
        try {
            file.transferTo(csvFile);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar arquivo.");
        }

        return ResponseEntity.ok("Arquivo recebido e salvo temporariamente.");
    }
}
