package org.example.repositorio;

import org.example.entidades.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public List<Livro> listarLivrosDisponiveis() {
        return livros.stream().filter(Livro::isDisponivel).collect(Collectors.toList());
    }

    public Livro buscarLivroPorId(int id) {
        return livros.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }
}
