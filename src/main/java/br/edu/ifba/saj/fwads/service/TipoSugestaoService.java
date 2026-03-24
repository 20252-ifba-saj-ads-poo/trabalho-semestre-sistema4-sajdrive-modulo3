package br.edu.ifba.saj.fwads.service;

import br.edu.ifba.saj.fwads.model.TipoSugestao;
import br.edu.ifba.saj.fwads.repository.RepositorioGenerico;
import java.util.ArrayList;

public class TipoSugestaoService {

    private RepositorioGenerico<TipoSugestao> repositorio;

    public TipoSugestaoService() {
        this.repositorio = new RepositorioGenerico<>();
    }

    public void salvar(TipoSugestao tipoSugestao) {
        if (tipoSugestao.getDescricao() == null || tipoSugestao.getDescricao().isBlank()) {
            throw new IllegalArgumentException("Descrição do tipo de sugestão não pode ser vazia.");
        }
        this.repositorio.salvar(tipoSugestao);
    }

    public void remover(String id) {
        this.repositorio.remover(id);
    }

    public ArrayList<TipoSugestao> listarTodos() {
        return this.repositorio.listarTodos();
    }
}