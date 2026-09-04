public class Pedido {

    private int numero;
    private String estado;
    private double total;

    public Pedido(int numero, String estado, double total) {
        this.numero = numero;
        this.estado = estado;
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{número=" + numero + ", estado='" + estado + "', total=" + total + "}";
    }
}
