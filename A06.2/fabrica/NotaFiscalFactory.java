import java.math.BigDecimal;
import java.util.List;

public class NotaFiscalFactory {

    private final BigDecimal taxaImpostoPadrao = new BigDecimal("0.18"); // Exemplo de taxa de imposto

    public NotaFiscal gerarNotaFiscal(List<ItemNotaFiscal> itens) {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("A nota fiscal deve conter pelo menos um item.");
        }

        BigDecimal valorTotalItens = BigDecimal.ZERO;
        for (ItemNotaFiscal item : itens) {
            valorTotalItens = valorTotalItens.add(item.getValorTotal());
        }

        BigDecimal valorImposto = valorTotalItens.multiply(taxaImpostoPadrao);
        BigDecimal valorTotalNota = valorTotalItens.add(valorImposto);

        return new NotaFiscal(itens, valorTotalItens, valorImposto, valorTotalNota);
    }
}
