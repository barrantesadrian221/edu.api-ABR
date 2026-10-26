package edu.altair.apicrm.dtos;

import java.time.LocalDate;

public record MatriculaResponseDto(
        Long idMatricula,
        String estudianteDni,
        String estudianteNombre,
        String asignaturaCodigo,
        String asignaturaNombre,
        LocalDate fechaMatricula,
        Double notaFinal
) {}
