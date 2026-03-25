package br.edu.ifba.saj.fwads.model;

public class Passageiro extends Usuario {
    private TipoPassageiro tipo;

    public Passageiro(String nome, String email, String cpf, String nascimento, TipoPassageiro tipo) {
        super(nome, email, cpf, nascimento);
        this.tipo = tipo;
    }

    public TipoPassageiro getTipo() {
        return tipo;
    }

    public void setTipo(TipoPassageiro novoTipo) {
        this.tipo = novoTipo;
    }
}