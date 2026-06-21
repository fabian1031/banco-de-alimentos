package com.example.Entrega_proyecto_1.DTO;

import java.math.BigDecimal;

public class DetalleDonacionRequestDTO {

    private Long donacionId;
    private Long alimentoId;
    private BigDecimal cantidad;

    public Long getDonacionId() { return donacionId; }
    public void setDonacionId(Long donacionId) { this.donacionId = donacionId; }

    public Long getAlimentoId() { return alimentoId; }
    public void setAlimentoId(Long alimentoId) { this.alimentoId = alimentoId; }

    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
}
