package com.example.Entrega_proyecto_1.DTO;

public class EntregaAyudaRequestDTO {

    private Long beneficiarioId;
    private Long trabajadorId;
    private String observaciones;

    public Long getBeneficiarioId() { return beneficiarioId; }
    public void setBeneficiarioId(Long beneficiarioId) { this.beneficiarioId = beneficiarioId; }

    public Long getTrabajadorId() { return trabajadorId; }
    public void setTrabajadorId(Long trabajadorId) { this.trabajadorId = trabajadorId; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
