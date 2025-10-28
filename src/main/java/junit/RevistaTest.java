package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teste.Publicacao;
import teste.Revista;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class RevistaTest {

    Revista r1, r1Copy, r1CopyErro;
    String saidaEsperada;

    @BeforeEach
    void setUp() {
        r1 = new Revista("Superinteressante", LocalDate.of(2021, 3, 1), "Abril", 425);
        r1Copy = new Revista("Superinteressante", LocalDate.of(2021, 3, 1), "Abril", 425);
        r1CopyErro = new Revista("Superinteressante", LocalDate.of(2021, 2, 1), "Abril", 425);
        saidaEsperada = "Revista: Superinteressante (3/2021) - editora Abril - edicao n:425";
    }

    @Test
    void testEditoraEdicao() {
        assertEquals(425, r1.getEdicao());
        assertEquals("Abril", r1.getEditora());
    }

    @Test
    void testHerancaPublicacao() {
        assertTrue(r1 instanceof Publicacao);
    }

    @Test
    void testEqualsIguais() {
        assertTrue(r1.equals(r1Copy));
    }

    @Test
    void testEqualsDiferentes() {
        assertFalse(r1.equals(r1CopyErro));
    }

    @Test
    void testToString() {
        assertEquals(saidaEsperada, r1.toString());
    }
}
