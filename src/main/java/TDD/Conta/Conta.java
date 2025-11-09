package TDD.Conta;

import TDD.Cliente.Cliente;

public class Conta {
    private final Cliente cliente;
    private double saldo;
    private double limite;

    public Conta(Cliente cliente, double saldoInicial, double limite) {
        if (cliente == null)
            throw new ContaException("Cliente não pode ser nulo.");
        if (saldoInicial < 0)
            throw new ContaException("Saldo inicial não pode ser negativo.");
        if (limite < 0)
            throw new ContaException("Limite não pode ser negativo.");

        this.cliente = cliente;
        this.saldo = saldoInicial;
        this.limite = limite;
    }

    public double sacar(double valor) {
        if (valor <= 0)
            throw new ContaException("Valor de saque deve ser positivo.");
        if (valor > saldo + limite)
            return 0;
        saldo -= valor;
        return valor;
    }

    public double depositar(double valor) {
        if (valor <= 0)
            throw new ContaException("Valor de depósito deve ser positivo.");
        saldo += valor;
        return saldo;
    }

    public void alterarLimite(double novoLimite) {
        if (novoLimite < 0)
            throw new ContaException("Novo limite não pode ser negativo.");
        this.limite = novoLimite;
    }

    public void transferir(double valor, Conta destino) {
        if (destino == null)
            throw new ContaException("Conta destino não pode ser nula.");
        if (valor <= 0)
            throw new ContaException("Valor de transferência deve ser positivo.");
        if (valor > saldo + limite)
            throw new ContaException("Saldo insuficiente para transferência.");

        this.saldo -= valor;
        destino.depositar(valor);
    }

    public double getSaldo() { return saldo; }
    public double getLimite() { return limite; }
    public Cliente getCliente() { return cliente; }
}
