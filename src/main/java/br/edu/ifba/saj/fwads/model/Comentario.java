package br.edu.ifba.saj.fwads.model;

import java.time.LocalDateTime;

public class Comentario {
    private int id;
    private String feedback;
    private LocalDateTime data;
    private Usuario autor;

    public Comentario(int id, String feedback, LocalDateTime data, Usuario autor) {
        this.id = id;
        this.feedback = feedback;
        this.data = data;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }
    public void setId(int novoId) {
        this.id = novoId;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String novoFeedback) {
        this.feedback = novoFeedback;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData (LocalDateTime novaData) {
        this.data = novaData;
    }
    public Usuario getAutor() {
        return autor;
    }
    public void setAutor (Usuario novoAutor) {
        this.autor = novoAutor;
    }
}