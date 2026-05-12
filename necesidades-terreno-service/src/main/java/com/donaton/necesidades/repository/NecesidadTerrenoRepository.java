package com.donaton.necesidades.repository;

import com.donaton.necesidades.model.NecesidadTerreno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NecesidadTerrenoRepository
        extends JpaRepository<NecesidadTerreno, Long> {

    List<NecesidadTerreno> findByEstado(String estado);

    List<NecesidadTerreno> findByPrioridad(String prioridad);

}