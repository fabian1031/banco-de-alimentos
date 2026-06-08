package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.model.Donante;
import com.example.Entrega_proyecto_1.service.DonanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donantes")
public class DonanteController {

    private final DonanteService donanteService;

    @Autowired
    public DonanteController(DonanteService donanteService) {
        this.donanteService = donanteService;
    }

    @GetMapping
    public ResponseEntity<List<Donante>> getAll() {
        return ResponseEntity.ok(donanteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donante> getById(@PathVariable Long id) {
        Donante donante = donanteService.findById(id);
        if (donante == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(donante);
    }

    @PostMapping
    public ResponseEntity<Donante> crear(@RequestBody Donante donante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(donanteService.save(donante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donante> actualizar(@PathVariable Long id, @RequestBody Donante datos) {
        Donante resultado = donanteService.update(id, datos);
        if (resultado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        donanteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
