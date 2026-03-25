package br.edu.ifba.saj.fwads.service;
 
import br.edu.ifba.saj.fwads.model.Avaliacao;
import br.edu.ifba.saj.fwads.model.Veiculo;
import br.edu.ifba.saj.fwads.repository.RepositorioGenerico;
import java.util.List;
 
public class VeiculoService {
 
    private RepositorioGenerico<Veiculo> repositorio;
 
    public VeiculoService() {
        this.repositorio = new RepositorioGenerico<>();
    }
 
    public void salvar(Veiculo veiculo) {
        if (veiculo.getPlaca() == null || veiculo.getPlaca().isBlank()) {
            throw new IllegalArgumentException("Placa do veículo não pode ser vazia.");
        }
 
        this.repositorio.salvar(veiculo);
    }
 
    public void remover(String id) {
        this.repositorio.remover(id);
    }
 
    public List<Veiculo> buscarTodos() {
        return this.repositorio.buscarTodos();
    }
}