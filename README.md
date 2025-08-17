# Control Semana

Control Semana es una aplicación basada en Spring Boot diseñada para gestionar y validar fechas, autenticar usuarios y proporcionar endpoints seguros para la integración con aplicaciones frontend. La aplicación utiliza JWT para la autenticación y permite configurar CORS para una comunicación segura.

## Características

- **Autenticación de Usuarios**: Endpoint seguro para inicio de sesión con generación de tokens JWT.
- **Validación de Fechas**: Endpoint para validar y procesar fechas.
- **Configuración de CORS**: Configuración adaptable para dominios frontend.
- **Endpoints Seguros**: Protección mediante tokens JWT.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 2.7**
- **Maven**: Gestión de dependencias.
- **JWT**: Autenticación basada en tokens.
- **Lombok**: Simplificación del código Java con anotaciones.
- **Logback**: Framework de logging.

## Endpoints

### Endpoint de Autenticación
- **POST /auth/login**
    - **Descripción**: Autentica al usuario y devuelve un token JWT.
    - **Cuerpo de la Solicitud**:
      ```json
      {
        "username": "usuario@example.com",
        "password": "contraseña123"
      }
      ```
    - **Respuesta**:
      ```json
      {
        "mensaje": "Inicio de sesión exitoso",
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
      }
      ```

### Endpoint de Validación de Fechas
- **GET /fecha/{fecha}**
    - **Descripción**: Valida la fecha proporcionada y devuelve una respuesta.
    - **Encabezados**:
        - `Authorization: Bearer <JWT>`
    - **Respuesta**:
      ```json
      {
        "fecha": "2023-10-01",
        "valid": true
      }
      ```

## Configuración

### Propiedades de la Aplicación
El archivo `src/main/resources/application.properties` contiene las siguientes propiedades configurables:

### Contacto
Para preguntas o soporte, contacta a:
Correo: l.martinezm22@gmail.com

```properties
spring.application.name=controlSemana
correo.login=<tu-correo>
clave.login=<tu-contraseña>
frontend.url=https://tu-dominio-frontend.com

