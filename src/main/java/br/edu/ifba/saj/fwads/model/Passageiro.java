package br.edu.ifba.saj.fwads.model;

public class Passageiro extends Usuario {
    private Categoria categoria;

    public Passageiro(int id, String nome, String email, String cpf, String nascimento, Categoria categoria) {
        super(id, nome, email, cpf, nascimento);
        this.categoria = categoria;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria novaCategoria) {
        this.categoria = novaCategoria;
    }
}