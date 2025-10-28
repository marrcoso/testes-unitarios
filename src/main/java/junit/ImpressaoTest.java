package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teste.Impressao;
import teste.Revista;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ImpressaoTest {

    Revista r1, r1Copy;
    Impressao impressao;
    String saidaEsperada;

    @BeforeEach
    void setUp() {
        r1 = new Revista("Superinteressante", LocalDate.of(2021, 3, 1), "Abril", 425);
        r1Copy = new Revista("Superinteressante", LocalDate.of(2021, 3, 1), "Abril", 425);
        impressao = new Impressao(r1);
        saidaEsperada = "exemplar: R0| Data impressao: " + LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\nRevista: Superinteressante (3/2021) - editora Abril - edicao n:425";
    }

    @Test
    void testCodigo() {
        assertEquals("R0", impressao.getCodigo());
    }

    @Test
    void testToString() {
        assertEquals(saidaEsperada, impressao.toString());
    }

    @Test
    void testGetPublicacao() {
        assertEquals(r1Copy, impressao.getPublicacao());
    }
}
