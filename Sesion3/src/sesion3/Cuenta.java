package sesion3;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String mNumero;
    private String nTitular;
    private Double saldo;
    private List<Movimiento> mMovimientos = new ArrayList<>();

    public Cuenta(String numero, String titular, Double saldoInicial) {
        this.mNumero = numero;
        this.nTitular = titular;
        this.saldo = saldoInicial;
    }

    public String getNumero() { return mNumero; }
    public String getTitular() { return nTitular; }
    public Double getSaldo() { return saldo; }
    public List<Movimiento> getMovimientos() { return mMovimientos; }

    public void ingresar(double x) {
        if (x <= 0) {
            return;
        }
        this.saldo += x;
        mMovimientos.add(new Movimiento(x, Movimiento.Signo.H, "Ingreso en cuenta"));
    }

    public void retirar(double x) {
        if (x <= 0) {
            return;
        }
        // Las cuentas tienen un límite de descubierto de -500€
        if (this.saldo - x < -500.0) {
            System.err.println("Fondos insuficientes (saldo " + this.saldo + "€) en la cuenta " 
                               + this.mNumero + " para el reintegro de " + x + "€");
            return;
        }
        this.saldo -= x;
        mMovimientos.add(new Movimiento(x, Movimiento.Signo.D, "Reintegro en cuenta"));
    }
}