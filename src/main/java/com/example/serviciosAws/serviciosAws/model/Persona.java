package com.example.serviciosAws.serviciosAws.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personas", uniqueConstraints = {
        @UniqueConstraint(columnNames = "numeroIdentificacion")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String numeroIdentificacion;

    @Column(nullable = false)
    @NotBlank
    private String nombre;

    @Column(nullable = false)
    @Email
    private String email;

    public Persona(String numeroIdentificacion, String nombre, String email) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.email = email;
    }
}