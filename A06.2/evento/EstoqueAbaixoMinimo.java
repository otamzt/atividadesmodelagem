import java.time.LocalDateTime;
import java.util.UUID;

public class EstoqueAbaixoMinimo {
    private final UUID produtoId;
    private final int quantidadeAtual;
    private final int quantidadeMinima;
    private final LocalDateTime dataOcorrencia;

    public EstoqueAbaixoMinimo(UUID produtoId, int quantidadeAtual, int quantidadeMinima) {
        if (quantidadeAtual >= quantidadeMinima) {
            throw new IllegalArgumentException("Evento EstoqueAbaixoMinimo disparado incorretamente: quantidade atual não está abaixo da mínima.");
        }
        this.produtoId = produtoId;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
        this.dataOcorrencia = LocalDateTime.now();
    }

    public UUID getProdutoId() {
        return produtoId;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public LocalDateTime getDataOcorrencia() {
        return dataOcorrencia;
    }

    @Override
    public String toString() {
        return "EstoqueAbaixoMinimo{" +
               "produtoId=" + produtoId +
               ", quantidadeAtual=" + quantidadeAtual +
               ", quantidadeMinima=" + quantidadeMinima +
               ", dataOcorrencia=" + dataOcorrencia +
               '}';
    }

    public static void main(String[] args) {
        UUID produto1Id = UUID.randomUUID();

        try {
            EstoqueAbaixoMinimo evento1 = new EstoqueAbaixoMinimo(produto1Id, 5, 10);
            System.out.println("Evento 1 disparado: " + evento1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar evento 1: " + e.getMessage());
        }

        try {
            EstoqueAbaixoMinimo evento2 = new EstoqueAbaixoMinimo(produto1Id, 12, 10);
            System.out.println("Evento 2 disparado: " + evento2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar evento 2: " + e.getMessage());
        }
    }
}
