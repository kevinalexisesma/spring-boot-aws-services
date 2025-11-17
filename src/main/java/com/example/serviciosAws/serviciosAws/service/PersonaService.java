package com.example.serviciosAws.serviciosAws.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.serviciosAws.serviciosAws.model.Persona;
import com.example.serviciosAws.serviciosAws.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repo;

    @Transactional
    public Persona guardar(Persona persona) {
        if (repo.existsByNumeroIdentificacion(persona.getNumeroIdentificacion())) {
            throw new IllegalArgumentException("La identificación ya existe");
        }
        return repo.save(persona);
    }

    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNumeroIdentificacion(String idNumber) {
        return repo.findByNumeroIdentificacion(idNumber);
    }
}
