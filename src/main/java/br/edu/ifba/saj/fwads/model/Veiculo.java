package br.edu.ifba.saj.fwads.model;

public class Veiculo extends AbstractModel<String> {
    private String modelo;
    private int ano;
    private String placa;
    private int capacidade;

    public Veiculo(String modelo, int ano, String placa, int capacidade) {
        super();
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo (String novoModelo) {
        this.modelo = novoModelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int novoAno) {
        this.ano = novoAno;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String novaPlaca) {
        this.placa = novaPlaca;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int novaCapacidade) {
        this.capacidade = novaCapacidade;
    }
}