package com.biblioteca.demov1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.demov1.exception.LibroNoEncontradoException;
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

    public boolean Guardar(Libro libro){
        return repo.save(libro);
    }

    public Libro actualizar(int id, Libro libro){
        Libro libroActualizado = repo.findById(id);
        if (libroActualizado != null){
            libroActualizado.setNombre(libro.getNombre());
            libroActualizado.setAutor(libro.getAutor());
            libroActualizado.setFechaPublicacion(libro.getFechaPublicacion());
            libroActualizado.setEditorial(libro.getEditorial());
            return libroActualizado;
        }
        return null;  
    }

    public boolean eliminar(int id){
        Libro libroBorrado = repo.findById(id);
        if (libroBorrado != null){
            return repo.delete(libroBorrado);
        }
        return false;
    }

}
