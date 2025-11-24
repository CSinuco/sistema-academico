package com.sistema_academico.ud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Entity
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
    @Enumerated(EnumType.STRING)
    protected UserRole rol;
}
