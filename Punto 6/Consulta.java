import java.time.LocalDate;

public class Consulta {

    private LocalDate fechaAtencion;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private double costo;
    private boolean requiereSeguimiento;

    public Consulta(LocalDate fechaAtencion, String motivo, String diagnostico,
                     String tratamiento, double costo, boolean requiereSeguimiento) {
        this.fechaAtencion = fechaAtencion;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.costo = costo;
        this.requiereSeguimiento = requiereSeguimiento;
    }

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDate fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isRequiereSeguimiento() {
        return requiereSeguimiento;
    }

    public void setRequiereSeguimiento(boolean requiereSeguimiento) {
        this.requiereSeguimiento = requiereSeguimiento;
    }

    /**
     * a. La consulta ya guarda directamente si requiere seguimiento; este
     * método expone esa decisión de forma explícita.
     */
    public boolean requiereSeguimiento() {
        return requiereSeguimiento;
    }

    /**
     * b. Calcula el costo final aplicando un descuento (20%) si el paciente
     * posee obra social.
     */
    public double calcularCostoFinal(boolean tieneObraSocial) {
        if (tieneObraSocial) {
            return costo * 0.80;
        }
        return costo;
    }

    /**
     * c. Resumen de la atención realizada.
     */
    public String mostrarResumen() {
        return String.format("[%s] Motivo: %s | Diagnóstico: %s | Tratamiento: %s | Costo: %.2f | Seguimiento: %s",
                fechaAtencion, motivo, diagnostico, tratamiento, costo, requiereSeguimiento ? "Sí" : "No");
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }
}
