package com.example.Entrega_proyecto_1.DTO;

import com.example.Entrega_proyecto_1.model.Sesion;
import java.time.LocalDateTime;

public class SesionResponseDTO {

    public Long id;
    public String clienteUsuario;
    public LocalDateTime fechaInicio;
    public LocalDateTime fechaCierre;
    public String estado;

    public static SesionResponseDTO desde(Sesion sesion) {
        SesionResponseDTO dto = new SesionResponseDTO();
        dto.id = sesion.getId();
        dto.clienteUsuario = sesion.getCliente().getUsuario();
        dto.fechaInicio = sesion.getFechaInicio();
        dto.fechaCierre = sesion.getFechaCierre();
        dto.estado = sesion.getEstado().name();
        return dto;
    }
}