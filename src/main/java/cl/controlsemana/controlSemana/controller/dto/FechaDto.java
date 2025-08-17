package cl.controlsemana.controlSemana.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FechaDto {

    private String fechaInicio;
    private String fechaFin;
    private String mensaje;
    private String correo ;
}
