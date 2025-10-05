package teste;

import java.util.ArrayList;

class Livraria {
    private String nome;
    private ArrayList<Impressao> estoque;
    public Livraria(String nome) {
        this.nome = nome;
        this.estoque = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    
    public int getExemplares(Publicacao publicacao) {
        int count = 0;

        for (Impressao impressao : estoque) {
            if (impressao.getPublicacao().equals(publicacao)) {
                count++;
            }
        }
        return count;
    }

    public void addEstoque(Publicacao publicacao) {
        estoque.add(new Impressao(publicacao));
    }

    public void addEstoque(Publicacao publicacao, int x) {
        for (int i = 0; i < x; i++) {
            estoque.add(new Impressao(publicacao));
        }
    }

    public Impressao vende(Publicacao publicacao) {
        for (Impressao i : estoque) {
            if (i.getPublicacao().equals(publicacao)) {
                estoque.remove(i);
                return i;
            }
        }
        return null;
    }

}
