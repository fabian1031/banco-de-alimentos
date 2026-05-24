package com.example.Entrega_proyecto_1.DTO;

import com.example.Entrega_proyecto_1.model.Mensaje;
import java.time.LocalDateTime;

public class MensajeResponseDTO {

    public Long id;
    public String contenido;
    public String remitenteUsuario;
    public String destinatarioUsuario;
    public LocalDateTime fechaEnvio;
    public String estado;

    public static MensajeResponseDTO desde(Mensaje mensaje) {
        MensajeResponseDTO dto = new MensajeResponseDTO();
        dto.id = mensaje.getId();
        dto.contenido = mensaje.getContenido();
        dto.remitenteUsuario = mensaje.getRemitente().getUsuario();
        dto.destinatarioUsuario = mensaje.getDestinatario().getUsuario();
        dto.fechaEnvio = mensaje.getFechaEnvio();
        dto.estado = mensaje.getEstado().name();
        return dto;
    }
}