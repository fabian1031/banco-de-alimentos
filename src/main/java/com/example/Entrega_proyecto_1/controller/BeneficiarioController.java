package com.example.Entrega_proyecto_1.controller;

import com.example.Entrega_proyecto_1.model.Beneficiario;
import com.example.Entrega_proyecto_1.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    @Autowired
    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping
    public ResponseEntity<List<Beneficiario>> getAll() {
        return ResponseEntity.ok(beneficiarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> getById(@PathVariable Long id) {
        Beneficiario b = beneficiarioService.findById(id);
        if (b == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);
    }

    @PostMapping
    public ResponseEntity<Beneficiario> crear(@RequestBody Beneficiario beneficiario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beneficiarioService.save(beneficiario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiario> actualizar(@PathVariable Long id, @RequestBody Beneficiario datos) {
        Beneficiario resultado = beneficiarioService.update(id, datos);
        if (resultado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/vulnerabilidad/{nivel}")
    public ResponseEntity<List<Beneficiario>> getByVulnerabilidad(@PathVariable String nivel) {
        return ResponseEntity.ok(beneficiarioService.findByVulnerabilidad(nivel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        beneficiarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
