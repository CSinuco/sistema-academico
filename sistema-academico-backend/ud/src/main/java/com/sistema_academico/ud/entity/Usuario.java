package com.sistema_academico.ud.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nombre;
    protected String apellido;
    protected String correo;
    protected String userName;
    protected String password;
    protected boolean cambiarPassword = true;
    protected boolean activo = true;
    protected UserRole rol;
}
