package usecasestest;

import org.example.UseCases.DevolverLivroUseCase;
import org.example.UseCases.EmprestarLivroUseCase;
import org.example.entidades.Aluno;
import org.example.entidades.Livro;
import org.example.repositorio.Biblioteca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DevolverLivroUseCaseTest {

    @Test
    public void devePermitirDevolucaoPorQuemPegouLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "Refatoração", 1);
        biblioteca.adicionarLivro(livro);

        Aluno aluno = new Aluno(1, "Carlos", 1);
        new EmprestarLivroUseCase(biblioteca).executar(aluno, 1);

        DevolverLivroUseCase useCase = new DevolverLivroUseCase(biblioteca);
        boolean sucesso = useCase.executar(aluno, 1);

        assertTrue(sucesso);
        assertTrue(livro.isDisponivel());
        assertEquals(1, aluno.getCreditos()); // voltou ao normal
    }

    @Test
    public void naoDevePermitirDevolucaoSeUsuarioNaoEmprestouLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "Domain-Driven Design", 1);
        biblioteca.adicionarLivro(livro);

        Aluno joao = new Aluno(1, "João", 1);
        Aluno maria = new Aluno(2, "Maria", 1);

        new EmprestarLivroUseCase(biblioteca).executar(joao, 1);

        DevolverLivroUseCase useCase = new DevolverLivroUseCase(biblioteca);
        boolean sucesso = useCase.executar(maria, 1);

        assertFalse(sucesso);
        assertFalse(livro.isDisponivel());
        assertEquals(0, joao.getCreditos()); // Maria não devolve, João ainda sem crédito
        assertEquals(1, maria.getCreditos());
    }

}
