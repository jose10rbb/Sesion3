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
    
    @Test
    void test0014CasoCompletoClase() {
        // Inicialización
        Cuenta c12345 = new Cuenta("12345", "Titular 1", 50.0);
        Cuenta c67890 = new Cuenta("67890", "Titular 2", 0.0);

        // Instrucciones
        c12345.retirar(200.0); // 1. Reintegro 200€ -> saldo -150€
        c67890.retirar(350.0); // 2. Reintegro 350€ -> saldo -350€
        c12345.ingresar(100.0); // 3. Ingreso 100€ -> saldo -50€
        c67890.retirar(200.0); // 4. Reintegro 200€ -> denegado por descubierto (-350 - 200 = -550 < -500)
        c67890.retirar(150.0); // 5. Reintegro 150€ -> permitido (-350 - 150 = -500€)
        c12345.retirar(200.0); // 6. Reintegro 200€ -> saldo -250€
        c67890.ingresar(50.0);  // 7. Ingreso 50€ -> saldo -450€
        c67890.retirar(100.0); // 8. Reintegro 100€ -> denegado por descubierto (-450 - 100 = -550 < -500)

        // Resultados esperados
        assertEquals(-250.0, c12345.getSaldo(), 0.001);
        assertEquals(-450.0, c67890.getSaldo(), 0.001);
    }
}