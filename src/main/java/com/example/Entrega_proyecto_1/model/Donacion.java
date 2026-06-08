package com.example.Entrega_proyecto_1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donacion")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaDonacion;

    @Column(nullable = false)
    private Integer totalItems;

    @ManyToOne
    @JoinColumn(name = "donante_id", nullable = false)
    private Donante donante;

    public Donacion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFechaDonacion() { return fechaDonacion; }
    public void setFechaDonacion(LocalDate fechaDonacion) { this.fechaDonacion = fechaDonacion; }

    public Integer getTotalItems() { return totalItems; }
    public void setTotalItems(Integer totalItems) { this.totalItems = totalItems; }

    public Donante getDonante() { return donante; }
    public void setDonante(Donante donante) { this.donante = donante; }
}
