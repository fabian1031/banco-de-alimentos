package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Donante;
import com.example.Entrega_proyecto_1.repository.DonanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonanteService {

    private final DonanteRepository donanteRepository;

    @Autowired
    public DonanteService(DonanteRepository donanteRepository) {
        this.donanteRepository = donanteRepository;
    }

    public List<Donante> findAll() {
        return donanteRepository.findAll();
    }

    public Donante findById(Long id) {
        return donanteRepository.findById(id).orElse(null);
    }

    public Donante save(Donante donante) {
        return donanteRepository.save(donante);
    }

    public Donante update(Long id, Donante datos) {
        Donante existente = donanteRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombreDonante(datos.getNombreDonante());
        existente.setTipoDonante(datos.getTipoDonante());
        existente.setNitDocumento(datos.getNitDocumento());
        existente.setTelefono(datos.getTelefono());
        return donanteRepository.save(existente);
    }

    public void delete(Long id) {
        donanteRepository.deleteById(id);
    }
}
