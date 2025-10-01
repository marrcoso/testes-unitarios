package teste;

import java.time.LocalDate;
import java.util.Objects;

public class Livro extends Publicacao {
    private String[] autores;
    private Publicacao publicacao;
    private int paginas;

    public Livro(String titulo, LocalDate data, int paginas, String... autores) {
        super(titulo, data);
        this.autores = autores;
        this.paginas = paginas;
    }

    public String[] getAutores() {
        return autores;
    }

    public int getPaginas() {
        return paginas;
    }

    private String[] verificarAutores() {
        if (autores != null) return autores;
        return new String[]{"Sem autor definido"};
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return paginas == livro.paginas && Objects.deepEquals(verificarAutores(), livro.verificarAutores());
    }

    @Override
    public String toString() {
        return "Livro: " + this.getTitulo() +
                " (" + this.getData() + ") " +
                " - " + paginas + " páginas - " +
                "Autores: " + String.join(", ", verificarAutores());
    }
}
