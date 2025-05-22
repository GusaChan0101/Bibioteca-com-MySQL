package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarLivroNoBanco(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, isbn) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getIsbn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        String sql = "SELECT * FROM livros WHERE isbn = ?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, isbn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Livro(
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("isbn")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean emprestarLivro(String isbn, String usuarioId) {
        Livro livro = livros.stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(usuarioId))
                .findFirst()
                .orElse(null);

        if (livro == null || usuario == null) {
            return false;
        }

        boolean jaEmprestado = emprestimos.stream()
                .anyMatch(e -> e.getLivro().getIsbn().equals(isbn));
        if (jaEmprestado) {
            return false;
        }

        emprestimos.add(new Emprestimo(livro, usuario, LocalDate.now()));
        return true;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public static void main(String[] args) {
        // Inicialização da aplicação e interação com o usuário
        System.out.println("Bem-vindo à Biblioteca!");
    }
}