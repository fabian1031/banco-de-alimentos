package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Donacion;
import com.example.Entrega_proyecto_1.model.Donante;
import com.example.Entrega_proyecto_1.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DonacionService {

    private final DonacionRepository donacionRepository;

    @Autowired
    public DonacionService(DonacionRepository donacionRepository) {
        this.donacionRepository = donacionRepository;
    }

    public List<Donacion> findAll() {
        return donacionRepository.findAll();
    }

    public Donacion findById(Long id) {
        return donacionRepository.findById(id).orElse(null);
    }

    public Donacion registrar(Donante donante, Integer totalItems) {
        Donacion donacion = new Donacion();
        donacion.setDonante(donante);
        donacion.setFechaDonacion(LocalDate.now());
        donacion.setTotalItems(totalItems);
        return donacionRepository.save(donacion);
    }

    public List<Donacion> findByDonante(Long donanteId) {
        return donacionRepository.findByDonanteId(donanteId);
    }

    public Donacion update(Long id, Integer totalItems) {
        Donacion existente = donacionRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setTotalItems(totalItems);
        return donacionRepository.save(existente);
    }

    public void delete(Long id) {
        donacionRepository.deleteById(id);
    }
}
