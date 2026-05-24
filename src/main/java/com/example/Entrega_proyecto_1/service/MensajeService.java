package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.model.Cliente;
import com.example.Entrega_proyecto_1.model.Mensaje;
import com.example.Entrega_proyecto_1.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeService {

    private final MensajeRepository mensajeRepository;

    @Autowired
    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    public List<Mensaje> findAll() {
        return mensajeRepository.findAll();
    }

    public Mensaje findById(Long id) {
        return mensajeRepository.findById(id).orElse(null);
    }

    public Mensaje enviar(Cliente remitente, Cliente destinatario, String contenido) {
        Mensaje mensaje = new Mensaje();
        mensaje.setRemitente(remitente);
        mensaje.setDestinatario(destinatario);
        mensaje.setContenido(contenido);
        mensaje.setFechaEnvio(LocalDateTime.now());
        mensaje.setEstado(Mensaje.EstadoMensaje.ENVIADO);
        return mensajeRepository.save(mensaje);
    }

    public Mensaje confirmarRecepcion(Long id) {
        Mensaje mensaje = mensajeRepository.findById(id).orElse(null);
        if (mensaje == null) return null;
        mensaje.setEstado(Mensaje.EstadoMensaje.CONFIRMADO);
        return mensajeRepository.save(mensaje);
    }

    public List<Mensaje> findByDestinatario(Long destinatarioId) {
        return mensajeRepository.findByDestinatarioId(destinatarioId);
    }

    public List<Mensaje> findByRemitente(Long remitenteId) {
        return mensajeRepository.findByRemitenteId(remitenteId);
    }

    public void delete(Long id) {
        mensajeRepository.deleteById(id);
    }
}