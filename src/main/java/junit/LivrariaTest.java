package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teste.Impressao;
import teste.Livraria;
import teste.Livro;
import teste.Revista;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LivrariaTest {

    Livraria ccb;
    Revista r1;
    Livro l1, l2;

    @BeforeEach
    void setUp() {
        ccb = new Livraria("Chimas and Code books");
        r1 = new Revista("Superinteressante", LocalDate.of(2021, 3, 1), "Abril", 425);
        l1 = new Livro("O Senhor dos anéis - A Sociedade do Anel", LocalDate.of(1954, 5, 24), 468, "J. R. R. Tolkien");
        l2 = new Livro("Sistema de Banco de Dados", LocalDate.of(2012, 1, 1), 754,
                "Abraham Silberschatz", "Henry F. Korth", "S. Sudarshan");

        // mesmo setup do TestaApp
        ccb.addEstoque(r1);        // cod:R1
        ccb.addEstoque(l1, 3);     // cods L2, L3, L4
        ccb.addEstoque(l1);        // L5
        ccb.addEstoque(l2, 5);     // L6–L10
    }

    @Test
    void testQuantidadeExemplares() {
        assertEquals(4, ccb.getExemplares(new Livro("O Senhor dos anéis - A Sociedade do Anel",
                LocalDate.of(1954, 5, 24), 468, "J. R. R. Tolkien")));
        assertEquals(1, ccb.getExemplares(r1));
        assertEquals(5, ccb.getExemplares(l2));
    }

    @Test
    void testVendaDeLivrosERevistas() {
        Impressao copiaR1 = ccb.vende(r1);
        Impressao copiaL2 = ccb.vende(l2);
        copiaL2 = ccb.vende(l2);

        assertEquals("L7", copiaL2.getCodigo());
        assertEquals(LocalDate.now(), copiaL2.getData());
        assertEquals(3, ccb.getExemplares(l2));

        // sem revistas em estoque
        assertNull(ccb.vende(r1));
        assertEquals(0, ccb.getExemplares(r1));
    }
}
