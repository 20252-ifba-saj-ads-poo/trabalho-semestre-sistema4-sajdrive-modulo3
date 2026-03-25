package br.edu.ifba.saj.fwads.service;
 
import br.edu.ifba.saj.fwads.model.Problema;
import br.edu.ifba.saj.fwads.repository.RepositorioGenerico;
import java.util.List;
 
public class ProblemaService {
 
    private RepositorioGenerico<Problema> repositorio;
 
    public ProblemaService() {
        this.repositorio = new RepositorioGenerico<>();
    }
 
    public void salvar(Problema problema) {
        if (problema.getTipo() == null) {
            throw new IllegalArgumentException("Categoria do problema não pode ser vazia.");
        }
 
        if (problema.getFeedback() == null || problema.getFeedback().isBlank()) {
            throw new IllegalArgumentException("Descrição do problema não pode ser vazia.");
        }
 
        this.repositorio.salvar(problema);
    }
 
    public void remover(String id) {
        this.repositorio.remover(id);
    }
 
    public List<Problema> listarTodos() {
        return this.repositorio.listarTodos();
    }
}