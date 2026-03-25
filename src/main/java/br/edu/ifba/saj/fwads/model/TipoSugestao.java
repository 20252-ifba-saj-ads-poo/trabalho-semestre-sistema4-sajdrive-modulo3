package br.edu.ifba.saj.fwads.model;

public class TipoSugestao extends AbstractModel<String> {
    private String descricao;

    public TipoSugestao(String descricao) {
        super();
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }
}