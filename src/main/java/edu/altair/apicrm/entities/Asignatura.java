package edu.altair.apicrm.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignaturas", schema = "crm")
public class Asignatura {

    @Id
    @Column(name = "codigo", length = 20)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Impartida por un único profesor de forma obligatoria (N:1)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dni_profesor", foreignKey = @ForeignKey(name = "fk_asignatura_profesor"))
    private Profesor profesor;

    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Matricula> matriculas = new ArrayList<>();

    public Asignatura() {}

    public Asignatura(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    public List<Matricula> getMatriculas() { return matriculas; }
    public void setMatriculas(List<Matricula> matriculas) { this.matriculas = matriculas; }
}