package br.edu.ifba.saj.fwads.service;
 
import br.edu.ifba.saj.fwads.model.Sugestao;
import br.edu.ifba.saj.fwads.repository.RepositorioGenerico;
import java.util.List;
 
public class SugestaoService {
 
    private RepositorioGenerico<Sugestao> repositorio;
 
    public SugestaoService() {
        this.repositorio = new RepositorioGenerico<>();
    }
 
    public void salvar(Sugestao sugestao) {
        if (sugestao.getTipo() == null) {
            throw new IllegalArgumentException("Tipo da sugestão não pode ser vazio.");
        }
 
        if (sugestao.getFeedback() == null || sugestao.getFeedback().isBlank()) {
            throw new IllegalArgumentException("Descrição da sugestão não pode ser vazia.");
        }
 
        this.repositorio.salvar(sugestao);
    }
 
    public void remover(String id) {
        this.repositorio.remover(id);
    }
 
    public List<Sugestao> buscarTodos() {
        return this.repositorio.buscarTodos();
    }
}