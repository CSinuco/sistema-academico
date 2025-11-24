package com.sistema_academico.ud.security;

import com.sistema_academico.ud.entity.Usuario;
import com.sistema_academico.ud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no existe"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(usuario.getUserName())
                .password(usuario.getPassword())
                .authorities(usuario.getRol().name()) // ← ESTA ES LA LÍNEA CORRECTA
                .build();
    }
}



