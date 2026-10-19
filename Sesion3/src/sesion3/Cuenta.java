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

    public Double getSaldo() {
        return this.saldo;
    }

    public void ingresar(double x) {
        // Vacío a propósito para que falle (RED)
    }

    public void retirar(double x) {
        // Vacío a propósito para que falle (RED)
    }
}