package com.example.Entrega_proyecto_1.DTO;

import com.example.Entrega_proyecto_1.model.EntregaAyuda;

import java.time.LocalDate;

public class EntregaAyudaResponseDTO {

    private Long id;
    private LocalDate fechaEntrega;
    private String observaciones;
    private String nombreBeneficiario;
    private String nivelVulnerabilidad;
    private String nombreTrabajador;

    public static EntregaAyudaResponseDTO desde(EntregaAyuda e) {
        EntregaAyudaResponseDTO dto = new EntregaAyudaResponseDTO();
        dto.setId(e.getId());
        dto.setFechaEntrega(e.getFechaEntrega());
        dto.setObservaciones(e.getObservaciones());
        dto.setNombreBeneficiario(e.getBeneficiario().getNombre() + " " + e.getBeneficiario().getApellido());
        dto.setNivelVulnerabilidad(e.getBeneficiario().getNivelVulnerabilidad());
        dto.setNombreTrabajador(e.getTrabajador().getNombre());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(LocalDate fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getNombreBeneficiario() { return nombreBeneficiario; }
    public void setNombreBeneficiario(String nombreBeneficiario) { this.nombreBeneficiario = nombreBeneficiario; }

    public String getNivelVulnerabilidad() { return nivelVulnerabilidad; }
    public void setNivelVulnerabilidad(String nivelVulnerabilidad) { this.nivelVulnerabilidad = nivelVulnerabilidad; }

    public String getNombreTrabajador() { return nombreTrabajador; }
    public void setNombreTrabajador(String nombreTrabajador) { this.nombreTrabajador = nombreTrabajador; }
}
