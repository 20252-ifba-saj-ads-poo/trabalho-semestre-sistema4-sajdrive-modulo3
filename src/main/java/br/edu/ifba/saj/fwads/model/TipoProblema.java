package br.edu.ifba.saj.fwads.model;

public class TipoProblema {
    private int id;
    private String descricao;
    public enum Prioridade {Alta, Regular, Baixa}
    private Prioridade prioridade;

    public TipoProblema(int id, String descricao, Prioridade prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }
    public void setId(int novoId) {
        this.id = novoId;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(Prioridade novaPrioridade) {
        this.prioridade = novaPrioridade;
    }
}