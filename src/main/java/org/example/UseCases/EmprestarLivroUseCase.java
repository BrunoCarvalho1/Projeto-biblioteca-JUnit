package org.example.UseCases;

import org.example.entidades.Livro;
import org.example.entidades.Usuario;
import org.example.repositorio.Biblioteca;

public class EmprestarLivroUseCase {

    private Biblioteca biblioteca;

    public EmprestarLivroUseCase(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean executar(Usuario usuario, int livroId) {
        Livro livro = biblioteca.buscarLivroPorId(livroId);
        if (livro == null || !livro.isDisponivel()) return false;

        if (usuario.podeEmprestar(livro)) {
            livro.emprestarPara(usuario);
            usuario.registrarEmprestimo();
            return true;
        }

        return false;
    }
}
