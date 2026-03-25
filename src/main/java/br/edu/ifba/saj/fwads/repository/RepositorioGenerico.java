package br.edu.ifba.saj.fwads.repository;
 
import br.edu.ifba.saj.fwads.model.AbstractModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
 
public class RepositorioGenerico<T extends AbstractModel<String>> implements GenericDAO<T, String> {
    private Map<String, T> bancoDeDados = new HashMap<>();
 
    @Override
    public String salvar(T entidade) {
        // Para gerar um ID único para a entidade
        String novoId = UUID.randomUUID().toString();
        entidade.setId(novoId);
        entidade.setCreatedAt(LocalDateTime.now());
        entidade.setUpdatedAt(LocalDateTime.now());
        bancoDeDados.put(novoId, entidade);
        return novoId;
    }
 
    @Override
    public void atualizar(T entidade) {
        // Para registrar o momento da atualização e salvar
        entidade.setUpdatedAt(LocalDateTime.now());
        bancoDeDados.put(entidade.getId(), entidade);
    }
 
    @Override
    public T buscarPorId(String id) {
        return bancoDeDados.get(id);
    }
 
    @Override
    public void deletar(String id) {
        bancoDeDados.remove(id);
    }
 
    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(bancoDeDados.values());
    }
 
    public void remover(String id) {
        // Para manter compatibilidade com os services existentes
        deletar(id);
    }
}