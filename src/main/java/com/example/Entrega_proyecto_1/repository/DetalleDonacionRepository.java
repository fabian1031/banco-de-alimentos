package com.example.Entrega_proyecto_1.repository;

import com.example.Entrega_proyecto_1.model.DetalleDonacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleDonacionRepository extends JpaRepository<DetalleDonacion, Long> {
    List<DetalleDonacion> findByDonacionId(Long donacionId);
}
