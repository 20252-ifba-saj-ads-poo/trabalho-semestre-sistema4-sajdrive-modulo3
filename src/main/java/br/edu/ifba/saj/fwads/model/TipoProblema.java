package br.edu.ifba.saj.fwads.model;

public class TipoProblema extends AbstractModel {
    private String descricao;
    private Prioridade prioridade;
    private boolean exigeVeiculo;

    public TipoProblema(String descricao, Prioridade prioridade, boolean exigeVeiculo) {
        super();
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.exigeVeiculo = exigeVeiculo;
    }

    public boolean isExigeVeiculo() {
        return exigeVeiculo;
    }
    public void setExigeVeiculo(boolean novaExigeVeiculo) {
        this.exigeVeiculo = novaExigeVeiculo;
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