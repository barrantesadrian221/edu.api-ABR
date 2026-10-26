package edu.altair.apicrm.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesores", schema = "crm")
public class Profesor {

    @Id
    @Column(name = "dni", length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Pertenece obligatoriamente a un único departamento (N:1)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_departamento", foreignKey = @ForeignKey(name = "fk_profesor_departamento"))
    private Departamento departamento;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
    private List<Asignatura> asignaturas = new ArrayList<>();

    public Profesor() {}

    public Profesor(String dni, String nombre, Departamento departamento) {
        this.dni = dni;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }

    public List<Asignatura> getAsignaturas() { return asignaturas; }
    public void setAsignaturas(List<Asignatura> asignaturas) { this.asignaturas = asignaturas; }
}