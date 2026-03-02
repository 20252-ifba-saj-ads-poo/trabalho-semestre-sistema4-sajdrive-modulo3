package br.edu.ifba.saj.fwads.model;

public class Comentario {
    private String feedback;
    private String data;
    private Usuario autor;

    public Comentario(String feedback, String data, Usuario autor) {
        this.feedback = feedback;
        this.data = data;
        this.autor = autor;
    }

    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String novoFeedback) {
        this.feedback = novoFeedback;
    }
    public String getData() {
        return data;
    }
    public void setData (String novaData) {
        this.data = novaData;
    }
    public Usuario getAutor() {
        return autor;
    }
    public void setAutor (Usuario novoAutor) {
        this.autor = novoAutor;
    }
}