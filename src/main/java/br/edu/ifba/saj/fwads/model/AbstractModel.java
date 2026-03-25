package br.edu.ifba.saj.fwads.model;
 
import java.time.LocalDateTime;
 
public abstract class AbstractModel<T> {
    private T id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String criadoPor;
    private String atualizadoPor;
 
    public T getId() {
        return id;
    }
 
    public void setId(T id) {
        this.id = id;
    }
 
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
 
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
 
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
 
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
 
    public String getCriadoPor() {
        return criadoPor;
    }
 
    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }
 
    public String getAtualizadoPor() {
        return atualizadoPor;
    }
 
    public void setAtualizadoPor(String atualizadoPor) {
        this.atualizadoPor = atualizadoPor;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractModel)) return false;
        AbstractModel<?> outro = (AbstractModel<?>) obj;
        return this.id.equals(outro.id);
    }
}