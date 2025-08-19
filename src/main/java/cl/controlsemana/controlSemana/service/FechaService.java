package cl.controlsemana.controlSemana.service;

import cl.controlsemana.controlSemana.controller.dto.FechaDto;

public interface FechaService {

    FechaDto validarFecha(String fechaRequest);
}
