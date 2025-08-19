package cl.controlsemana.controlSemana.controller;


import cl.controlsemana.controlSemana.service.FechaService;
import cl.controlsemana.controlSemana.controller.dto.FechaDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class ControlSemanaController {

    @Autowired
    private final FechaService service;

    @GetMapping("/fecha/{fecha}")
    public FechaDto getFecha(@PathVariable("fecha")String fecha){

       return service.validarFecha(fecha);

    }

}
