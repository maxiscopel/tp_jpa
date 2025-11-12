package com.ejemplo.clinica.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Medicamento extends BaseEntity {

    private String nombre;
    private String presentacion;

    @ManyToMany(mappedBy = "medicamentos")
    private Set<Paciente> pacientes = new HashSet<>();

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPresentacion() { return presentacion; }
    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }

    public Set<Paciente> getPacientes() { return pacientes; }
}
