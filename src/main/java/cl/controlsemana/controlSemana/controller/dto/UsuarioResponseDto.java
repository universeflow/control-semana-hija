package cl.controlsemana.controlSemana.controller.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDto {

    private String mensaje;
    private String token;
}
