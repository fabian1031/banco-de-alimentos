package com.example.Entrega_proyecto_1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alimento")
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreAlimento;

    @Column(nullable = false)
    private String tipo; // ENLATADO, GRANO, LACTEO, VERDURA, etc.

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Column(nullable = false)
    private String unidadMedida; // KG, LITRO, UNIDAD, etc.

    @Column(nullable = false)
    private String estadoApto; // SI, NO

    public Alimento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreAlimento() { return nombreAlimento; }
    public void setNombreAlimento(String nombreAlimento) { this.nombreAlimento = nombreAlimento; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public String getEstadoApto() { return estadoApto; }
    public void setEstadoApto(String estadoApto) { this.estadoApto = estadoApto; }
}
