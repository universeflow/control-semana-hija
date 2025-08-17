package cl.controlsemana.controlSemana.service;

import cl.controlsemana.controlSemana.controller.dto.FechaDto;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class FechaServiceImpl implements FechaService {

    /**
     * @param fechaRequest
     * @return
     */
    @Override
    public FechaDto validarFecha(String fechaRequest) {
        Map<Integer, List<LocalDate>> fechas = new HashMap<>();
        LocalDate inicio = LocalDate.of(2025, 01, 13); // Fecha de inicio en el final de 2024
        LocalDate fin = LocalDate.of(2033, 12, 31);   // Fecha de fin en el final de 2033
        obtenerSemanaParental(inicio, fin, fechas);
        // Convertir el String a LocalDate utilizando parse()
        LocalDate input = LocalDate.parse(fechaRequest);
        FechaDto response = new FechaDto();
        for (Map.Entry<Integer, List<LocalDate>> entry : fechas.entrySet()) {
            //System.out.println("Año: " + entry.getKey());
            for (LocalDate fechaInicio : entry.getValue()) {


                LocalDate fechaFin = fechaInicio.plusDays(7);

                if (fechaFin.isAfter(input) && fechaInicio.isBefore(input) || fechaInicio.isEqual(input) || fechaFin.isEqual(input)) {
                    System.out.print("#####################################################");
                    System.out.println("\nSemana con Cony  fecha ingresa [" + input + "] " +
                            "\nfecha actual [" + fechaInicio + "]\nfecha 7 dias despues  [" + fechaFin + "]");
                    System.out.print("#####################################################");
                    return FechaDto.builder()
                            .fechaInicio(fechaInicio.toString())
                            .fechaFin(fechaFin.toString())
                            .mensaje("Semana con Cony")
                            .correo("l.martinezm22@gmail.com")
                            .build();
                }

                response.setFechaFin(fechaInicio.toString());
                response.setFechaFin(fechaFin.toString());
                response.setMensaje("Semana Sin Cony");
            }
        }

        return response;
    }


    private void obtenerSemanaParental(LocalDate inicio, LocalDate fin, Map<Integer, List<LocalDate>> fechas) {
        // WeekFields permite obtener el número de semana según la cultura (en este caso, la semana empieza el lunes)
        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        // Variable para almacenar el año de la fecha anterior
        int anioAnterior = inicio.getYear();

        // Variable para alternar entre semanas pares e impares
        boolean esSemanaPar = false;  // Empezamos con las semanas pares para el primer año

        // Iterar sobre las fechas entre inicio y fin
        LocalDate fechaActual = inicio;
        while (!fechaActual.isAfter(fin)) {
            // Obtener el número de semana para la fecha actual según el calendario ISO
            int numeroSemana = fechaActual.get(weekFields.weekOfYear());

            // Verificar si el año ha cambiado
            if (fechaActual.getYear() != anioAnterior) {
                // Al cambiar de año, alternamos entre semanas pares e impares
                esSemanaPar = !esSemanaPar; // Si era par, cambia a impar y viceversa

                // Actualizar el año anterior
                anioAnterior = fechaActual.getYear();
            }

            // Si la semana es par o impar según corresponda
            if ((numeroSemana % 2 == 0 && esSemanaPar) || (numeroSemana % 2 == 1 && !esSemanaPar)) {
                // Si el año no está en el mapa, lo inicializamos
                fechas.putIfAbsent(fechaActual.getYear(), new ArrayList<>());

                // Guardar la fecha en la lista correspondiente al año
                fechas.get(fechaActual.getYear()).add(fechaActual);
            }

            // Avanzar a la siguiente semana
            fechaActual = fechaActual.plusWeeks(1);
        }
    }
}
