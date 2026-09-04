import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoriaClinica {

    private static final int CAPACIDAD_MAXIMA = 50;

    private String numeroHistoria;
    private List<Consulta> consultas;
    private LocalDate fechaCreacion;

    public HistoriaClinica(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
        this.consultas = new ArrayList<>();
        this.fechaCreacion = LocalDate.now();
    }

    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public int getCantidadConsultas() {
        return consultas.size();
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Consulta> obtenerConsultas() {
        return java.util.Collections.unmodifiableList(consultas);
    }

    public boolean agregarConsulta(Consulta consulta) {
        if (consulta == null || consultas.size() >= CAPACIDAD_MAXIMA) {
            return false;
        }
        return consultas.add(consulta);
    }

    public List<Consulta> buscarPorFecha(LocalDate fecha) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getFechaAtencion().equals(fecha)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public int contarConsultasConSeguimiento() {
        int contador = 0;
        for (Consulta c : consultas) {
            if (c.requiereSeguimiento()) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularCostoPromedio() {
        if (consultas.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Consulta c : consultas) {
            total += c.getCosto();
        }
        return total / consultas.size();
    }

    public Consulta obtenerConsultaDeMayorCosto() {
        if (consultas.isEmpty()) {
            return null;
        }
        Consulta mayor = consultas.get(0);
        for (Consulta c : consultas) {
            if (c.getCosto() > mayor.getCosto()) {
                mayor = c;
            }
        }
        return mayor;
    }

    public Consulta obtenerUltimaConsulta() {
        if (consultas.isEmpty()) {
            return null;
        }
        return consultas.get(consultas.size() - 1);
    }

    public int contarPorDiagnostico(String diagnosticoBuscado) {
        int contador = 0;
        String buscado = diagnosticoBuscado.toLowerCase();
        for (Consulta c : consultas) {
            if (c.getDiagnostico().toLowerCase().contains(buscado)) {
                contador++;
            }
        }
        return contador;
    }

    public void mostrarHistoria() {
        System.out.println("Historia Clínica N° " + numeroHistoria + " (creada: " + fechaCreacion + ")");
        if (consultas.isEmpty()) {
            System.out.println("  (sin consultas registradas)");
            return;
        }
        for (Consulta c : consultas) {
            System.out.println("  - " + c.mostrarResumen());
        }
    }
}
