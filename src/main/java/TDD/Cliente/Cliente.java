package TDD.Cliente;

import java.time.LocalDate;

public class Cliente {
    private final String nome;
    private final String cpf;
    private final LocalDate dataNascimento;

    public Cliente(String nome, String cpf, LocalDate dataNascimento) {
        if (nome == null || !nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
            throw new ClienteException("Nome inválido: deve conter apenas letras e espaços.");
        }

        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new ClienteException("CPF inválido: formato deve ser XXX.YYY.ZZZ-WW.");
        }

        if (!cpfValido(cpf)) {
            throw new ClienteException("CPF inválido: dígitos verificadores incorretos.");
        }

        if (dataNascimento == null ||
                dataNascimento.isBefore(LocalDate.of(1900, 1, 1)) ||
                dataNascimento.isAfter(LocalDate.now())) {
            throw new ClienteException("Data de nascimento inválida.");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    private boolean cpfValido(String cpf) {
        // Remove pontuação
        String num = cpf.replaceAll("\\D", "");
        if (num.length() != 11 || num.chars().distinct().count() == 1) return false;

        int soma1 = 0, soma2 = 0;
        for (int i = 0; i < 9; i++) {
            int dig = Character.getNumericValue(num.charAt(i));
            soma1 += dig * (10 - i);
            soma2 += dig * (11 - i);
        }

        int d1 = 11 - (soma1 % 11);
        d1 = (d1 > 9) ? 0 : d1;

        soma2 += d1 * 2;
        int d2 = 11 - (soma2 % 11);
        d2 = (d2 > 9) ? 0 : d2;

        return num.endsWith(d1 + "" + d2);
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
}
