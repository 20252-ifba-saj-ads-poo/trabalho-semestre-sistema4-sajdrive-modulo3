package br.edu.ifba.saj.fwads.repository;

import br.edu.ifba.saj.fwads.model.AbstractModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioGenerico<T extends AbstractModel> implements GenericDAO<T, String> {

    private HashMap<String, T> mapa;

    public RepositorioGenerico() {
        this.mapa = new HashMap<>();
    }

    @Override
    public void salvar(T objeto) {
        this.mapa.put(objeto.getId(), objeto);
    }

    @Override
    public void atualizar(T objeto) {
        this.mapa.put(objeto.getId(), objeto);
    }

    @Override
    public T buscarPorId(String id) {
        return this.mapa.get(id);
    }

    @Override
    public void remover(String id) {
        this.mapa.remove(id);
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(this.mapa.values());
    }
}