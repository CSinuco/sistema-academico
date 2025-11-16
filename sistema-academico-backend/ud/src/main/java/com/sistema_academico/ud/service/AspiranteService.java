package com.sistema_academico.ud.service;


import com.sistema_academico.ud.dto.PreinscripcionDTO;
import com.sistema_academico.ud.dto.RegistroAspiranteResponse;
import com.sistema_academico.ud.entity.Aspirante;
import com.sistema_academico.ud.entity.UserRole;
import com.sistema_academico.ud.repository.AspiranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@Service
public class AspiranteService {

    private final AspiranteRepository aspiranteRepository;
    private final PasswordEncoder passwordEncoder;

    public AspiranteService(AspiranteRepository aspiranteRepository, PasswordEncoder passwordEncoder) {
        this.aspiranteRepository = aspiranteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registra la preinscripción (CU25):
     *  - Genera username único (nombre-apellido)
     *  - Genera token temporal (texto) y lo hashea para guardarlo en password
     *  - Crea entidad Aspirante con mustChangePassword = true
     *  - Retorna (id, username, token plain) para que frontend muestre popup
     */
    @Transactional
    public RegistroAspiranteResponse registrarPreinscripcion(PreinscripcionDTO dto) {
        // Validar correo único entre aspirantes y (si aplicase) acudientes:
        Optional<Aspirante> byCorreo = aspiranteRepository.findByCorreo(dto.getCorreo());
        if (byCorreo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un aspirante con ese correo");
        }

        String usernameBase = buildUsername(dto.getNombre(), dto.getApellido());
        String username = ensureUsernameUnique(usernameBase);

        String token = generateToken(8); // texto que se devolverá al frontend
        String hashed = passwordEncoder.encode(token);

        Aspirante aspirante = new Aspirante();
        aspirante.setNombre(dto.getNombre());
        aspirante.setApellido(dto.getApellido());
        aspirante.setCorreo(dto.getCorreo());
        aspirante.setUserName(username);
        aspirante.setPassword(hashed);
        aspirante.setRol(UserRole.ROLE_ASPIRANTE);
        aspirante.setCambiarPassword(true);
        aspirante.setActivo(true);


        aspiranteRepository.save(aspirante);

        return new RegistroAspiranteResponse(aspirante.getId(), username, token);
    }

    private String buildUsername(String nombres, String apellidos) {
        String combined = (nombres + " " + apellidos).toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9\\s-]", "") // elimina caracteres no alfanuméricos
                .trim()
                .replaceAll("\\s+", "-");
        if (combined.length() == 0) combined = "user";
        return combined;
    }

    private String ensureUsernameUnique(String base) {
        String candidate = base;
        int i = 0;
        while (aspiranteRepository.findByUserName(candidate).isPresent()) {
            i++;
            candidate = base + "-" + i;
            if (i > 1000) { // safety
                candidate = base + "-" + System.currentTimeMillis();
                break;
            }
        }
        return candidate;
    }

    private String generateToken(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rng = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rng.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
