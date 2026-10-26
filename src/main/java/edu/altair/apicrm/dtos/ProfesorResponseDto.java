package edu.altair.apicrm.dtos;

public record ProfesorResponseDto(
        String dni,
        String nombre,
        String departamentoCodigo,
        String departamentoNombre
) {}