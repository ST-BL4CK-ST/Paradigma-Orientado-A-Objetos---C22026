public class Main {

    public static void main(String[] args) {

        // Crear paciente
        Paciente paciente1 = new Paciente(
                1,
                "Juan Perez",
                "10/05/2000",
                2000,
                "OSDE",
                1001,
                3,
                "01/09/2026"
        );

        System.out.println("DATOS DEL PACIENTE");
        System.out.println("Nombre: " + paciente1.getNombreApellido());
        System.out.println("Edad: " + paciente1.consultarEdad(2026));

        System.out.println();
        System.out.println("HISTORIA VACIA");
        System.out.println("Cantidad de consultas: "
                + paciente1.getHistoriaClinica().getCantidadConsultas());

        System.out.println("Costo promedio: $"
                + paciente1.getHistoriaClinica().calcularCostoPromedio());


        Consulta consulta1 = new Consulta(
                "10/08/2026",
                "Dolor de cabeza",
                "Migrana",
                "Reposo",
                15000,
                true
        );

        Consulta consulta2 = new Consulta(
                "20/08/2026",
                "Dolor de garganta",
                "Faringitis",
                "Medicacion",
                20000,
                false
        );

        Consulta consulta3 = new Consulta(
                "25/08/2026",
                "Dolor muscular",
                "Contractura",
                "Kinesiologia",
                18000,
                true
        );


        System.out.println();
        System.out.println("REGISTRO DE CONSULTAS");

        paciente1.registrarConsulta(consulta1);
        paciente1.registrarConsulta(consulta2);
        paciente1.registrarConsulta(consulta3);


        System.out.println();
        System.out.println("DATOS DE LA HISTORIA");

        System.out.println("Cantidad de consultas: "
                + paciente1.getHistoriaClinica().getCantidadConsultas());

        System.out.println("Costo total: $"
                + paciente1.obtenerCostoTotalConsultas());

        System.out.println("Costo promedio: $"
                + paciente1.getHistoriaClinica().calcularCostoPromedio());

        System.out.println("Consultas que requieren seguimiento: "
                + paciente1.getHistoriaClinica().contarSeguimientos());

        System.out.println("Necesita seguimiento: "
                + paciente1.necesitaSeguimiento());


        System.out.println();
        System.out.println("BUSCAR POR FECHA");

        paciente1.getHistoriaClinica().buscarPorFecha("20/08/2026");


        System.out.println();
        System.out.println("CONSULTA DE MAYOR COSTO");

        Consulta mayor =
                paciente1.getHistoriaClinica().obtenerConsultaMayorCosto();

        if (mayor != null) {
            mayor.mostrarResumen();
        }


        System.out.println();
        System.out.println("ULTIMA CONSULTA");

        Consulta ultima =
                paciente1.getHistoriaClinica().obtenerUltimaConsulta();

        if (ultima != null) {
            ultima.mostrarResumen();
        }


        System.out.println();
        System.out.println("BUSCAR DIAGNOSTICO");

        int cantidadMigrana =
                paciente1.getHistoriaClinica().contarDiagnostico("Migrana");

        System.out.println("Cantidad de consultas con Migrana: "
                + cantidadMigrana);


        System.out.println();
        System.out.println("COSTO CON OBRA SOCIAL");

        System.out.println("Costo normal: $" + consulta1.getCosto());

        System.out.println("Costo final: $"
                + consulta1.calcularCostoFinal(
                paciente1.tieneObraSocial()
        ));


        System.out.println();
        System.out.println("HISTORIA COMPLETA");

        Consulta consulta4 = new Consulta(
                "30/08/2026",
                "Control general",
                "Sin problemas",
                "Ninguno",
                10000,
                false
        );

        paciente1.registrarConsulta(consulta4);
    }
}