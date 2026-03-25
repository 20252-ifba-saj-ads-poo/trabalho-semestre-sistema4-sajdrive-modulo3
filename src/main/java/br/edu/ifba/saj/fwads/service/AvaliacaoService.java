package br.edu.ifba.saj.fwads.service;
 
import br.edu.ifba.saj.fwads.model.Avaliacao;
import br.edu.ifba.saj.fwads.model.AvaliacaoInvalidaException;
import br.edu.ifba.saj.fwads.repository.RepositorioGenerico;
import java.util.List;
 
public class AvaliacaoService {
 
    private RepositorioGenerico<Avaliacao> repositorio;
 
    public AvaliacaoService() {
        this.repositorio = new RepositorioGenerico<>();
    }
 
    public void salvar(Avaliacao avaliacao) throws AvaliacaoInvalidaException {
        if (avaliacao.getMotorista() == null) {
            throw new AvaliacaoInvalidaException("Selecione um motorista para avaliar.");
        }
 
        if (avaliacao.getNota() < 1 || avaliacao.getNota() > 5) {
            throw new AvaliacaoInvalidaException("A nota deve ser entre 1 e 5.");
        }
 
        this.repositorio.salvar(avaliacao);
    }
 
    public void remover(String id) {
        this.repositorio.remover(id);
    }
 
    public List<Avaliacao> listarTodos() {
        return this.repositorio.listarTodos();
    }
}