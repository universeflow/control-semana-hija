package cl.controlsemana.controlSemana.service;

import cl.controlsemana.controlSemana.controller.dto.RequestLogin;
import cl.controlsemana.controlSemana.controller.dto.UsuarioResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ILogin {

     UsuarioResponseDto login(RequestLogin requestLogin);
}
