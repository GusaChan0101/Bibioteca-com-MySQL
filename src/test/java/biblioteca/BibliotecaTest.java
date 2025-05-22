package biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BibliotecaTest {

    @Test
    public void testAdicionarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "123");
        biblioteca.adicionarLivro(livro);
        assertTrue(biblioteca.getLivros().contains(livro));
    }

    @Test
    public void testRegistrarUsuario() {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("João", "u1", "joao@email.com");
        biblioteca.registrarUsuario(usuario);
        assertTrue(biblioteca.getUsuarios().contains(usuario));
    }

    @Test
    public void testEmprestarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "123");
        Usuario usuario = new Usuario("João", "u1", "joao@email.com");
        biblioteca.adicionarLivro(livro);
        biblioteca.registrarUsuario(usuario);
        boolean emprestado = biblioteca.emprestarLivro("123", "u1");
        assertTrue(emprestado);
        assertEquals(1, biblioteca.getEmprestimos().size());
        // Não deve permitir emprestar o mesmo livro novamente
        boolean emprestadoNovamente = biblioteca.emprestarLivro("123", "u1");
        assertFalse(emprestadoNovamente);
    }
}