package com.example.Entrega_proyecto_1.controller;


import com.example.Entrega_proyecto_1.DTO.SesionResponseDTO;
import com.example.Entrega_proyecto_1.model.Cliente;
import com.example.Entrega_proyecto_1.model.Sesion;
import com.example.Entrega_proyecto_1.service.ClienteService;
import com.example.Entrega_proyecto_1.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sesiones")
public class SesionController {

    private final SesionService sesionService;
    private final ClienteService clienteService;

    @Autowired
    public SesionController(SesionService sesionService, ClienteService clienteService) {
        this.sesionService = sesionService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<SesionResponseDTO>> getAll() {
        List<SesionResponseDTO> lista = sesionService.findAll()
                .stream()
                .map(SesionResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionResponseDTO> getById(@PathVariable Long id) {
        Sesion sesion = sesionService.findById(id);
        if (sesion == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(SesionResponseDTO.desde(sesion));
    }

    @PostMapping("/iniciar/{clienteId}")
    public ResponseEntity<SesionResponseDTO> iniciar(@PathVariable Long clienteId) {
        Cliente cliente = clienteService.findById(clienteId);
        if (cliente == null) return ResponseEntity.notFound().build();
        if (sesionService.tieneSesionActiva(clienteId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        cliente.setEstado(Cliente.EstadoCliente.AUTENTICADO);
        clienteService.save(cliente);
        Sesion sesion = sesionService.iniciarSesion(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(SesionResponseDTO.desde(sesion));
    }

    @PatchMapping("/cerrar/{clienteId}")
    public ResponseEntity<SesionResponseDTO> cerrar(@PathVariable Long clienteId) {
        Cliente cliente = clienteService.findById(clienteId);
        if (cliente == null) return ResponseEntity.notFound().build();
        Sesion sesion = sesionService.cerrarSesion(clienteId);
        if (sesion == null) return ResponseEntity.notFound().build();
        cliente.setEstado(Cliente.EstadoCliente.DESCONECTADO);
        clienteService.save(cliente);
        return ResponseEntity.ok(SesionResponseDTO.desde(sesion));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<SesionResponseDTO>> getByCliente(@PathVariable Long clienteId) {
        List<SesionResponseDTO> lista = sesionService.findByCliente(clienteId)
                .stream()
                .map(SesionResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        sesionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}