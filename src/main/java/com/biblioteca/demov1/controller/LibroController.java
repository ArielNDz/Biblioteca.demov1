package com.biblioteca.demov1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.demov1.model.Libro;
import com.biblioteca.demov1.service.LibroService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {

    private final LibroService serv;

    @GetMapping("")
    public List<Libro> obtenerTodos() {
        return serv.buscarTodos();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable int id) {
        return serv.buscarPorId(id);
    }

}
