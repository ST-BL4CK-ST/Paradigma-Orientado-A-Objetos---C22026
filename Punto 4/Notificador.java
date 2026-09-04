public class Notificador {

    public enum Canal {
        EMAIL, SMS
    }

    private String destinatario;
    private String mensaje;
    private Canal canal;

    public Notificador(String destinatario, String mensaje, Canal canal) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.canal = canal;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public void enviar() {
        switch (canal) {
            case EMAIL:
                System.out.println("[EMAIL] Para: " + destinatario + " | Mensaje: " + mensaje);
                break;
            case SMS:
                System.out.println("[SMS] Para: " + destinatario + " | Mensaje: " + mensaje);
                break;
        }
    }
}
