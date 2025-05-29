package org.example.entidades;

public class Aluno extends Usuario{

    private int creditos;

    public Aluno(int id, String nome, int creditos) {
        super(String.valueOf(id), nome);
        this.creditos = creditos;
    }

    @Override
    public boolean podeEmprestar(Livro livro) {
        return creditos > 0;
    }

    @Override
    public void registrarEmprestimo() {
        creditos--;
    }

    @Override
    public void registrarDevolucao() {
        creditos++;
    }

    public int getCreditos() {
        return creditos;
    }
}
