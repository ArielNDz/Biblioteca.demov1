package com.biblioteca.demov1.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    private int id;
    @NotBlank(message = "El nombre no debe estar vacio.")
    private String nombre;
    @NotNull(message = "Debe ingresar una fecha valida.")
    @PastOrPresent(message = "Fecha no puede ser mayor a hoy.")
    private LocalDate fechaPublicacion;
    @NotBlank(message = "El autor no debe estar vacio")
    private String autor;
    @NotBlank(message = "La editorial no puede estar vacia.")
    private String editorial;
}
