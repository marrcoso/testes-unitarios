package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teste.Livro;
import teste.Publicacao;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    Livro l1, l1Copy, l1CopyComErro, l2;

    @BeforeEach
    void setUp() {
        l1 = new Livro("O Senhor dos anéis - A Sociedade do Anel", LocalDate.of(1954, 5, 24), 468, "J. R. R. Tolkien");
        l1Copy = new Livro("O Senhor dos anéis - A Sociedade do Anel", LocalDate.of(1954, 5, 24), 468, "J. R. R. Tolkien");
        l1CopyComErro = new Livro("O Senhor dos anéis - A Sociedade do Anel", LocalDate.of(1954, 5, 24), 468, "J. R. R. Tolkie");
        l2 = new Livro("Sistema de Banco de Dados", LocalDate.of(2012, 1, 1), 754,
                "Abraham Silberschatz", "Henry F. Korth", "S. Sudarshan");
    }

    @Test
    void testToString() {
        String esperado = "Livro: Sistema de Banco de Dados (2012) - 754 paginas - Autores: Abraham Silberschatz, Henry F. Korth, S. Sudarshan";
        assertEquals(esperado, l2.toString());
    }

    @Test
    void testEqualsIguais() {
        assertTrue(l1.equals(l1Copy));
    }

    @Test
    void testEqualsDiferentes() {
        assertFalse(l1.equals(l1CopyComErro));
    }

    @Test
    void testHerancaPublicacao() {
        assertTrue(l1 instanceof Publicacao);
    }

    @Test
    void testGetAutores() {
        assertEquals("Henry F. Korth", l2.getAutores()[1]);
    }

    @Test
    void testGetData() {
        assertEquals(144, l1.getData().getDayOfYear());
    }

    @Test
    void testGettersTituloPaginas() {
        assertEquals("O Senhor dos anéis - A Sociedade do Anel", l1.getTitulo());
        assertEquals(468, l1.getPaginas());
    }
}
