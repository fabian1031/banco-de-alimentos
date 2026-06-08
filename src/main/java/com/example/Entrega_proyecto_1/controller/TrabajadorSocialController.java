package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.model.TrabajadorSocial;
import com.example.Entrega_proyecto_1.service.TrabajadorSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorSocialController {

    private final TrabajadorSocialService trabajadorService;

    @Autowired
    public TrabajadorSocialController(TrabajadorSocialService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public ResponseEntity<List<TrabajadorSocial>> getAll() {
        return ResponseEntity.ok(trabajadorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorSocial> getById(@PathVariable Long id) {
        TrabajadorSocial t = trabajadorService.findById(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity<TrabajadorSocial> crear(@RequestBody TrabajadorSocial trabajador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorService.save(trabajador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        trabajadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
