package com.example.Entrega_proyecto_1.repository;

import com.example.Entrega_proyecto_1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByUsuario(String usuario);
    Optional<Cliente> findByUsuarioAndContrasena(String usuario, String contrasena);
}