package com.donaton.necesidades.model;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class NecesidadTerreno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zona;

    private String tipoRecurso;

    private Integer cantidadSolicitada;

    private String prioridad;

    private String estado;

    private Long usuarioReportaId;

    private LocalDateTime fechaRegistro = LocalDateTime.now();
}