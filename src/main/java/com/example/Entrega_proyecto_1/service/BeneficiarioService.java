package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Beneficiario;
import com.example.Entrega_proyecto_1.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    @Autowired
    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    public List<Beneficiario> findAll() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario findById(Long id) {
        return beneficiarioRepository.findById(id).orElse(null);
    }

    public Beneficiario save(Beneficiario beneficiario) {
        beneficiario.setEstado("ACTIVO");
        return beneficiarioRepository.save(beneficiario);
    }

    public Beneficiario update(Long id, Beneficiario datos) {
        Beneficiario existente = beneficiarioRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombre(datos.getNombre());
        existente.setApellido(datos.getApellido());
        existente.setNivelVulnerabilidad(datos.getNivelVulnerabilidad());
        existente.setNumeroIntegrantes(datos.getNumeroIntegrantes());
        existente.setEstado(datos.getEstado());
        return beneficiarioRepository.save(existente);
    }

    public List<Beneficiario> findByVulnerabilidad(String nivel) {
        return beneficiarioRepository.findByNivelVulnerabilidad(nivel);
    }

    public void delete(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}
