package br.edu.ifba.saj.fwads.model;

import java.time.LocalDateTime;

public class Avaliacao extends Comentario {
    private Motorista motorista;
    private int nota;

    public Avaliacao(String feedback, LocalDateTime data, Usuario autor, Motorista motorista, int nota) {
        super(feedback, data, autor);
        this.motorista = motorista;
        this.nota = nota;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista novoMotorista) {
        this.motorista = novoMotorista;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int novaNota) {
        this.nota = novaNota;
    }
}