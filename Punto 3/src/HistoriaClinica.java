public class HistoriaClinica {

    private int numeroHistoria;
    private Consulta[] consultas;
    private int cantidadConsultas;
    private String fechaCreacion;

    public HistoriaClinica(int numeroHistoria, int capacidad, String fechaCreacion) {

        this.numeroHistoria = numeroHistoria;
        this.consultas = new Consulta[capacidad];
        this.cantidadConsultas = 0;
        this.fechaCreacion = fechaCreacion;
    }

    public int getCantidadConsultas() {
        return cantidadConsultas;
    }

    public void agregarConsulta(Consulta consulta) {

        if (cantidadConsultas < consultas.length) {

            consultas[cantidadConsultas] = consulta;
            cantidadConsultas++;

            System.out.println("Consulta agregada correctamente.");

        } else {

            System.out.println("La historia clinica esta completa.");
        }
    }

    public void buscarPorFecha(String fecha) {

        boolean encontrada = false;

        for (int i = 0; i < cantidadConsultas; i++) {

            if (consultas[i].getFechaAtencion().equals(fecha)) {

                consultas[i].mostrarResumen();
                encontrada = true;
            }
        }

        if (encontrada == false) {
            System.out.println("No hay consultas en esa fecha.");
        }
    }

    public int contarSeguimientos() {

        int contador = 0;

        for (int i = 0; i < cantidadConsultas; i++) {

            if (consultas[i].requiereSeguimiento()) {
                contador++;
            }
        }

        return contador;
    }

    public double calcularCostoPromedio() {

        if (cantidadConsultas == 0) {
            return 0;
        }

        double suma = 0;

        for (int i = 0; i < cantidadConsultas; i++) {
            suma = suma + consultas[i].getCosto();
        }

        return suma / cantidadConsultas;
    }

    public Consulta obtenerConsultaMayorCosto() {

        if (cantidadConsultas == 0) {
            return null;
        }

        Consulta mayor = consultas[0];

        for (int i = 1; i < cantidadConsultas; i++) {

            if (consultas[i].getCosto() > mayor.getCosto()) {
                mayor = consultas[i];
            }
        }

        return mayor;
    }

    public Consulta obtenerUltimaConsulta() {

        if (cantidadConsultas == 0) {
            return null;
        }

        return consultas[cantidadConsultas - 1];
    }

    public int contarDiagnostico(String diagnostico) {

        int contador = 0;

        for (int i = 0; i < cantidadConsultas; i++) {

            if (consultas[i].getDiagnostico().equals(diagnostico)) {
                contador++;
            }
        }

        return contador;
    }

    public double calcularCostoTotal() {

        double total = 0;

        for (int i = 0; i < cantidadConsultas; i++) {
            total = total + consultas[i].getCosto();
        }

        return total;
    }
}