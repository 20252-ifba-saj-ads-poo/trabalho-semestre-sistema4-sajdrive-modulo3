package br.edu.ifba.saj.fwads.service;
 
import br.edu.ifba.saj.fwads.model.Passageiro;
import br.edu.ifba.saj.fwads.repository.RepositorioGenerico;
import java.util.List;
 
public class PassageiroService {
 
    private RepositorioGenerico<Passageiro> repositorio;
 
    public PassageiroService() {
        this.repositorio = new RepositorioGenerico<>();
    }
 
    public void salvar(Passageiro passageiro) {
        if (passageiro.getNome() == null || passageiro.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do passageiro não pode ser vazio.");
        }
 
        if (passageiro.getCPF() == null || passageiro.getCPF().isBlank()) {
            throw new IllegalArgumentException("CPF do passageiro não pode ser vazio.");
        }
 
        this.repositorio.salvar(passageiro);
    }
 
    public void remover(String id) {
        this.repositorio.remover(id);
    }
 
    public List<Passageiro> buscarTodos() {
        return this.repositorio.buscarTodos();
    }
}