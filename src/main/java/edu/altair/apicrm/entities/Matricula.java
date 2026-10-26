package edu.altair.apicrm.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "matriculas",
        schema = "crm",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_estudiante_asignatura",
                columnNames = {"dni_estudiante", "codigo_asignatura"}
        )
)
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long idMatricula;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dni_estudiante", foreignKey = @ForeignKey(name = "fk_matricula_estudiante"))
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_asignatura", foreignKey = @ForeignKey(name = "fk_matricula_asignatura"))
    private Asignatura asignatura;

    @Column(name = "fecha_matricula", nullable = false)
    private LocalDate fechaMatricula;

    @Column(name = "nota_final")
    private Double notaFinal;

    public Matricula() {}

    public Matricula(Estudiante estudiante, Asignatura asignatura, LocalDate fechaMatricula, Double notaFinal) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.fechaMatricula = fechaMatricula;
        this.notaFinal = notaFinal;
    }

    // Getters y Setters
    public Long getIdMatricula() { return idMatricula; }
    public void setIdMatricula(Long idMatricula) { this.idMatricula = idMatricula; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }

    public LocalDate getFechaMatricula() { return fechaMatricula; }
    public void setFechaMatricula(LocalDate fechaMatricula) { this.fechaMatricula = fechaMatricula; }

    public Double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(Double notaFinal) { this.notaFinal = notaFinal; }
}