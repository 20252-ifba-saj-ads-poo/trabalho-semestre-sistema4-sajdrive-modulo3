package br.edu.ifba.saj.fwads.repository;

import br.edu.ifba.saj.fwads.model.AbstractModel;
import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioGenerico<T extends AbstractModel> {

    private HashMap<String, T> mapa;

    public RepositorioGenerico() {
        this.mapa = new HashMap<>();
    }

    public void salvar(T objeto) {
        this.mapa.put(objeto.getId(), objeto);
    }

    public T buscarPorId(String id) {
        return this.mapa.get(id);
    }

    public void remover(String id) {
        this.mapa.remove(id);
    }

    public ArrayList<T> listarTodos() {
        return new ArrayList<>(this.mapa.values());
    }
}