public class Medico {

    private String matricula;
    private String nombre;
    private String especialidad;
    private Paciente[] pacientes;
    private int cantidad;

    public Medico(String matricula, String nombre, String especialidad, int capacidad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.pacientes = new Paciente[capacidad];
        this.cantidad = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean asignarPaciente(Paciente paciente) {

        if (cantidad < pacientes.length) {
            pacientes[cantidad] = paciente;
            cantidad++;
            return true;
        }

        return false;
    }

    public Paciente buscarPaciente(String dni) {

        for (int i = 0; i < cantidad; i++) {

            if (pacientes[i].getDni().equals(dni)) {
                return pacientes[i];
            }
        }

        return null;
    }

    public boolean eliminarPaciente(String dni) {

        for (int i = 0; i < cantidad; i++) {

            if (pacientes[i].getDni().equals(dni)) {

                for (int j = i; j < cantidad - 1; j++) {
                    pacientes[j] = pacientes[j + 1];
                }

                pacientes[cantidad - 1] = null;
                cantidad--;

                return true;
            }
        }

        return false;
    }

    public int cantidadPacientes() {
        return cantidad;
    }

    public void mostrarPacientes() {

        for (int i = 0; i < cantidad; i++) {

            System.out.println("DNI: " + pacientes[i].getDni());
            System.out.println("Nombre: " + pacientes[i].getNombre());
            System.out.println("Obra social: " + pacientes[i].getObraSocial());
            System.out.println();
        }
    }
}