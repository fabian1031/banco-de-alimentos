package com.example.Entrega_proyecto_1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "donante")
public class Donante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreDonante;

    @Column(nullable = false)
    private String tipoDonante; // PERSONA_NATURAL, EMPRESA

    @Column(unique = true)
    private String nitDocumento;

    private String telefono;

    public Donante() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreDonante() { return nombreDonante; }
    public void setNombreDonante(String nombreDonante) { this.nombreDonante = nombreDonante; }

    public String getTipoDonante() { return tipoDonante; }
    public void setTipoDonante(String tipoDonante) { this.tipoDonante = tipoDonante; }

    public String getNitDocumento() { return nitDocumento; }
    public void setNitDocumento(String nitDocumento) { this.nitDocumento = nitDocumento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
