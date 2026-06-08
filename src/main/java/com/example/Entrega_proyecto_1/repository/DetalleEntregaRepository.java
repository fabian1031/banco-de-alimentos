package com.example.Entrega_proyecto_1.repository;

import com.example.Entrega_proyecto_1.model.DetalleEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleEntregaRepository extends JpaRepository<DetalleEntrega, Long> {
    List<DetalleEntrega> findByEntregaId(Long entregaId);
}
