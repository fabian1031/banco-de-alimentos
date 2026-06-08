package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Alimento;
import com.example.Entrega_proyecto_1.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;

    @Autowired
    public AlimentoService(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }

    public List<Alimento> findAll() {
        return alimentoRepository.findAll();
    }

    public Alimento findById(Long id) {
        return alimentoRepository.findById(id).orElse(null);
    }

    public Alimento save(Alimento alimento) {
        // Verificar si el alimento está vencido al registrarlo
        if (alimento.getFechaVencimiento().isBefore(LocalDate.now())) {
            alimento.setEstadoApto("NO");
        } else {
            alimento.setEstadoApto("SI");
        }
        return alimentoRepository.save(alimento);
    }

    public List<Alimento> findAptos() {
        return alimentoRepository.findByEstadoApto("SI");
    }

    public void delete(Long id) {
        alimentoRepository.deleteById(id);
    }
}
