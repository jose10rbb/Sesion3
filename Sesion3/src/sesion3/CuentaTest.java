package sesion3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CuentaTest {

    @Test
    void testIngresar() {
        Cuenta cuenta = new Cuenta("12345", "Juan Perez", 50.0);
        cuenta.ingresar(100.0);
        assertEquals(150.0, cuenta.getSaldo());
    }

    @Test
    void testRetirar() {
        Cuenta cuenta = new Cuenta("12345", "Juan Perez", 100.0);
        cuenta.retirar(40.0);
        assertEquals(60.0, cuenta.getSaldo());
    }
}