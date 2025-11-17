package com.example.serviciosAws.serviciosAws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.serviciosAws.serviciosAws.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByNumeroIdentificacion(String numeroIdentificacion);

    boolean existsByNumeroIdentificacion(String numeroIdentificacion);
}