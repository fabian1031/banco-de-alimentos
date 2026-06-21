package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Alimento;
import com.example.Entrega_proyecto_1.model.DetalleEntrega;
import com.example.Entrega_proyecto_1.model.EntregaAyuda;
import com.example.Entrega_proyecto_1.repository.DetalleEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetalleEntregaService {

    private final DetalleEntregaRepository detalleRepository;

    @Autowired
    public DetalleEntregaService(DetalleEntregaRepository detalleRepository) {
        this.detalleRepository = detalleRepository;
    }

    public List<DetalleEntrega> findByEntrega(Long entregaId) {
        return detalleRepository.findByEntregaId(entregaId);
    }

    public DetalleEntrega findById(Long id) {
        return detalleRepository.findById(id).orElse(null);
    }

    public DetalleEntrega save(EntregaAyuda entrega, Alimento alimento, BigDecimal cantidad) {
        DetalleEntrega detalle = new DetalleEntrega();
        detalle.setEntrega(entrega);
        detalle.setAlimento(alimento);
        detalle.setCantidad(cantidad);
        return detalleRepository.save(detalle);
    }

    public void delete(Long id) {
        detalleRepository.deleteById(id);
    }
}
