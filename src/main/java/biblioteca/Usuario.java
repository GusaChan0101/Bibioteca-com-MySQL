package biblioteca;

public class Usuario {
    private String nome;
    private String id;
    private String contato;

    public Usuario(String nome, String id, String contato) {
        this.nome = nome;
        this.id = id;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getContato() {
        return contato;
    }
}