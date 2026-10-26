package edu.altair.apicrm.dtos;

public record AsignaturaResponseDto(
        String codigo,
        String nombre,
        String profesorDni,
        String profesorNombre
) {}
