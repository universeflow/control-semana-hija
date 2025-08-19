package cl.controlsemana.controlSemana.controller;

import cl.controlsemana.controlSemana.controller.dto.RequestLogin;
import cl.controlsemana.controlSemana.controller.dto.UsuarioResponseDto;

import cl.controlsemana.controlSemana.service.ILogin;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
public class LoginController {

    private final ILogin service;

    @Value("${correo.login}")
    private String email;

    @Value("${clave.login}")
    private String password;

    public LoginController(ILogin service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDto> login(@Valid @RequestBody RequestLogin requestLogin) {

        assert service != null;
        UsuarioResponseDto response = service.login(requestLogin);
        return ResponseEntity.ok(response);
    }


}