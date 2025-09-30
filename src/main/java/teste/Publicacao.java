package teste;

public abstract class Publicacao {
    private String titulo;
    private int data;

    public Publicacao(String titulo, int data) {
        this.titulo = titulo;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getData() {
        return data;
    }
}
