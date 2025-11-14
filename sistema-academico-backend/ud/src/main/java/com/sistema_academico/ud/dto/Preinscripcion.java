package com.sistema_academico.ud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Preinscripcion {
    @NotBlank(message = "Los nombres son obligatorios")
    private String nombre;
    @NotBlank(message = "los apellidos son obligatorios")
    private String apellido;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "formato incorrecto")
    String correo;
}
