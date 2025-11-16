package com.sistema_academico.ud.repository;

import com.sistema_academico.ud.entity.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante,Long> {
    Optional<Aspirante> findByUserName (String username);
    Optional<Aspirante> findByCorreo(String correo);

}
