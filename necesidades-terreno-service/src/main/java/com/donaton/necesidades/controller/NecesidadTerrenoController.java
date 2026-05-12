package com.donaton.necesidades.controller;

import com.donaton.necesidades.dto.UsuarioDto;
import com.donaton.necesidades.model.NecesidadTerreno;
import com.donaton.necesidades.service.NecesidadTerrenoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/necesidades")
@CrossOrigin("*")
public class NecesidadTerrenoController {

    private final NecesidadTerrenoService service;

    public NecesidadTerrenoController(
            NecesidadTerrenoService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<NecesidadTerreno> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public NecesidadTerreno buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public NecesidadTerreno crear(
            @RequestBody NecesidadTerreno n
    ) {
        return service.guardar(n);
    }

    @PutMapping("/{id}")
    public NecesidadTerreno actualizar(
            @PathVariable Long id,
            @RequestBody NecesidadTerreno n
    ) {
        n.setId(id);
        return service.guardar(n);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/estado/{estado}")
    public List<NecesidadTerreno> estado(
            @PathVariable String estado
    ) {
        return service.porEstado(estado);
    }

    @GetMapping("/{id}/usuario-reporta")
    public UsuarioDto usuarioReporta(
            @PathVariable Long id
    ) {
        return service.obtenerUsuarioReporta(
                service.buscar(id).getUsuarioReportaId()
        );
    }
}