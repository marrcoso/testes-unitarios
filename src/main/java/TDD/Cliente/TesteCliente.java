package TDD.Cliente;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TesteCliente {

    @Test
    void deveCriarClienteValido() {
        Cliente c = new Cliente("Joao Silva", "123.456.789-09", LocalDate.of(2000, 5, 20));
        assertEquals("Joao Silva", c.getNome());
    }

    @Test
    void deveLancarExcecaoParaNomeInvalido() {
        assertThrows(ClienteException.class, () ->
                new Cliente("Joao123", "123.456.789-09", LocalDate.of(2000, 1, 1))
        );
    }

    @Test
    void deveLancarExcecaoParaFormatoDeCpfInvalido() {
        assertThrows(ClienteException.class, () ->
                new Cliente("Maria", "12345678909", LocalDate.of(1999, 1, 1))
        );
    }

    @Test
    void deveLancarExcecaoParaCpfInvalido() {
        assertThrows(ClienteException.class, () ->
                new Cliente("Maria", "111.111.111-11", LocalDate.of(1999, 1, 1))
        );
    }

    @Test
    void deveLancarExcecaoParaDataNascimentoFutura() {
        assertThrows(ClienteException.class, () ->
                new Cliente("Maria", "123.456.789-09", LocalDate.now().plusDays(1))
        );
    }

    @Test
    void deveLancarExcecaoParaDataNascimentoMuitoAntiga() {
        assertThrows(ClienteException.class, () ->
                new Cliente("Maria", "123.456.789-09", LocalDate.of(1800, 1, 1))
        );
    }
}
