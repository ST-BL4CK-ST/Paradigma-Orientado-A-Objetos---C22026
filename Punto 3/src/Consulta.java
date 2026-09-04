public class Consulta {

    private String fechaAtencion;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private double costo;
    private boolean seguimiento;

    public Consulta(String  fechaAtencion,
                    String  motivo,
                    String  diagnostico,
                    String  tratamiento,
                    double  costo,
                    boolean seguimiento) {

        this.fechaAtencion = fechaAtencion;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.costo = costo;
        this.seguimiento = seguimiento;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public double getCosto() {
        return costo;
    }

    public boolean requiereSeguimiento() {
        return seguimiento;
    }

    public double calcularCostoFinal(boolean tieneObraSocial) {

        if (tieneObraSocial) {
            return costo * 0.80;
        }

        return costo;
    }

    public void mostrarResumen() {

        System.out.println("Fecha: " + fechaAtencion);
        System.out.println("Motivo: " + motivo);
        System.out.println("Diagnostico: " + diagnostico);
        System.out.println("Tratamiento: " + tratamiento);
        System.out.println("Costo: $" + costo);
        System.out.println("Requiere seguimiento: " + seguimiento);
    }
}