package com.donaton.necesidades.service;

import com.donaton.necesidades.dto.UsuarioDto;
import com.donaton.necesidades.model.NecesidadTerreno;
import com.donaton.necesidades.repository.NecesidadTerrenoRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NecesidadTerrenoService {

    private final NecesidadTerrenoRepository repo;
    private final RestTemplate rest;

    @Value("${usuarios.service.url}")
    private String usuariosUrl;

    public NecesidadTerrenoService(
            NecesidadTerrenoRepository repo,
            RestTemplate rest
    ) {
        this.repo = repo;
        this.rest = rest;
    }

    public List<NecesidadTerreno> listar() {
        return repo.findAll();
    }

    public NecesidadTerreno buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public NecesidadTerreno guardar(NecesidadTerreno n) {
        return repo.save(n);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<NecesidadTerreno> porEstado(String e) {
        return repo.findByEstado(e);
    }

    public UsuarioDto obtenerUsuarioReporta(Long usuarioId) {
        return rest.getForObject(
                usuariosUrl + "/" + usuarioId,
                UsuarioDto.class
        );
    }
}