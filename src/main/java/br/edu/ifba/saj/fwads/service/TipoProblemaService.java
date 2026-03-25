package br.edu.ifba.saj.fwads.service;

import br.edu.ifba.saj.fwads.model.TipoProblema;
import br.edu.ifba.saj.fwads.repository.RepositorioGenerico;
import java.util.List;
 
public class TipoProblemaService {
 
    private RepositorioGenerico<TipoProblema> repositorio;
 
    public TipoProblemaService() {
        this.repositorio = new RepositorioGenerico<>();
    }
 
    public void salvar(TipoProblema tipoProblema) {
        if (tipoProblema.getDescricao() == null || tipoProblema.getDescricao().isBlank()) {
            throw new IllegalArgumentException("Descrição do tipo de problema não pode ser vazia.");
        }
 
        this.repositorio.salvar(tipoProblema);
    }
 
    public void remover(String id) {
        this.repositorio.remover(id);
    }
 
    public List<TipoProblema> buscarTodos() {
        return this.repositorio.buscarTodos();
    }
}