package br.edu.ifba.saj.fwads.model;

import java.time.LocalDateTime;

public class Viagem extends AbstractModel {
    private Motorista motorista;
    private Passageiro passageiro;
    private Veiculo veiculo;
    private String origem;
    private String destino;
    private LocalDateTime data;

    public Viagem(Motorista motorista, Passageiro passageiro, Veiculo veiculo, String origem, String destino, LocalDateTime data) {
        super();
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.veiculo = veiculo;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
    }

    public Motorista getMotorista() {
        return motorista;
    }
    public void setMotorista(Motorista novoMotorista) {
        this.motorista = novoMotorista;
    }
    public Passageiro getPassageiro() {
        return passageiro;
    }
    public void setPassageiro(Passageiro novoPassageiro) {
        this.passageiro = novoPassageiro;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo novoVeiculo) {
        this.veiculo = novoVeiculo;
    }
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String novaOrigem) {
        this.origem = novaOrigem;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String novoDestino) {
        this.destino = novoDestino;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime novaData) {
        this.data = novaData;
    }
}