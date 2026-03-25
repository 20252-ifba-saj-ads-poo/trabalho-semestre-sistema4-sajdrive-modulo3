package br.edu.ifba.saj.fwads.service;
 
import br.edu.ifba.saj.fwads.model.Motorista;
import br.edu.ifba.saj.fwads.repository.RepositorioGenerico;
import java.util.List;
 
public class MotoristaService {
 
    private RepositorioGenerico<Motorista> repositorio;
 
    public MotoristaService() {
        this.repositorio = new RepositorioGenerico<>();
    }
 
    public void salvar(Motorista motorista) {
        if (motorista.getNome() == null || motorista.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do motorista não pode ser vazio.");
        }
 
        if (motorista.getCPF() == null || motorista.getCPF().isBlank()) {
            throw new IllegalArgumentException("CPF do motorista não pode ser vazio.");
        }
 
        this.repositorio.salvar(motorista);
    }
 
    public void remover(String id) {
        this.repositorio.remover(id);
    }
 
    public List<Motorista> listarTodos() {
        return this.repositorio.buscarTodos();
    }
}