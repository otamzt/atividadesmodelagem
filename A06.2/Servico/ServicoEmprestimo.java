import java.time.LocalDate;

public class ServicoEmprestimo {

    public Emprestimo emprestarLivro(Livro livro, Usuario usuario) {
        if (!livro.isDisponivel()) {
            throw new IllegalStateException("Livro '" + livro.getTitulo() + "' não está disponível para empréstimo.");
        }

        if (!usuario.isRegular()) {
            throw new IllegalArgumentException("Usuário '" + usuario.getNome() + "' não está em situação regular para empréstimo.");
        }

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = calcularDataDevolucao(usuario);

        livro.setDisponivel(false);
        return new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
    }

    private LocalDate calcularDataDevolucao(Usuario usuario) {
        return LocalDate.now().plusDays(14);
    }
}
