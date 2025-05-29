package org.example.entidades;

public class Livro {
    private int id;
    private String titulo;
    private int valorCredito;
    private boolean disponivel;
    private Usuario emprestadoPara;

    public Livro(int id, String titulo, int valorCredito) {
        this.id = id;
        this.titulo = titulo;
        this.valorCredito = valorCredito;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestarPara(Usuario usuario) {
        this.disponivel = false;
        this.emprestadoPara = usuario;
    }

    public void devolver() {
        this.disponivel = true;
        this.emprestadoPara = null;
    }

    public Usuario getEmprestadoPara() {
        return emprestadoPara;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public int getValorCredito() {
        return valorCredito;
    }
}
