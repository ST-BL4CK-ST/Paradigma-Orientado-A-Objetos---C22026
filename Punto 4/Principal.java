public class Principal {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1001, "EN_PREPARACION", 15400.50);
        Notificador notificadorEmail = new Notificador("cliente@correo.com", "", Notificador.Canal.EMAIL);
        Notificador notificadorSms = new Notificador("+54 9 11 5555-5555", "", Notificador.Canal.SMS);

        GestorPedido gestor = new GestorPedido();

        System.out.println("Estado inicial: " + pedido);

        // Primera vez: cambia de estado y notifica por email
        gestor.marcarComoListoYNotificar(pedido, notificadorEmail);
        System.out.println("Estado luego de notificar: " + pedido);

        // Segunda vez: ya está LISTO, no debe volver a notificar (consigna 3)
        gestor.marcarComoListoYNotificar(pedido, notificadorSms);
    }
}
