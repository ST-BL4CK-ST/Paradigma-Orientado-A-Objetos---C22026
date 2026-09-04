/**
 * Punto 5: Sistema de cuentas bancarias
 *
 * Relación: HERENCIA (generalización/especialización). CuentaBancaria es la
 * superclase, y CuentaAhorro / CuentaCorriente son subclases que redefinen
 * (sobrescriben) el comportamiento de calcularSaldoFinal() y, en el caso de
 * CuentaCorriente, también extraer().
 */
public class CuentaBancaria {

    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
    }

    public void extraer(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a extraer debe ser positivo.");
        }
        if (monto > saldo) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        saldo -= monto;
    }

    /**
     * Comportamiento por defecto: el saldo final es simplemente el saldo
     * actual. Las subclases lo sobrescriben con su propia fórmula.
     */
    public double calcularSaldoFinal() {
        return saldo;
    }

    public void mostrarInformacion() {
        System.out.printf("Cuenta %s | Titular: %s | Saldo: %.2f | Saldo final: %.2f%n",
                numeroCuenta, titular, saldo, calcularSaldoFinal());
    }
}
