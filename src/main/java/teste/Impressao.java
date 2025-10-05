package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Impressao {
    private static int totalInstancias = 0;
    private LocalDate data;
    private Publicacao publicacao;
    private String codigo;
    
    public Impressao(Publicacao publicacao) {
        this(publicacao, LocalDate.now());
    }
    
    public Impressao(Publicacao publicacao, LocalDate data) {
        this.publicacao = publicacao;
        this.data = data;
        
        if (publicacao instanceof Revista) {
            this.codigo = "R" + totalInstancias;
        } else if (publicacao instanceof Livro) {
            this.codigo = "L" + totalInstancias;
        }
        
        totalInstancias++;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public LocalDate getData() {
        return data;
    }
    
    public Publicacao getPublicacao() {
        return publicacao;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "exemplar: " + codigo + "| Data impressao: " + data.format(formatter) + "\n" + publicacao.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Impressao that = (Impressao) o;
        return Objects.equals(codigo, that.codigo);
    }
}
