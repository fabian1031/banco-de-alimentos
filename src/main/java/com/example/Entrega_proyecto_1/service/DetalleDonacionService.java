package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Alimento;
import com.example.Entrega_proyecto_1.model.DetalleDonacion;
import com.example.Entrega_proyecto_1.model.Donacion;
import com.example.Entrega_proyecto_1.repository.DetalleDonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetalleDonacionService {

    private final DetalleDonacionRepository detalleRepository;

    @Autowired
    public DetalleDonacionService(DetalleDonacionRepository detalleRepository) {
        this.detalleRepository = detalleRepository;
    }

    public List<DetalleDonacion> findByDonacion(Long donacionId) {
        return detalleRepository.findByDonacionId(donacionId);
    }

    public DetalleDonacion findById(Long id) {
        return detalleRepository.findById(id).orElse(null);
    }

    public DetalleDonacion save(Donacion donacion, Alimento alimento, BigDecimal cantidad) {
        DetalleDonacion detalle = new DetalleDonacion();
        detalle.setDonacion(donacion);
        detalle.setAlimento(alimento);
        detalle.setCantidad(cantidad);
        return detalleRepository.save(detalle);
    }

    public void delete(Long id) {
        detalleRepository.deleteById(id);
    }
}
