package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.DTO.DetalleDonacionRequestDTO;
import com.example.Entrega_proyecto_1.DTO.DetalleDonacionResponseDTO;
import com.example.Entrega_proyecto_1.model.Alimento;
import com.example.Entrega_proyecto_1.model.DetalleDonacion;
import com.example.Entrega_proyecto_1.model.Donacion;
import com.example.Entrega_proyecto_1.service.AlimentoService;
import com.example.Entrega_proyecto_1.service.DetalleDonacionService;
import com.example.Entrega_proyecto_1.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalle-donaciones")
public class DetalleDonacionController {

    private final DetalleDonacionService detalleService;
    private final DonacionService donacionService;
    private final AlimentoService alimentoService;

    @Autowired
    public DetalleDonacionController(DetalleDonacionService detalleService,
                                     DonacionService donacionService,
                                     AlimentoService alimentoService) {
        this.detalleService = detalleService;
        this.donacionService = donacionService;
        this.alimentoService = alimentoService;
    }

    @GetMapping("/donacion/{donacionId}")
    public ResponseEntity<List<DetalleDonacionResponseDTO>> getByDonacion(@PathVariable Long donacionId) {
        List<DetalleDonacionResponseDTO> lista = detalleService.findByDonacion(donacionId)
                .stream()
                .map(DetalleDonacionResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleDonacionResponseDTO> getById(@PathVariable Long id) {
        DetalleDonacion detalle = detalleService.findById(id);
        if (detalle == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(DetalleDonacionResponseDTO.desde(detalle));
    }

    @PostMapping
    public ResponseEntity<DetalleDonacionResponseDTO> crear(@RequestBody DetalleDonacionRequestDTO dto) {
        Donacion donacion = donacionService.findById(dto.getDonacionId());
        Alimento alimento = alimentoService.findById(dto.getAlimentoId());
        if (donacion == null || alimento == null) return ResponseEntity.notFound().build();
        DetalleDonacion detalle = detalleService.save(donacion, alimento, dto.getCantidad());
        return ResponseEntity.status(HttpStatus.CREATED).body(DetalleDonacionResponseDTO.desde(detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
