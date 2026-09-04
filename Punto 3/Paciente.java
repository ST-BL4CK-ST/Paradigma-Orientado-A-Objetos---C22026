public class Paciente {

    private int numeroIdentificacion;
    private String nombreApellido;
    private String fechaNacimiento;
    private int anioNacimiento;
    private String obraSocial;
    private HistoriaClinica historiaClinica;

    public Paciente(int numeroIdentificacion, String nombreApellido,
            String fechaNacimiento, int anioNacimiento,
            String obraSocial, int numeroHistoria,
            int capacidadHistoria, String fechaCreacion) {

        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.anioNacimiento = anioNacimiento;
        this.obraSocial = obraSocial;

        this.historiaClinica = new HistoriaClinica(
                numeroHistoria,
                capacidadHistoria,
                fechaCreacion);
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public int consultarEdad(int anioActual) {

        return anioActual - anioNacimiento;
    }

    public void registrarConsulta(Consulta consulta) {

        historiaClinica.agregarConsulta(consulta);
    }

    public double obtenerCostoTotalConsultas() {

        return historiaClinica.calcularCostoTotal();
    }

    public boolean necesitaSeguimiento() {

        if (historiaClinica.contarSeguimientos() > 0) {
            return true;
        }

        return false;
    }

    public boolean tieneObraSocial() {

        if (obraSocial.equals("No")) {
            return false;
        }

        return true;
    }
}