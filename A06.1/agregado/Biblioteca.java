import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class ISBN {
    private final String valor;

    public ISBN(String valor) {
        if (valor == null || valor.isEmpty()) {
            throw new IllegalArgumentException("ISBN não pode ser nulo ou vazio.");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ISBN isbn = (ISBN) obj;
        return valor.equals(isbn.valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }
}

class Livro {
    private final ISBN isbn;
    private String titulo;
    private boolean emprestado;

    public Livro(ISBN isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.emprestado = false;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    // O livro só pode ser emprestado/devolvido através da Biblioteca (raiz do agregado)
    protected void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return isbn.equals(livro.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}

public class Biblioteca {
    private final UUID bibliotecaId;
    private List<Livro> livros;

    public Biblioteca() {
        this.bibliotecaId = UUID.randomUUID();
        this.livros = new ArrayList<>();
    }

    public UUID getBibliotecaId() {
        return bibliotecaId;
    }

    public void adicionarLivro(ISBN isbn, String titulo) {
        Livro novoLivro = new Livro(isbn, titulo);
        if (!livros.contains(novoLivro)) {
            this.livros.add(novoLivro);
        }
    }

    public boolean emprestarLivro(ISBN isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn) && !livro.isEmprestado()) {
                livro.setEmprestado(true);
                return true;
            }
        }
        return false;
    }

    public boolean devolverLivro(ISBN isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn) && livro.isEmprestado()) {
                livro.setEmprestado(false);
                return true;
            }
        }
        return false;
    }

    public Livro buscarLivro(ISBN isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }
}
