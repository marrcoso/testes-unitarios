package junit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotoTest {
    private Moto moto;

    @BeforeEach
    public void começar() {
        moto = new Moto("Honda Biz");
    }

    @Test
    public void testAceleraEFreia() {
        moto.acelera(10);
        moto.freia(10);
        assertEquals(0, moto.getVelocidade());
    }

    @Test
    public void testAbasteceEAcelera() {
        moto.abastece(10);
        moto.acelera(50);
        assertEquals(9.5, moto.getQtdGasolina(), 0.001);
    }

    @Test
    public void testAceleraSemGasolina() {
        moto.acelera(10);
        assertEquals(0, moto.getVelocidade());
    }
}
