package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.DTO.EntregaAyudaResponseDTO;
import com.example.Entrega_proyecto_1.model.Beneficiario;
import com.example.Entrega_proyecto_1.model.EntregaAyuda;
import com.example.Entrega_proyecto_1.model.TrabajadorSocial;
import com.example.Entrega_proyecto_1.service.BeneficiarioService;
import com.example.Entrega_proyecto_1.service.EntregaAyudaService;
import com.example.Entrega_proyecto_1.service.TrabajadorSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entregas")
public class EntregaAyudaController {

    private final EntregaAyudaService entregaService;
    private final BeneficiarioService beneficiarioService;
    private final TrabajadorSocialService trabajadorService;

    @Autowired
    public EntregaAyudaController(EntregaAyudaService entregaService,
                                   BeneficiarioService beneficiarioService,
                                   TrabajadorSocialService trabajadorService) {
        this.entregaService = entregaService;
        this.beneficiarioService = beneficiarioService;
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public ResponseEntity<List<EntregaAyudaResponseDTO>> getAll() {
        List<EntregaAyudaResponseDTO> lista = entregaService.findAll()
                .stream()
                .map(EntregaAyudaResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaAyudaResponseDTO> getById(@PathVariable Long id) {
        EntregaAyuda entrega = entregaService.findById(id);
        if (entrega == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(EntregaAyudaResponseDTO.desde(entrega));
    }

    @PostMapping
    public ResponseEntity<EntregaAyudaResponseDTO> registrar(@RequestBody Map<String, Object> body) {
        Long beneficiarioId = Long.valueOf(body.get("beneficiarioId").toString());
        Long trabajadorId = Long.valueOf(body.get("trabajadorId").toString());
        String observaciones = body.getOrDefault("observaciones", "").toString();

        Beneficiario beneficiario = beneficiarioService.findById(beneficiarioId);
        TrabajadorSocial trabajador = trabajadorService.findById(trabajadorId);

        if (beneficiario == null || trabajador == null) return ResponseEntity.notFound().build();

        EntregaAyuda entrega = entregaService.registrar(beneficiario, trabajador, observaciones);
        return ResponseEntity.status(HttpStatus.CREATED).body(EntregaAyudaResponseDTO.desde(entrega));
    }

    @GetMapping("/beneficiario/{id}")
    public ResponseEntity<List<EntregaAyudaResponseDTO>> getByBeneficiario(@PathVariable Long id) {
        List<EntregaAyudaResponseDTO> lista = entregaService.findByBeneficiario(id)
                .stream()
                .map(EntregaAyudaResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        entregaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
