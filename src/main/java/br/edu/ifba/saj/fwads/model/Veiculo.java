package br.edu.ifba.saj.fwads.model;

public class Veiculo {
    private String modelo;
    private int ano;
    private String placa;

    public Veiculo(String modelo, int ano, String placa) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
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
}