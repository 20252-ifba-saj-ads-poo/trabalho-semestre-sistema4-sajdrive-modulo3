package br.edu.ifba.saj.fwads.model;

public class Pessoa {
    private String nome;
    private String email;
    private String cpf;
    private String nascimento;

    public Pessoa (String nome, String email, String cpf, String nascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }
    public String getCPF() {
        return cpf;
    }
    public void setCPF(String novoCPF) {
        this.cpf = novoCPF;
    }
    public String getNascimento() {
        return nascimento;
    }
    public void setNascimento(String novoNascimento) {
        this.nascimento = novoNascimento;
    }
}