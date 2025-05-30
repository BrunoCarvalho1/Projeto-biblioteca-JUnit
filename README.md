# 📚 Projeto: Simulação de Biblioteca em Java

Este projeto simula o funcionamento básico de uma biblioteca, onde **alunos** e **professores** podem pegar emprestado e devolver livros. Utiliza **Java**, **Maven** e **JUnit 5** para testes.

## 🧱 Estrutura do Projeto

Entidades: Livro, Usuario, Aluno, Professor
Repositorio: Biblioteca
UseCases: EmprestarLivro, DevolverLivro
UseCasesTest: DevolverLivroUseCaseTest, EmprestarLivroUseCaseTest

## ✅ Requisitos

- Java 21 ou superior
- Maven 4.0 instalado e configurado

## ▶️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/BrunoCarvalho1/Projeto-biblioteca-JUnit.git
cd Projeto-biblioteca
Executar Main.java.

🧪 Exemplos de funcionalidades testadas
Aluno só consegue emprestar se tiver crédito.

Professor pode emprestar livremente.

Aluno recupera 1 crédito ao devolver.

Só é possível devolver um livro se o usuário foi quem emprestou.

📌 Tecnologias utilizadas
Java 21

Maven

JUnit 5
