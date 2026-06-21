package com.example.Entrega_proyecto_1.DTO;

import com.example.Entrega_proyecto_1.model.DetalleDonacion;

import java.math.BigDecimal;

public class DetalleDonacionResponseDTO {

    private Long id;
    private Long donacionId;
    private String nombreAlimento;
    private String tipoAlimento;
    private String unidadMedida;
    private BigDecimal cantidad;

    public static DetalleDonacionResponseDTO desde(DetalleDonacion d) {
        DetalleDonacionResponseDTO dto = new DetalleDonacionResponseDTO();
        dto.setId(d.getId());
        dto.setDonacionId(d.getDonacion().getId());
        dto.setNombreAlimento(d.getAlimento().getNombreAlimento());
        dto.setTipoAlimento(d.getAlimento().getTipo());
        dto.setUnidadMedida(d.getAlimento().getUnidadMedida());
        dto.setCantidad(d.getCantidad());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getDonacionId() { return donacionId; }
    public void setDonacionId(Long donacionId) { this.donacionId = donacionId; }

    public String getNombreAlimento() { return nombreAlimento; }
    public void setNombreAlimento(String nombreAlimento) { this.nombreAlimento = nombreAlimento; }

    public String getTipoAlimento() { return tipoAlimento; }
    public void setTipoAlimento(String tipoAlimento) { this.tipoAlimento = tipoAlimento; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
}
