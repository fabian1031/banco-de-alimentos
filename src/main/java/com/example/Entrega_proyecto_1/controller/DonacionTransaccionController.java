package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.DTO.DonacionCompletaRequestDTO;
import com.example.Entrega_proyecto_1.DTO.DonacionResponseDTO;
import com.example.Entrega_proyecto_1.service.DonacionTransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donaciones/completa")
public class DonacionTransaccionController {

    private final DonacionTransaccionService transaccionService;

    @Autowired
    public DonacionTransaccionController(DonacionTransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping
    public ResponseEntity<?> registrarCompleta(@RequestBody DonacionCompletaRequestDTO dto) {
        try {
            DonacionResponseDTO respuesta = transaccionService.registrarDonacionCompleta(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
