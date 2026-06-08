package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.TrabajadorSocial;
import com.example.Entrega_proyecto_1.repository.TrabajadorSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorSocialService {

    private final TrabajadorSocialRepository trabajadorRepository;

    @Autowired
    public TrabajadorSocialService(TrabajadorSocialRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    public List<TrabajadorSocial> findAll() {
        return trabajadorRepository.findAll();
    }

    public TrabajadorSocial findById(Long id) {
        return trabajadorRepository.findById(id).orElse(null);
    }

    public TrabajadorSocial save(TrabajadorSocial trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public void delete(Long id) {
        trabajadorRepository.deleteById(id);
    }
}
