package punto2_entrenadorEquipo;

public class Principal {
    static void main(String[] args) {
        Entrenador dt =new Entrenador("12345678", "Rodolfo Arruabarrena", 15);
        Entrenador dt2 = new Entrenador("9101121314", "Carlos Bianchi", 16);
        Equipo boca = new Equipo("Club Atletico Boca Juniors", "Primera División");

        boca.mostrarInfo();
        System.out.println();
        System.out.println("[SYSTEM]: Ahora agregamos entrenador...");
        System.out.println();
        boca.asignarEntrenador(dt);
        boca.mostrarInfo();
        System.out.println();
        System.out.println("[SYSTEM]: y probamos el cambio de entrenador...");
        System.out.println();
        boca.cambiarEntrenador(dt2);
        boca.mostrarInfo();
        System.out.println();
        System.out.println("[SYSTEM]:Exito :D ");

    }

}
