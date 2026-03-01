package br.edu.ifba.saj.fwads.model;

public class Motorista extends Pessoa {
    private String matricula;
    private Veiculo veiculo;

    public Motorista(String nome, String email, String cpf, String matricula, Veiculo veiculo) {
        super(nome, email, cpf);
        this.matricula = matricula;
        this.veiculo = veiculo;
    }

    public String getMatricula () {
        return matricula;
    }

    public void setMatricula (String novaMatricula) {
    this.matricula = novaMatricula;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    public void setVeiculo (Veiculo novoVeiculo) {
        this.veiculo = novoVeiculo;
    }
}