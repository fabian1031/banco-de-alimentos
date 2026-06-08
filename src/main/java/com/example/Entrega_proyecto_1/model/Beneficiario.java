package com.example.Entrega_proyecto_1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiario")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String numeroDocumento;

    @Column(nullable = false)
    private String nivelVulnerabilidad; // ALTO, MEDIO, BAJO

    @Column(nullable = false)
    private Integer numeroIntegrantes;

    @Column(nullable = false)
    private String estado; // ACTIVO, INACTIVO

    public Beneficiario() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getNivelVulnerabilidad() { return nivelVulnerabilidad; }
    public void setNivelVulnerabilidad(String nivelVulnerabilidad) { this.nivelVulnerabilidad = nivelVulnerabilidad; }

    public Integer getNumeroIntegrantes() { return numeroIntegrantes; }
    public void setNumeroIntegrantes(Integer numeroIntegrantes) { this.numeroIntegrantes = numeroIntegrantes; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
