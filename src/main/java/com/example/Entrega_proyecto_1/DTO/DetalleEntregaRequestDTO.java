package com.example.Entrega_proyecto_1.DTO;

import java.math.BigDecimal;

public class DetalleEntregaRequestDTO {

    private Long entregaId;
    private Long alimentoId;
    private BigDecimal cantidad;

    public Long getEntregaId() { return entregaId; }
    public void setEntregaId(Long entregaId) { this.entregaId = entregaId; }

    public Long getAlimentoId() { return alimentoId; }
    public void setAlimentoId(Long alimentoId) { this.alimentoId = alimentoId; }

    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
}
