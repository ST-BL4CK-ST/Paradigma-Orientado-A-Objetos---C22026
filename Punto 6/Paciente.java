import java.time.LocalDate;
import java.time.Period;

/**
 * Relación con HistoriaClinica: COMPOSICIÓN. Cada paciente crea su propia
 * historia clínica al registrarse (en el constructor) y es dueño exclusivo
 * de ella: no tiene sentido conservarla si el paciente es eliminado.
 */
public class Paciente {

    private String numeroIdentificacion;
    private String nombreApellido;
    private LocalDate fechaNacimiento;
    private String obraSocial;
    private HistoriaClinica historiaClinica;

    public Paciente(String numeroIdentificacion, String nombreApellido,
                     LocalDate fechaNacimiento, String obraSocial) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.obraSocial = obraSocial;
        // a. Se crea automáticamente la historia clínica al registrar al paciente
        this.historiaClinica = new HistoriaClinica("HC-" + numeroIdentificacion);
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    private boolean tieneObraSocial() {
        return obraSocial != null && !obraSocial.isBlank();
    }

    /**
     * b. Calcula la edad del paciente a partir de su fecha de nacimiento.
     */
    public int consultarEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    /**
     * c. Registra una nueva consulta en la historia clínica del paciente.
     */
    public boolean registrarConsulta(Consulta consulta) {
        return historiaClinica.agregarConsulta(consulta);
    }

    /**
     * d. Costo total de todas sus consultas, aplicando el descuento por
     * obra social cuando corresponde.
     */
    public double obtenerCostoTotalConsultas() {
        double total = 0;
        for (Consulta c : historiaClinica.obtenerConsultas()) {
            total += c.calcularCostoFinal(tieneObraSocial());
        }
        return total;
    }

    /**
     * e. Determina si el paciente necesita seguimiento (si alguna de sus
     * consultas registradas lo requiere).
     */
    public boolean necesitaSeguimiento() {
        return historiaClinica.contarConsultasConSeguimiento() > 0;
    }

    @Override
    public String toString() {
        return "Paciente{ID=" + numeroIdentificacion + ", nombre='" + nombreApellido
                + "', edad=" + consultarEdad() + ", obraSocial='" + obraSocial + "'}";
    }
}
