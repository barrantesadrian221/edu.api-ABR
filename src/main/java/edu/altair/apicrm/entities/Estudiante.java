package edu.altair.apicrm.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes", schema = "crm")
public class Estudiante {

    @Id
    @Column(name = "dni", length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Matricula> matriculas = new ArrayList<>();

    public Estudiante() {}

    public Estudiante(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Matricula> getMatriculas() { return matriculas; }
    public void setMatriculas(List<Matricula> matriculas) { this.matriculas = matriculas; }
}