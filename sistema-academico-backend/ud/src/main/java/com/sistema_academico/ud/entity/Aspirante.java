package com.sistema_academico.ud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "aspirante")
@Getter
@Setter
@NoArgsConstructor

public class Aspirante  extends Usuario{

    @Column(name = "estado_aprobacion")
    private AprobacionEstado estadoAprobacion = AprobacionEstado.PENDIENTE;


}
