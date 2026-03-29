package com.biblioteca.demov1.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    private int id;
    private String nombre;
    private LocalDate fechaPublicacion;
    private String autor;
    private String editorial;
}
