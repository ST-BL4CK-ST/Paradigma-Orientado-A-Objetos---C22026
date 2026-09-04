public class CuentaAhorro extends CuentaBancaria {

    private double tasaInteres;

    public CuentaAhorro(String numeroCuenta, String titular, double saldo, double tasaInteres) {
        super(numeroCuenta, titular, saldo);
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    /**
     * SaldoFinal = saldo + saldo * tasaInteres
     */
    @Override
    public double calcularSaldoFinal() {
        return getSaldo() + getSaldo() * tasaInteres;
    }
}
