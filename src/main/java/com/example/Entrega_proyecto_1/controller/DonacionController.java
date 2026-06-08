package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.DTO.DonacionRequestDTO;
import com.example.Entrega_proyecto_1.DTO.DonacionResponseDTO;
import com.example.Entrega_proyecto_1.model.Donacion;
import com.example.Entrega_proyecto_1.model.Donante;
import com.example.Entrega_proyecto_1.service.DonacionService;
import com.example.Entrega_proyecto_1.service.DonanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/donaciones")
public class DonacionController {

    private final DonacionService donacionService;
    private final DonanteService donanteService;

    @Autowired
    public DonacionController(DonacionService donacionService, DonanteService donanteService) {
        this.donacionService = donacionService;
        this.donanteService = donanteService;
    }

    @GetMapping
    public ResponseEntity<List<DonacionResponseDTO>> getAll() {
        List<DonacionResponseDTO> lista = donacionService.findAll()
                .stream()
                .map(DonacionResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonacionResponseDTO> getById(@PathVariable Long id) {
        Donacion donacion = donacionService.findById(id);
        if (donacion == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(DonacionResponseDTO.desde(donacion));
    }

    @PostMapping
    public ResponseEntity<DonacionResponseDTO> registrar(@RequestBody DonacionRequestDTO dto) {
        Donante donante = donanteService.findById(dto.getDonanteId());
        if (donante == null) return ResponseEntity.notFound().build();
        Donacion donacion = donacionService.registrar(donante, dto.getTotalItems());
        return ResponseEntity.status(HttpStatus.CREATED).body(DonacionResponseDTO.desde(donacion));
    }

    @GetMapping("/donante/{donanteId}")
    public ResponseEntity<List<DonacionResponseDTO>> getByDonante(@PathVariable Long donanteId) {
        List<DonacionResponseDTO> lista = donacionService.findByDonante(donanteId)
                .stream()
                .map(DonacionResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        donacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
