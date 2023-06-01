package model;

import interfaces.Inseto;

public class Cigarra implements Inseto {

    private String nome;
    private int id;

    public Cigarra(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cigarra{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public void emitirSom() {
        System.out.println("sis-sis" + getNome());
    }
}
