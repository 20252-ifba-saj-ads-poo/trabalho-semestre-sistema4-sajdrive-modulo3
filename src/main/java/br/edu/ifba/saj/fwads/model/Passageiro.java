package br.edu.ifba.saj.fwads.model;

public class Passageiro extends Usuario {
    private String categoria;

    public Passageiro(int id, String nome, String email, String cpf, String nascimento, String categoria) {
        super(id, nome, email, cpf, nascimento);
        this.categoria = categoria;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String novaCategoria) {
        this.categoria = novaCategoria;
    }
}