package com.example.Entrega_proyecto_1.DTO;

import java.time.LocalDate;

public class DonacionRequestDTO {

    private LocalDate fechaDonacion;
    private Long donanteId;
    private Integer totalItems;

    public LocalDate getFechaDonacion() { return fechaDonacion; }
    public void setFechaDonacion(LocalDate fechaDonacion) { this.fechaDonacion = fechaDonacion; }

    public Long getDonanteId() { return donanteId; }
    public void setDonanteId(Long donanteId) { this.donanteId = donanteId; }

    public Integer getTotalItems() { return totalItems; }
    public void setTotalItems(Integer totalItems) { this.totalItems = totalItems; }
}
