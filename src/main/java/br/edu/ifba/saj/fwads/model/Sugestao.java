package br.edu.ifba.saj.fwads.model;

import java.time.LocalDateTime;

public class Sugestao extends Comentario {
    private TipoSugestao tipo;
    private Veiculo veiculo;

    public Sugestao(String feedback, LocalDateTime data, Usuario autor, TipoSugestao tipo, Veiculo veiculo) {
        super(feedback, data, autor);
        this.tipo = tipo;
        this.veiculo = veiculo;
    }

    public TipoSugestao getTipo() {
        return tipo;
    }

    public void setTipo(TipoSugestao novoTipo) {
        this.tipo = novoTipo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo novoVeiculo) {
        this.veiculo = novoVeiculo;
    }
}