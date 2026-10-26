package edu.altair.apicrm.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos", schema = "crm")
public class Departamento {

    @Id
    @Column(name = "codigo", length = 20)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Profesor> profesores = new ArrayList<>();

    public Departamento() {}

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Profesor> getProfesores() { return profesores; }
    public void setProfesores(List<Profesor> profesores) { this.profesores = profesores; }
}