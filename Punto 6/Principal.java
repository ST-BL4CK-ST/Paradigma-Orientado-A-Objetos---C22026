import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        // --- Caso 1: paciente con historia clínica vacía ---
        Paciente pacienteVacio = new Paciente("11111111", "Rocío Fernández",
                LocalDate.of(1999, 4, 12), "");
        System.out.println("=== Caso 1: historia vacía ===");
        System.out.println(pacienteVacio);
        pacienteVacio.getHistoriaClinica().mostrarHistoria();
        System.out.println("Costo total: " + pacienteVacio.obtenerCostoTotalConsultas());
        System.out.println("¿Necesita seguimiento? " + pacienteVacio.necesitaSeguimiento());

        // --- Caso 2: paciente con una única consulta (historia "completa" mínima) ---
        Paciente pacienteUnaConsulta = new Paciente("22222222", "Bruno Sánchez",
                LocalDate.of(1988, 9, 30), "OSDE");
        pacienteUnaConsulta.registrarConsulta(new Consulta(
                LocalDate.of(2026, 8, 20), "Control anual", "Sano", "Ninguno", 8000, false));

        System.out.println("\n=== Caso 2: historia con una consulta ===");
        System.out.println(pacienteUnaConsulta);
        pacienteUnaConsulta.getHistoriaClinica().mostrarHistoria();
        System.out.println("Costo total (con descuento por obra social): " + pacienteUnaConsulta.obtenerCostoTotalConsultas());
        System.out.println("¿Necesita seguimiento? " + pacienteUnaConsulta.necesitaSeguimiento());

        // --- Caso 3: paciente con varias consultas ---
        Paciente pacienteVarias = new Paciente("33333333", "Camila Ortiz",
                LocalDate.of(1975, 1, 5), "PAMI");
        pacienteVarias.registrarConsulta(new Consulta(
                LocalDate.of(2026, 6, 1), "Dolor de cabeza", "Migraña", "Analgésicos", 5000, true));
        pacienteVarias.registrarConsulta(new Consulta(
                LocalDate.of(2026, 7, 15), "Control de presión", "Hipertensión leve", "Dieta baja en sodio", 6000, true));
        pacienteVarias.registrarConsulta(new Consulta(
                LocalDate.of(2026, 8, 20), "Chequeo general", "Sano", "Ninguno", 7000, false));

        System.out.println("\n=== Caso 3: historia con varias consultas ===");
        System.out.println(pacienteVarias);
        HistoriaClinica hc = pacienteVarias.getHistoriaClinica();
        hc.mostrarHistoria();
        System.out.println("Cantidad de consultas: " + hc.getCantidadConsultas());
        System.out.println("Consultas con seguimiento: " + hc.contarConsultasConSeguimiento());
        System.out.println("Costo promedio: " + hc.calcularCostoPromedio());
        System.out.println("Consulta de mayor costo: " + hc.obtenerConsultaDeMayorCosto());
        System.out.println("Última consulta: " + hc.obtenerUltimaConsulta());
        System.out.println("Consultas con diagnóstico 'hipertensión': " + hc.contarPorDiagnostico("hipertensión"));
        System.out.println("Consultas del 2026-08-20: " + hc.buscarPorFecha(LocalDate.of(2026, 8, 20)));
        System.out.println("Costo total (con descuento PAMI): " + pacienteVarias.obtenerCostoTotalConsultas());
        System.out.println("¿Necesita seguimiento? " + pacienteVarias.necesitaSeguimiento());
    }
}
