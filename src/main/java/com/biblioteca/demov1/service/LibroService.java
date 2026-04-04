package com.biblioteca.demov1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.demov1.exception.LibroNoEncontradoException;
import com.biblioteca.demov1.exception.OperacionInvalidaException;
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
        Libro libro = repo.findById(id);
        if (libro == null){
            throw new LibroNoEncontradoException("No se encontro el libro con id: " + id);
        }
        return libro;
    }

    public Libro guardar(Libro libro){
        boolean exito = repo.save(libro);
        if (!exito){
            throw new OperacionInvalidaException("No se pudo guardar el libro.");
        }
        return libro;
    }


    public Libro actualizar(int id, Libro libro){
        Libro actualizado = repo.findById(id);
        if (actualizado == null){
            throw new LibroNoEncontradoException("No se encontro el libro con id: " + id);
        }
        return repo.update(id, libro);
    }

    public void eliminar(int id){
        Libro borrado = repo.findById(id);
        if (borrado == null){
            throw new LibroNoEncontradoException("No se encontro el libro con id: " + id);
        }
        boolean exito = repo.delete(borrado);
        if (!exito){
            throw new OperacionInvalidaException("No se pudo eliminar el libro con id: " + id);
        }
    }

}
