package com.example.Entrega_proyecto_1.repository;

import com.example.Entrega_proyecto_1.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    List<Beneficiario> findByNivelVulnerabilidad(String nivelVulnerabilidad);
    List<Beneficiario> findByEstado(String estado);
}
