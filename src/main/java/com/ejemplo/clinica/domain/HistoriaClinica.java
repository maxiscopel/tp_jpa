package com.ejemplo.clinica.domain;

import jakarta.persistence.*;

@Entity
public class HistoriaClinica extends BaseEntity {

    @Column(length = 2000)
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}
