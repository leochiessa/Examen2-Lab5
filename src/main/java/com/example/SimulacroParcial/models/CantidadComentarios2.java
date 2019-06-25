package com.example.SimulacroParcial.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CantidadComentarios2 {

    @Id
    @NotNull
    private String usuario;
    @NotNull
    private String publicacion;
    @NotNull
    private Integer comentarios;
}