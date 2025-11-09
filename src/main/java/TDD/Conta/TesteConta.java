package TDD.Conta;

import TDD.Cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TesteConta {

    private Cliente cliente;
    private Conta conta;

    @BeforeEach
    void setup() {
        cliente = new Cliente("Joao Silva", "123.456.789-09", LocalDate.of(2000, 5, 20));
        conta = new Conta(cliente, 1000, 500);
    }

    @Test
    void deveSacarValorValido() {
        double valorSacado = conta.sacar(200);
        assertEquals(200, valorSacado);
        assertEquals(800, conta.getSaldo());
    }

    @Test
    void naoDevePermitirSaqueNegativoOuZero() {
        assertThrows(ContaException.class, () -> conta.sacar(0));
        assertThrows(ContaException.class, () -> conta.sacar(-10));
    }

    @Test
    void deveRetornarZeroQuandoSaqueMaiorQueSaldoMaisLimite() {
        double valor = conta.sacar(2000);
        assertEquals(0, valor);
    }

    @Test
    void deveDepositarValorPositivo() {
        double novoSaldo = conta.depositar(500);
        assertEquals(1500, novoSaldo);
    }

    @Test
    void naoDeveDepositarValorNegativoOuZero() {
        assertThrows(ContaException.class, () -> conta.depositar(0));
        assertThrows(ContaException.class, () -> conta.depositar(-10));
    }

    @Test
    void deveAlterarLimiteValido() {
        conta.alterarLimite(800);
        assertEquals(800, conta.getLimite());
    }

    @Test
    void naoDeveAlterarLimiteParaNegativo() {
        assertThrows(ContaException.class, () -> conta.alterarLimite(-1));
    }

    @Test
    void deveTransferirComSucessoEntreContas() {
        Conta destino = new Conta(cliente, 0, 0);
        conta.transferir(500, destino);
        assertEquals(500, destino.getSaldo());
        assertEquals(500, conta.getSaldo());
    }

    @Test
    void naoDeveTransferirValorNegativoOuZero() {
        Conta destino = new Conta(cliente, 0, 0);
        assertThrows(ContaException.class, () -> conta.transferir(0, destino));
    }

    @Test
    void naoDeveTransferirParaContaNula() {
        assertThrows(ContaException.class, () -> conta.transferir(100, null));
    }

    @Test
    void naoDeveTransferirSeSaldoInsuficiente() {
        Conta destino = new Conta(cliente, 0, 0);
        assertThrows(ContaException.class, () -> conta.transferir(2000, destino));
    }
}
