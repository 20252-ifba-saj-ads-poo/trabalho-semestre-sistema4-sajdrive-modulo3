package br.edu.ifba.saj.fwads.model;

import java.time.LocalDateTime;

public class Problema extends Comentario {
    private TipoProblema tipo;
    private Motorista motorista;
    private Veiculo veiculo;

    public Problema(String feedback, LocalDateTime data, Usuario autor, TipoProblema tipo, Motorista motorista, Veiculo veiculo) {
        super(feedback, data, autor);
        this.tipo = tipo;
        this.motorista = motorista;
        this.veiculo = veiculo;
    }

    public TipoProblema getTipo() {
        return tipo;
    }

    public void setTipo(TipoProblema novoTipo) {
        this.tipo = novoTipo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista novoMotorista) {
        this.motorista = novoMotorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo novoVeiculo) {
        this.veiculo = novoVeiculo;
    }
}