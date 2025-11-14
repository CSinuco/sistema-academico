package com.sistema_academico.ud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@NoArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombres;
    private String apellidos;
    private String grado;


    @Column(name = "estado")
    private String estado = "PENDIENTE";

    // 🔥 Polimorfismo: puede ser Aspirante o Acudiente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_responsable_id")
    private Usuario responsable;
}
