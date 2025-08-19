package cl.controlsemana.controlSemana.controller.dto;

public class UsuarioResponseDto {

    private String mensaje;
    private String token;

    public UsuarioResponseDto() {}

    public UsuarioResponseDto(String mensaje, String token) {
        this.mensaje = mensaje;
        this.token = token;
    }

    public static UsuarioResponseDtoBuilder builder() {
        return new UsuarioResponseDtoBuilder();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class UsuarioResponseDtoBuilder {
        private String mensaje;
        private String token;

        public UsuarioResponseDtoBuilder mensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        public UsuarioResponseDtoBuilder token(String token) {
            this.token = token;
            return this;
        }

        public UsuarioResponseDto build() {
            return new UsuarioResponseDto(mensaje, token);
        }
    }
}
