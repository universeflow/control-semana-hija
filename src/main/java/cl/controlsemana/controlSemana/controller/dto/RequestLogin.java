package cl.controlsemana.controlSemana.controller.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class RequestLogin {

    @NotEmpty(message = "El nombre de usuario no puede estar vacío")
    private String username;
    @NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;


}
