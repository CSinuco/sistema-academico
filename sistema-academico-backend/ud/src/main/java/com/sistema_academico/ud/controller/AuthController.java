package com.sistema_academico.ud.controller;

import com.sistema_academico.ud.entity.Usuario;
import com.sistema_academico.ud.repository.UsuarioRepository;
import com.sistema_academico.ud.security.CustomUserDetailsService;
import com.sistema_academico.ud.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
        System.out.println(">>> LOGIN LLEGÓ AL CONTROLLER");
        String username = datos.get("username");
        String password = datos.get("password");

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        String jwt = jwtUtil.generarToken(userDetails);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("token", jwt);
        respuesta.put("rol", userDetails.getAuthorities().iterator().next().getAuthority());

        return ResponseEntity.ok(respuesta);
    }
}
