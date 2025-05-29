package usecasestest;

import org.example.UseCases.EmprestarLivroUseCase;
import org.example.entidades.Aluno;
import org.example.entidades.Livro;
import org.example.repositorio.Biblioteca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmprestarLivroUseCaseTest {

    @Test
    public void devePermitirEmprestimoParaAlunoComCredito(){
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "Clean Code", 1);
        biblioteca.adicionarLivro(livro);

        Aluno aluno = new Aluno(1, "Bruno", 1);
        EmprestarLivroUseCase useCase = new EmprestarLivroUseCase(biblioteca);

        boolean sucesso = useCase.executar(aluno, 1);

        assertTrue(sucesso);
        assertFalse(livro.isDisponivel());
        assertEquals(0, aluno.getCreditos());
    }

    @Test
    public void naoDevePermitirEmprestimoParaAlunoSemCredito() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(2, "Java Efetivo", 1);
        biblioteca.adicionarLivro(livro);

        Aluno aluno = new Aluno(2, "Maria", 0);
        EmprestarLivroUseCase useCase = new EmprestarLivroUseCase(biblioteca);

        boolean sucesso = useCase.executar(aluno, 2);

        assertFalse(sucesso);
        assertTrue(livro.isDisponivel());
        assertEquals(0, aluno.getCreditos());
    }
}
