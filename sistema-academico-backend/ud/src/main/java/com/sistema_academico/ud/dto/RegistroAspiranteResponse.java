package com.sistema_academico.ud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistroAspiranteResponse {
    private Long aspiranteId;
    private String username;
    private String token; // token en texto plano SOLO para mostrar al usuario en popup
}