package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Cliente;
import com.example.Entrega_proyecto_1.model.Sesion;
import com.example.Entrega_proyecto_1.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SesionService {

    private final SesionRepository sesionRepository;

    @Autowired
    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    public List<Sesion> findAll() {
        return sesionRepository.findAll();
    }

    public Sesion findById(Long id) {
        return sesionRepository.findById(id).orElse(null);
    }

    public Sesion iniciarSesion(Cliente cliente) {
        Sesion sesion = new Sesion();
        sesion.setCliente(cliente);
        sesion.setFechaInicio(LocalDateTime.now());
        sesion.setEstado(Sesion.EstadoSesion.ACTIVA);
        return sesionRepository.save(sesion);
    }

    public Sesion cerrarSesion(Long clienteId) {
        Sesion sesion = sesionRepository
                .findByClienteIdAndEstado(clienteId, Sesion.EstadoSesion.ACTIVA)
                .orElse(null);
        if (sesion == null) return null;
        sesion.setFechaCierre(LocalDateTime.now());
        sesion.setEstado(Sesion.EstadoSesion.CERRADA);
        return sesionRepository.save(sesion);
    }

    public List<Sesion> findByCliente(Long clienteId) {
        return sesionRepository.findByClienteId(clienteId);
    }

    public boolean tieneSesionActiva(Long clienteId) {
        return sesionRepository
                .findByClienteIdAndEstado(clienteId, Sesion.EstadoSesion.ACTIVA)
                .isPresent();
    }

    public void delete(Long id) {
        sesionRepository.deleteById(id);
    }
}