package com.example.serviciosAws.serviciosAws.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.serviciosAws.serviciosAws.dto.ApiError;
import com.example.serviciosAws.serviciosAws.dto.PersonaRequest;
import com.example.serviciosAws.serviciosAws.model.Persona;
import com.example.serviciosAws.serviciosAws.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @PostMapping
    public ResponseEntity<?> guardarPersona(@Valid @RequestBody PersonaRequest req) {
        Persona p = new Persona(req.getNumeroIdentificacion(), req.getNombre(), req.getEmail());
        try {
            Persona saved = service.guardar(p);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/{identificationNumber}")
    public ResponseEntity<?> obtenerPorIdentificacion(
            @PathVariable String identificationNumber,
            HttpServletRequest req) {

        return service.buscarPorNumeroIdentificacion(identificationNumber)
                .<ResponseEntity<?>>map(persona -> ResponseEntity.ok(persona))
                .orElseGet(() -> {
                    ApiError error = new ApiError(
                            "Not Found",
                            HttpStatus.NOT_FOUND.value(),
                            "Persona no encontrada",
                            req.getRequestURI());
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
                });
    }

}