public class CuentaCorriente extends CuentaBancaria {

    private double limiteDescubierto;
    private double costoMantenimiento;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo,
                            double limiteDescubierto, double costoMantenimiento) {
        super(numeroCuenta, titular, saldo);
        this.limiteDescubierto = limiteDescubierto;
        this.costoMantenimiento = costoMantenimiento;
    }

    public double getLimiteDescubierto() {
        return limiteDescubierto;
    }

    public void setLimiteDescubierto(double limiteDescubierto) {
        this.limiteDescubierto = limiteDescubierto;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    /**
     * Permite extraer dinero mientras el saldo resultante no supere (en
     * valor absoluto) el límite de descubierto, es decir, el saldo puede
     * volverse negativo hasta -limiteDescubierto.
     */
    @Override
    public void extraer(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a extraer debe ser positivo.");
        }
        double saldoResultante = getSaldo() - monto;
        if (saldoResultante < -limiteDescubierto) {
            throw new IllegalStateException("La extracción supera el límite de descubierto permitido.");
        }
        setSaldo(saldoResultante);
    }

    /**
     * SaldoFinal = saldo - costoMantenimiento
     */
    @Override
    public double calcularSaldoFinal() {
        return getSaldo() - costoMantenimiento;
    }
}
