package com.example.Entrega_proyecto_1.repository;

import com.example.Entrega_proyecto_1.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    List<Alimento> findByEstadoApto(String estadoApto);
}
