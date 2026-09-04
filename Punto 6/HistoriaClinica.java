import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Relación con Consulta: COMPOSICIÓN. Las consultas registradas son parte
 * exclusiva de esta historia clínica; si la historia se elimina, sus
 * consultas dejan de tener sentido y se eliminan con ella.
 */
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

    /**
     * Devuelve una copia de solo lectura de las consultas registradas, para
     * que otras clases (como Paciente) puedan recorrerlas sin poder
     * modificar la lista interna directamente.
     */
    public List<Consulta> obtenerConsultas() {
        return java.util.Collections.unmodifiableList(consultas);
    }

    /**
     * a. Agrega una consulta, verificando que exista capacidad disponible.
     */
    public boolean agregarConsulta(Consulta consulta) {
        if (consulta == null || consultas.size() >= CAPACIDAD_MAXIMA) {
            return false;
        }
        return consultas.add(consulta);
    }

    /**
     * b. Busca las consultas realizadas en una fecha determinada.
     */
    public List<Consulta> buscarPorFecha(LocalDate fecha) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getFechaAtencion().equals(fecha)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    /**
     * c. Cuenta las consultas que requieren seguimiento.
     */
    public int contarConsultasConSeguimiento() {
        int contador = 0;
        for (Consulta c : consultas) {
            if (c.requiereSeguimiento()) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * d. Calcula el costo promedio de las consultas.
     */
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

    /**
     * e. Obtiene la consulta de mayor costo.
     */
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

    /**
     * f. Obtiene la última consulta registrada.
     */
    public Consulta obtenerUltimaConsulta() {
        if (consultas.isEmpty()) {
            return null;
        }
        return consultas.get(consultas.size() - 1);
    }

    /**
     * g. Cuenta cuántas consultas contienen un diagnóstico determinado
     * (coincidencia parcial, sin distinguir mayúsculas/minúsculas).
     */
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
