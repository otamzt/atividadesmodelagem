public class Livro {
    private final String isbn;
    private String titulo;

    public Livro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCitacaoABNT() {
        return titulo.toUpperCase() + ".";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Livro) && ((Livro) obj).isbn.equals(this.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
