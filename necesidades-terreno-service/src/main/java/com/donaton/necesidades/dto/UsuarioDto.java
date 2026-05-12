package com.donaton.necesidades.dto;

import lombok.Data;

@Data
public class UsuarioDto {

    private Long id;

    private String nombre;

    private String correo;

    private String rol;
}