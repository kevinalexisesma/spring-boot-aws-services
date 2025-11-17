package com.example.serviciosAws.serviciosAws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiError {

    private String type; // link al tipo de error (puede ser about:blank)
    private String title; // resumen del error
    private int status; // código HTTP
    private String detail; // mensaje descriptivo
    private String instance; // la URL invocada

    public ApiError(String title, int status, String detail, String instance) {
        this.type = "about:blank";
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.instance = instance;
    }

}