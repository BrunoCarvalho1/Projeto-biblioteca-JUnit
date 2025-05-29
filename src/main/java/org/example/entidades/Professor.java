package org.example.entidades;

public class Professor extends Usuario{

    public Professor(int id, String nome) {
        super(String.valueOf(id), nome);
    }

    @Override
    public boolean podeEmprestar(Livro livro) {
        return true;
    }

    @Override
    public void registrarEmprestimo() {}

    @Override
    public void registrarDevolucao() {}
}
