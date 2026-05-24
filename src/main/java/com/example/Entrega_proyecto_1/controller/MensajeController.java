package com.example.Entrega_proyecto_1.controller;


import com.example.Entrega_proyecto_1.DTO.MensajeRequestDTO;
import com.example.Entrega_proyecto_1.DTO.MensajeResponseDTO;
import com.example.Entrega_proyecto_1.model.Cliente;
import com.example.Entrega_proyecto_1.model.Mensaje;
import com.example.Entrega_proyecto_1.service.ClienteService;
import com.example.Entrega_proyecto_1.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    private final MensajeService mensajeService;
    private final ClienteService clienteService;

    @Autowired
    public MensajeController(MensajeService mensajeService, ClienteService clienteService) {
        this.mensajeService = mensajeService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<MensajeResponseDTO>> getAll() {
        List<MensajeResponseDTO> lista = mensajeService.findAll()
                .stream()
                .map(MensajeResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajeResponseDTO> getById(@PathVariable Long id) {
        Mensaje mensaje = mensajeService.findById(id);
        if (mensaje == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(MensajeResponseDTO.desde(mensaje));
    }

    @PostMapping
    public ResponseEntity<MensajeResponseDTO> enviar(@RequestBody MensajeRequestDTO dto) {
        Cliente remitente = clienteService.findById(dto.getRemitenteId());
        Cliente destinatario = clienteService.findById(dto.getDestinatarioId());
        if (remitente == null || destinatario == null) return ResponseEntity.notFound().build();
        Mensaje mensaje = mensajeService.enviar(remitente, destinatario, dto.getContenido());
        return ResponseEntity.status(HttpStatus.CREATED).body(MensajeResponseDTO.desde(mensaje));
    }

    @PatchMapping("/{id}/confirmar")
    public ResponseEntity<MensajeResponseDTO> confirmar(@PathVariable Long id) {
        Mensaje mensaje = mensajeService.confirmarRecepcion(id);
        if (mensaje == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(MensajeResponseDTO.desde(mensaje));
    }

    @GetMapping("/destinatario/{id}")
    public ResponseEntity<List<MensajeResponseDTO>> getByDestinatario(@PathVariable Long id) {
        List<MensajeResponseDTO> lista = mensajeService.findByDestinatario(id)
                .stream()
                .map(MensajeResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/remitente/{id}")
    public ResponseEntity<List<MensajeResponseDTO>> getByRemitente(@PathVariable Long id) {
        List<MensajeResponseDTO> lista = mensajeService.findByRemitente(id)
                .stream()
                .map(MensajeResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mensajeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
