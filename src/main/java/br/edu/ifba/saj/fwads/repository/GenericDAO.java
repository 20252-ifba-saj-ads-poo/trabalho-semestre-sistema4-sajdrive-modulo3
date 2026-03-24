package br.edu.ifba.saj.fwads.repository;

import java.util.List;

public interface GenericDAO<T, ID> {
    void salvar(T entidade);
    void atualizar(T entidade);
    T buscarPorId(ID id);
    void remover(ID id);
    List<T> listarTodos();
}