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

    public TrabajadorSocial update(Long id, TrabajadorSocial datos) {
        TrabajadorSocial existente = trabajadorRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombre(datos.getNombre());
        existente.setCargo(datos.getCargo());
        existente.setCorreo(datos.getCorreo());
        return trabajadorRepository.save(existente);
    }

    public void delete(Long id) {
        trabajadorRepository.deleteById(id);
    }
}
