package com.example.Entrega_proyecto_1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "entrega_ayuda")
public class EntregaAyuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaEntrega;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id", nullable = false)
    private Beneficiario beneficiario;

    @ManyToOne
    @JoinColumn(name = "trabajador_id", nullable = false)
    private TrabajadorSocial trabajador;

    public EntregaAyuda() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(LocalDate fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public Beneficiario getBeneficiario() { return beneficiario; }
    public void setBeneficiario(Beneficiario beneficiario) { this.beneficiario = beneficiario; }

    public TrabajadorSocial getTrabajador() { return trabajador; }
    public void setTrabajador(TrabajadorSocial trabajador) { this.trabajador = trabajador; }
}
