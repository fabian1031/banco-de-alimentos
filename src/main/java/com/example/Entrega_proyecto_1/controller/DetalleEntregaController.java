package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.DTO.DetalleEntregaRequestDTO;
import com.example.Entrega_proyecto_1.DTO.DetalleEntregaResponseDTO;
import com.example.Entrega_proyecto_1.model.Alimento;
import com.example.Entrega_proyecto_1.model.DetalleEntrega;
import com.example.Entrega_proyecto_1.model.EntregaAyuda;
import com.example.Entrega_proyecto_1.service.AlimentoService;
import com.example.Entrega_proyecto_1.service.DetalleEntregaService;
import com.example.Entrega_proyecto_1.service.EntregaAyudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalle-entregas")
public class DetalleEntregaController {

    private final DetalleEntregaService detalleService;
    private final EntregaAyudaService entregaService;
    private final AlimentoService alimentoService;

    @Autowired
    public DetalleEntregaController(DetalleEntregaService detalleService,
                                    EntregaAyudaService entregaService,
                                    AlimentoService alimentoService) {
        this.detalleService = detalleService;
        this.entregaService = entregaService;
        this.alimentoService = alimentoService;
    }

    @GetMapping("/entrega/{entregaId}")
    public ResponseEntity<List<DetalleEntregaResponseDTO>> getByEntrega(@PathVariable Long entregaId) {
        List<DetalleEntregaResponseDTO> lista = detalleService.findByEntrega(entregaId)
                .stream()
                .map(DetalleEntregaResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleEntregaResponseDTO> getById(@PathVariable Long id) {
        DetalleEntrega detalle = detalleService.findById(id);
        if (detalle == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(DetalleEntregaResponseDTO.desde(detalle));
    }

    @PostMapping
    public ResponseEntity<DetalleEntregaResponseDTO> crear(@RequestBody DetalleEntregaRequestDTO dto) {
        EntregaAyuda entrega = entregaService.findById(dto.getEntregaId());
        Alimento alimento = alimentoService.findById(dto.getAlimentoId());
        if (entrega == null || alimento == null) return ResponseEntity.notFound().build();
        DetalleEntrega detalle = detalleService.save(entrega, alimento, dto.getCantidad());
        return ResponseEntity.status(HttpStatus.CREATED).body(DetalleEntregaResponseDTO.desde(detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
