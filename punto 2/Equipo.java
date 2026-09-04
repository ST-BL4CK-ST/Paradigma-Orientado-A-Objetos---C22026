package punto2_entrenadorEquipo;

public class Equipo {
    private String nombre;
    private String categoria;
    private Entrenador entrenador;

    /// Constructor
    public Equipo(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.entrenador = null; // arranca sin entrenador asignado
    }

    /// Getter&SEtters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void asignarEntrenador(Entrenador entrenador) {
        if (entrenador == null) {
            System.out.println("No se puede asignar un entrenador nulo");
            return;
            }
            this.entrenador = entrenador;
    }

    public void cambiarEntrenador(Entrenador nuEntrenador){
        asignarEntrenador(nuEntrenador); /// No se si es valido esto, es medio chanta
    }

    public Entrenador obtenerEntrenador(){
        if (this.entrenador==null){
            return null;
        }
        else{
            return this.entrenador;
        }
    }

    public void mostrarInfo(){
        System.out.println("============================");
        System.out.println("INFORMACION SOBRE EL EQUIPO: "+this.nombre);
        System.out.println("============================");
        System.out.println("NOMBRE: "+this.nombre);
        System.out.println("CATEGORÍA: "+this.categoria);
        if (this.obtenerEntrenador()==null){
            System.out.println("ENTRENADOR: no hay entrenador asignado");
        }else{
            System.out.println("============================");
            System.out.println("INFORMACION SOBRE EL ENTRENADOR DE "+this.nombre);
            System.out.println("============================");
            System.out.println("NOMBRE: "+this.entrenador.getNombre());
            System.out.println("DNI: "+this.entrenador.getDNI());
            System.out.println("AÑOS DE EXPERIENCIA: "+this.entrenador.getAñosExperiencia());

        }
    }
}
