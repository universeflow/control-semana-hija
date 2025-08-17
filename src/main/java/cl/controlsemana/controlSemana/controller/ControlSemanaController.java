package cl.controlsemana.controlSemana.controller;


import cl.controlsemana.controlSemana.service.FechaService;
import cl.controlsemana.controlSemana.controller.dto.FechaDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ControlSemanaController {

    @Autowired
    private final FechaService service;

    @GetMapping("/fecha/{fecha}")
    public FechaDto getFecha(@PathVariable("fecha")String fecha){

       return service.validarFecha(fecha);

    }

}
