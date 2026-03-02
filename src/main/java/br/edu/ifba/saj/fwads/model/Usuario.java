package br.edu.ifba.saj.fwads.model;

public class Usuario extends Pessoa {
    private String categoria;

    public Usuario(String nome, String email, String cpf, String nascimento, String categoria) {
        super(nome, email, cpf, nascimento);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String novaCategoria) {
        this.categoria = novaCategoria;
    }
}
