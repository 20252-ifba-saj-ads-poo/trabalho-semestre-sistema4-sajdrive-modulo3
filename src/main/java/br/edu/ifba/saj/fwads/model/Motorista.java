package br.edu.ifba.saj.fwads.model;

public class Motorista extends Usuario {
    private String matricula;

    public Motorista(int id, String nome, String email, String cpf, String nascimento, String matricula) {
        super(id, nome, email, cpf, nascimento);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String novaMatricula) {
        this.matricula = novaMatricula;
    }
}