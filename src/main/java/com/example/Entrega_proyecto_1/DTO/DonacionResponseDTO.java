package com.example.Entrega_proyecto_1.DTO;

import com.example.Entrega_proyecto_1.model.Donacion;

import java.time.LocalDate;

public class DonacionResponseDTO {

    private Long id;
    private LocalDate fechaDonacion;
    private Integer totalItems;
    private String nombreDonante;
    private String tipoDonante;

    public static DonacionResponseDTO desde(Donacion d) {
        DonacionResponseDTO dto = new DonacionResponseDTO();
        dto.setId(d.getId());
        dto.setFechaDonacion(d.getFechaDonacion());
        dto.setTotalItems(d.getTotalItems());
        dto.setNombreDonante(d.getDonante().getNombreDonante());
        dto.setTipoDonante(d.getDonante().getTipoDonante());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFechaDonacion() { return fechaDonacion; }
    public void setFechaDonacion(LocalDate fechaDonacion) { this.fechaDonacion = fechaDonacion; }

    public Integer getTotalItems() { return totalItems; }
    public void setTotalItems(Integer totalItems) { this.totalItems = totalItems; }

    public String getNombreDonante() { return nombreDonante; }
    public void setNombreDonante(String nombreDonante) { this.nombreDonante = nombreDonante; }

    public String getTipoDonante() { return tipoDonante; }
    public void setTipoDonante(String tipoDonante) { this.tipoDonante = tipoDonante; }
}
