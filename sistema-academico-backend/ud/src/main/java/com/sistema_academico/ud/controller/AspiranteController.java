package com.sistema_academico.ud.controller;


import com.sistema_academico.ud.dto.PreinscripcionDTO;
import com.sistema_academico.ud.dto.RegistroAspiranteResponse;
import com.sistema_academico.ud.service.AspiranteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aspirantes")
public class AspiranteController {

    private final AspiranteService aspiranteService;

    public AspiranteController(AspiranteService aspiranteService) {
        this.aspiranteService = aspiranteService;
    }

    /**
     * POST /api/aspirantes/registro
     * Body: PreinscripcionDTO
     * Response: 201 { aspiranteId, username, token }
     * (Frontend debe mostrar token en popup)
     */
    @PostMapping("/registro")
    public ResponseEntity<RegistroAspiranteResponse> registrar(@Valid @RequestBody PreinscripcionDTO dto) {
        RegistroAspiranteResponse res = aspiranteService.registrarPreinscripcion(dto);
        return ResponseEntity.status(201).body(res);
    }
}
