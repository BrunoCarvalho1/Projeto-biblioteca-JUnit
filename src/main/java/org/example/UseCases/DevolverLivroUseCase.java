package org.example.UseCases;

import org.example.entidades.Livro;
import org.example.entidades.Usuario;
import org.example.repositorio.Biblioteca;

public class DevolverLivroUseCase {

    private Biblioteca biblioteca;

    public DevolverLivroUseCase(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean executar(Usuario usuario, int livroId) {
        Livro livro = biblioteca.buscarLivroPorId(livroId);
        if (livro == null || livro.isDisponivel() || livro.getEmprestadoPara() != usuario)
            return false;

        livro.devolver();
        usuario.registrarDevolucao();
        return true;
    }
}
