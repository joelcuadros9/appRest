package com.api.rest.controller;

import com.api.rest.model.Nota;
import com.api.rest.repository.NotaRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class NotaController {

    @Autowired
    NotaRepository notaRepository;

    @GetMapping("/nota")
    public ResponseEntity<List<Nota>> getAllNota() {
        try {
            List<Nota> notas = new ArrayList<Nota>();

            notaRepository.findAll().forEach(notas::add);

            if (notas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(notas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/nota")
    public ResponseEntity<Nota> createNota(@RequestBody Nota nota) {
        try {
            Nota _nota = notaRepository
                    .save(nota);
            return new ResponseEntity<>(_nota, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
