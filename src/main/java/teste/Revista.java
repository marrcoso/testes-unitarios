package teste;

import java.time.LocalDate;
import java.util.Objects;

public class Revista extends Publicacao{
    private int edicao;
    private String editora;

    public Revista(String titulo, LocalDate data, String editora, int edicao) {
        super(titulo, data);
        this.edicao = edicao;
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public String getEditora() {
        return editora;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Revista revista = (Revista) o;
        return edicao == revista.edicao && 
               Objects.equals(editora, revista.editora) &&
               Objects.equals(this.getTitulo(), revista.getTitulo()) &&
               Objects.equals(this.getData(), revista.getData());
    }

    @Override
    public String toString() {
        return "Revista: " + this.getTitulo() +
                " (" + this.getData().getMonthValue() + "/" + this.getData().getYear() + ")" +
                " - editora " + editora +
                " - edicao n:" + edicao;
    }
}
