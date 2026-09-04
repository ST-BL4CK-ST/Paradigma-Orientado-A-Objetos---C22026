package punto2_entrenadorEquipo;

public class Entrenador {
    private String DNI;
    private String nombre;
    private int añosExperiencia;

    /// Constructor
    public Entrenador(String DNI, String nombre, int añosExperiencia) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.añosExperiencia = añosExperiencia;
    }

    // Getter&Setters
    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
