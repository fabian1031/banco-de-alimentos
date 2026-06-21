package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.model.Alimento;
import com.example.Entrega_proyecto_1.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

    private final AlimentoService alimentoService;

    @Autowired
    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    @GetMapping
    public ResponseEntity<List<Alimento>> getAll() {
        return ResponseEntity.ok(alimentoService.findAll());
    }

    @GetMapping("/aptos")
    public ResponseEntity<List<Alimento>> getAptos() {
        return ResponseEntity.ok(alimentoService.findAptos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimento> getById(@PathVariable Long id) {
        Alimento alimento = alimentoService.findById(id);
        if (alimento == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(alimento);
    }

    @PostMapping
    public ResponseEntity<Alimento> crear(@RequestBody Alimento alimento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alimentoService.save(alimento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alimento> actualizar(@PathVariable Long id, @RequestBody Alimento datos) {
        Alimento resultado = alimentoService.update(id, datos);
        if (resultado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
