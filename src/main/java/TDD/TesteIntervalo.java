package TDD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteIntervalo {

    private Intervalo intervaloBase;

    @BeforeEach
    public void setUp() {
        intervaloBase = new Intervalo(1, 46, 10);   
    }

    @Test
    public void deveCriarIntervaloComValoresAcimaDe59() {
        Intervalo i = new Intervalo(0, 1, 120);
        assertEquals("01:49:10", i.toString());
    }

    @Test
    public void deveMostrarHoras() {
        assertEquals(1, intervaloBase.getHoras());
    }

    @Test
    public void deveMostrarMinutos() {
        assertEquals(46, intervaloBase.getMinutos());
    }

    @Test
    public void deveMostrarMinutosTotais() {
        assertEquals(106, intervaloBase.getMinutosTotais());
    }

    @Test
    public void deveMostrarSegundos() {
        assertEquals(10, intervaloBase.getSegundos());
    }

    @Test
    public void deveMostrarSegundosTotais() {
        assertEquals(6360, intervaloBase.getSegundosTotais());
    }

    @Test
    public void deveSomarIntervalos() {
        Intervalo i = intervaloBase.somar(new Intervalo(0, 1, 120));
        assertTrue(i.equals(intervaloBase));
        assertEquals("02:49:10", i.toString());
    }

    @Test
    public void deveSubtrairIntervalos() {
        Intervalo i = intervaloBase.subtrair(new Intervalo(0, 1, 120));
        assertTrue(i.equals(intervaloBase));
        assertEquals("00:45:10", i.toString());
    }
}