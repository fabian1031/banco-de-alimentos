package com.example.Entrega_proyecto_1.repository;

import com.example.Entrega_proyecto_1.model.TrabajadorSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorSocialRepository extends JpaRepository<TrabajadorSocial, Long> {
}
