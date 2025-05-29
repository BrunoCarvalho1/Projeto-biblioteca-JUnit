package org.example;

import org.example.UseCases.DevolverLivroUseCase;
import org.example.UseCases.EmprestarLivroUseCase;
import org.example.entidades.Aluno;
import org.example.entidades.Livro;
import org.example.entidades.Professor;
import org.example.repositorio.Biblioteca;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(new Livro(1, "Clean Code", 1));
        biblioteca.adicionarLivro(new Livro(2, "Java para leigos", 1));

        Aluno aluno = new Aluno(1, "João", 1);
        Professor professor = new Professor(2, "Maria");

        EmprestarLivroUseCase emprestar = new EmprestarLivroUseCase(biblioteca);
        DevolverLivroUseCase devolver = new DevolverLivroUseCase(biblioteca);

        System.out.println("Livros disponíveis:");
        biblioteca.listarLivrosDisponiveis().forEach(l -> System.out.println(l.getTitulo()));

        emprestar.executar(aluno, 1);
        emprestar.executar(professor, 2);

        System.out.println("\nApós empréstimos:");
        biblioteca.listarLivrosDisponiveis().forEach(l -> System.out.println(l.getTitulo()));

        devolver.executar(aluno, 1);
        devolver.executar(professor, 2);

        System.out.println("\nApós devoluções:");
        biblioteca.listarLivrosDisponiveis().forEach(l -> System.out.println(l.getTitulo()));
    }
}