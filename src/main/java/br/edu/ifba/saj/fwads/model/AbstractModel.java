package br.edu.ifba.saj.fwads.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class AbstractModel {

    private String id;
    private LocalDateTime dataCriacao;

    public AbstractModel() {
        this.id = UUID.randomUUID().toString();
        this.dataCriacao = LocalDateTime.now();
    }
    public String getId() {
        return id;
    }
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof AbstractModel)) return false;
    AbstractModel outro = (AbstractModel) obj;
    return this.id.equals(outro.id);
    }
}