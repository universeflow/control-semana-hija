package cl.controlsemana.controlSemana.service;

import cl.controlsemana.controlSemana.controller.dto.RequestLogin;
import cl.controlsemana.controlSemana.controller.dto.UsuarioResponseDto;
import cl.controlsemana.controlSemana.exception.CustomException;
import cl.controlsemana.controlSemana.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService implements ILogin {

    private final JwtUtil jwtUtil;

    @Value("${correo.login}")
    private String email;

    @Value("${clave.login}")
    private String password;

    @Autowired
    public LoginService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UsuarioResponseDto login(RequestLogin requestLogin) {
        log.info("Authenticating user: {}", requestLogin.getUsername());
        if (!requestLogin.getUsername().equals(email) || !requestLogin.getPassword().equals(password)) {
            throw new CustomException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(email);
        return UsuarioResponseDto.builder()
                .mensaje("Login successful")
                .token(token)
                .build();
    }
}