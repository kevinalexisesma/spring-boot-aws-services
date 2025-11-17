package com.example.serviciosAws.serviciosAws.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaRequest {

    @NotBlank(message = "Número de identificacion es requerido")
    private String numeroIdentificacion;

    @NotBlank(message = "nombre es requerido")
    private String nombre;

    @NotBlank(message = "email es requerido")
    @Email(message = "email debe ser válido")
    private String email;
}