package com.biblioteca.demov1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.demov1.model.Libro;
import com.biblioteca.demov1.service.LibroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libros")
public class LibroController {

    private final LibroService serv;

    @GetMapping()
    public ResponseEntity<List<Libro>> obtenerTodos() {
        return ResponseEntity.ok(serv.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable int id) {
        Libro libro = serv.buscarPorId(id);
        return ResponseEntity.ok(libro);
    }

    @PostMapping()
    public ResponseEntity<Libro> guardar(@Valid @RequestBody Libro libro) {
        Libro nuevo = serv.guardar(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar( @PathVariable int id,@Valid @RequestBody Libro libro) {
        Libro actualizado = serv.actualizar(id, libro);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        serv.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
