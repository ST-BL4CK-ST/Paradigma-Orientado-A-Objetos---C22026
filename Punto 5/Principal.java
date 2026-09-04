public class Principal {
    public static void main(String[] args) {
        CuentaAhorro ahorro = new CuentaAhorro("AH-001", "Adrin", 100000, 0.05);
        CuentaCorriente corriente = new CuentaCorriente("CC-001", "Adrin", 50000, 20000, 1500);

        ahorro.depositar(10000);
        ahorro.extraer(5000);

        corriente.depositar(2000);
        corriente.extraer(60000); // válido: usa el descubierto (saldo queda en -8000)

        // c. Guardarlas en un arreglo de tipo CuentaBancaria
        CuentaBancaria[] cuentas = { ahorro, corriente };

        // d. Recorrer el arreglo y ejecutar calcularSaldoFinal() -> comportamiento polimórfico
        System.out.println("Comportamiento polimórfico de calcularSaldoFinal():");
        for (CuentaBancaria c : cuentas) {
            c.mostrarInformacion();
        }
    }
}
