package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Cliente;
import com.example.Entrega_proyecto_1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente datos) {
        Cliente existente = clienteRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setUsuario(datos.getUsuario());
        existente.setContrasena(datos.getContrasena());
        existente.setDireccionIp(datos.getDireccionIp());
        existente.setEstado(datos.getEstado());
        return clienteRepository.save(existente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente autenticar(String usuario, String contrasena) {
        return clienteRepository.findByUsuarioAndContrasena(usuario, contrasena).orElse(null);
    }
}