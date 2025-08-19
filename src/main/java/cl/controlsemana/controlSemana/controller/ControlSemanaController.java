package cl.controlsemana.controlSemana.controller;


import cl.controlsemana.controlSemana.service.FechaService;
import cl.controlsemana.controlSemana.controller.dto.FechaDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControlSemanaController {

    private final FechaService service;

    public ControlSemanaController(FechaService service) {
        this.service = service;
    }

    @GetMapping("/fecha/{fecha}")
    public FechaDto getFecha(@PathVariable("fecha")String fecha){

       return service.validarFecha(fecha);

    }

}
