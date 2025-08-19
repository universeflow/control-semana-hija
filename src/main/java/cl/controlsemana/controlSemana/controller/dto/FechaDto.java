package cl.controlsemana.controlSemana.controller.dto;

public class FechaDto {

    private String fechaInicio;
    private String fechaFin;
    private String mensaje;
    private String correo;

    public FechaDto() {}

    public FechaDto(String fechaInicio, String fechaFin, String mensaje, String correo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.mensaje = mensaje;
        this.correo = correo;
    }

    public static FechaDtoBuilder builder() {
        return new FechaDtoBuilder();
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static class FechaDtoBuilder {
        private String fechaInicio;
        private String fechaFin;
        private String mensaje;
        private String correo;

        public FechaDtoBuilder fechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public FechaDtoBuilder fechaFin(String fechaFin) {
            this.fechaFin = fechaFin;
            return this;
        }

        public FechaDtoBuilder mensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        public FechaDtoBuilder correo(String correo) {
            this.correo = correo;
            return this;
        }

        public FechaDto build() {
            return new FechaDto(fechaInicio, fechaFin, mensaje, correo);
        }
    }
}
