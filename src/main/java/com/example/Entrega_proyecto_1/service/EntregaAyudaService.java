package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Beneficiario;
import com.example.Entrega_proyecto_1.model.EntregaAyuda;
import com.example.Entrega_proyecto_1.model.TrabajadorSocial;
import com.example.Entrega_proyecto_1.repository.EntregaAyudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntregaAyudaService {

    private final EntregaAyudaRepository entregaRepository;

    @Autowired
    public EntregaAyudaService(EntregaAyudaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public List<EntregaAyuda> findAll() {
        return entregaRepository.findAll();
    }

    public EntregaAyuda findById(Long id) {
        return entregaRepository.findById(id).orElse(null);
    }

    public EntregaAyuda registrar(Beneficiario beneficiario, TrabajadorSocial trabajador, String observaciones) {
        EntregaAyuda entrega = new EntregaAyuda();
        entrega.setBeneficiario(beneficiario);
        entrega.setTrabajador(trabajador);
        entrega.setFechaEntrega(LocalDate.now());
        entrega.setObservaciones(observaciones);
        return entregaRepository.save(entrega);
    }

    public List<EntregaAyuda> findByBeneficiario(Long beneficiarioId) {
        return entregaRepository.findByBeneficiarioId(beneficiarioId);
    }

    public EntregaAyuda update(Long id, String observaciones) {
        EntregaAyuda existente = entregaRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setObservaciones(observaciones);
        return entregaRepository.save(existente);
    }

    public void delete(Long id) {
        entregaRepository.deleteById(id);
    }
}
