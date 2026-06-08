package com.example.Entrega_proyecto_1.repository;

import com.example.Entrega_proyecto_1.model.EntregaAyuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregaAyudaRepository extends JpaRepository<EntregaAyuda, Long> {
    List<EntregaAyuda> findByBeneficiarioId(Long beneficiarioId);
    List<EntregaAyuda> findByTrabajadorId(Long trabajadorId);
}
