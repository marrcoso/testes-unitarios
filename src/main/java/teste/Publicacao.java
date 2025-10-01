package teste;

import java.time.LocalDate;

public abstract class Publicacao {
    private String titulo;
    private LocalDate data;

    public Publicacao(String titulo, LocalDate data) {
        this.titulo = titulo;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getData() {
        return data;
    }
}
