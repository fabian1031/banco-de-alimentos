package com.example.Entrega_proyecto_1.repository;

import com.example.Entrega_proyecto_1.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long> {
    Optional<Sesion> findByClienteIdAndEstado(Long clienteId, Sesion.EstadoSesion estado);
    List<Sesion> findByClienteId(Long clienteId);
}