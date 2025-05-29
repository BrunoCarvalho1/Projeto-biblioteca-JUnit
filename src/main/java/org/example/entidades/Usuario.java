package org.example.entidades;

public abstract class Usuario {
    private String id;
    private String nome;

    public Usuario(String id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public abstract boolean podeEmprestar(Livro livro);

    public abstract void registrarEmprestimo();

    public abstract void registrarDevolucao();

    public String getNome() {
        return nome;
    }
}
