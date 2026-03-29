package com.biblioteca.demov1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.demov1.model.Libro;
import com.biblioteca.demov1.service.LibroService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {

    private final LibroService serv;

    @GetMapping()
    public List<Libro> obtenerTodos() {
        return serv.buscarTodos();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable int id) {
        return serv.buscarPorId(id);
    }

    @PostMapping()
    public boolean guardar(@RequestBody Libro libro) {
        return serv.Guardar(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable int id, @RequestBody Libro libro) {
        return serv.actualizar(id, libro);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id){
        return serv.eliminar(id);
    }
    
}
