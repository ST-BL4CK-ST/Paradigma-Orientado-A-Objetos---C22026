/**
 * Punto 4: Servicio de notificación
 *
 * Relación: DEPENDENCIA.
 */
public class GestorPedido {

    public void marcarComoListoYNotificar(Pedido pedido, Notificador notificador) {
        if (pedido == null || notificador == null) {
            throw new IllegalArgumentException("El pedido y el notificador no pueden ser nulos.");
        }

        String estadoAnterior = pedido.getEstado();
        if ("LISTO".equalsIgnoreCase(estadoAnterior)) {
            System.out.println("El pedido " + pedido.getNumero() + " ya estaba LISTO. No se notifica de nuevo.");
            return;
        }

        pedido.setEstado("LISTO");

        notificador.setMensaje("Su pedido N° " + pedido.getNumero() + " está listo para retirar.");
        notificador.enviar();
    }
}
