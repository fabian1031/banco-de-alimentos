package com.example.Entrega_proyecto_1.DTO;

import com.example.Entrega_proyecto_1.model.DetalleEntrega;

import java.math.BigDecimal;

public class DetalleEntregaResponseDTO {

    private Long id;
    private Long entregaId;
    private String nombreAlimento;
    private String tipoAlimento;
    private String unidadMedida;
    private BigDecimal cantidad;

    public static DetalleEntregaResponseDTO desde(DetalleEntrega d) {
        DetalleEntregaResponseDTO dto = new DetalleEntregaResponseDTO();
        dto.setId(d.getId());
        dto.setEntregaId(d.getEntrega().getId());
        dto.setNombreAlimento(d.getAlimento().getNombreAlimento());
        dto.setTipoAlimento(d.getAlimento().getTipo());
        dto.setUnidadMedida(d.getAlimento().getUnidadMedida());
        dto.setCantidad(d.getCantidad());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEntregaId() { return entregaId; }
    public void setEntregaId(Long entregaId) { this.entregaId = entregaId; }

    public String getNombreAlimento() { return nombreAlimento; }
    public void setNombreAlimento(String nombreAlimento) { this.nombreAlimento = nombreAlimento; }

    public String getTipoAlimento() { return tipoAlimento; }
    public void setTipoAlimento(String tipoAlimento) { this.tipoAlimento = tipoAlimento; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
}
