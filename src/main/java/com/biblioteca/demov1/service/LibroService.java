package com.biblioteca.demov1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.demov1.model.Libro;
import com.biblioteca.demov1.repository.LibroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository repo;

    public List<Libro> buscarTodos(){
        return repo.findAll();
    }

    public Libro buscarPorId(int id){
        return repo.findById(id);
    }

}
