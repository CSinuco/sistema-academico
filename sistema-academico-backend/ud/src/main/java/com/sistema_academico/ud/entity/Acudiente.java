package com.sistema_academico.ud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acudiente")
@Getter@Setter
@NoArgsConstructor

public class Acudiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acudienteId;

}
