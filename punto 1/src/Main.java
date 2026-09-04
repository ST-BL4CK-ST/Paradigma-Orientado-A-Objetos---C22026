public class Main {

    public static void main(String[] args) {

        Paciente paciente1 = new Paciente(
                "40111222",
                "Juan Perez",
                "OSDE"
        );

        Paciente paciente2 = new Paciente(
                "42333444",
                "Maria Gomez",
                "Swiss Medical"
        );

        Paciente paciente3 = new Paciente(
                "44555666",
                "Pedro Lopez",
                "Galeno"
        );

        Medico medico1 = new Medico(
                "M100",
                "Carlos Fernandez",
                "Cardiologia",
                5
        );

        Medico medico2 = new Medico(
                "M200",
                "Laura Martinez",
                "Clinica Medica",
                5
        );

        medico1.asignarPaciente(paciente1);
        medico1.asignarPaciente(paciente2);

        medico2.asignarPaciente(paciente1);
        medico2.asignarPaciente(paciente3);

        System.out.println("Pacientes del medico 1:");
        medico1.mostrarPacientes();

        System.out.println("Cantidad de pacientes del medico 1:");
        System.out.println(medico1.cantidadPacientes());

        System.out.println();

        Paciente encontrado = medico1.buscarPaciente("42333444");

        if (encontrado != null) {
            System.out.println("Paciente encontrado:");
            System.out.println(encontrado.getNombre());
        } else {
            System.out.println("Paciente no encontrado");
        }

        System.out.println();

        boolean eliminado = medico1.eliminarPaciente("40111222");

        if (eliminado) {
            System.out.println("Paciente eliminado del medico 1");
        } else {
            System.out.println("Paciente no encontrado");
        }

        System.out.println();

        System.out.println("Pacientes actuales del medico 1:");
        medico1.mostrarPacientes();

        System.out.println("El paciente sigue existiendo:");
        System.out.println(paciente1.getDni());
        System.out.println(paciente1.getNombre());
        System.out.println(paciente1.getObraSocial());

        System.out.println();

        System.out.println("Y sigue asignado al medico 2:");
        medico2.mostrarPacientes();
    }
}