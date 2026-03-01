package br.edu.ifba.saj.fwads.model;

public class Veiculo {
    private String modelo;
    private int ano;
    private String placa;
    private int frota;

    public Veiculo (String modelo, int ano, String placa, int frota) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.frota = frota;
    }

    public String getModelo () {
        return modelo;
    }

    public void setModelo (String novoModelo) {
        this.modelo = novoModelo;
    }

    public int getAno () {
        return ano;
    }

    public void setAno (int novoAno) {
        this.ano = novoAno;
    }

    public String getPlaca () {
        return placa;
    }

    public void setPlaca (String novaPlaca) {
        this.placa = novaPlaca;
    }

    public int getFrota () {
        return frota;
    }

    public void setFrota (int novaFrota) {
        this.frota = novaFrota;
    }
}