package com.biblioteca.demov1.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.biblioteca.demov1.model.Libro;

@Repository
public class LibroRepository {

    private final List<Libro> listaLibros;

    public LibroRepository(){

        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro(1, "Cien años de soledad", LocalDate.of(1967, 5, 30), "Gabriel García Márquez", "Editorial Sudamericana"));
        listaLibros.add(new Libro(2, "Don Quijote de la Mancha", LocalDate.of(1605, 1, 16), "Miguel de Cervantes", "Francisco de Robles"));
        listaLibros.add(new Libro(3, "La sombra del viento", LocalDate.of(2001, 6, 17), "Carlos Ruiz Zafón", "Editorial Planeta"));
        listaLibros.add(new Libro(4, "El principito", LocalDate.of(1943, 4, 6), "Antoine de Saint-Exupéry", "Reynal & Hitchcock"));
        listaLibros.add(new Libro(5, "1984", LocalDate.of(1949, 6, 8), "George Orwell", "Secker & Warburg"));
    }

    public List<Libro> findAll() {
        return listaLibros;
    }

    public Libro findById(int id){
        for (Libro libro : listaLibros){
            if (libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro save(Libro libro){
        listaLibros.add(libro);
        return libro;
    }

    public boolean delete(Libro libro){
        return listaLibros.remove(libro);
    }
}
