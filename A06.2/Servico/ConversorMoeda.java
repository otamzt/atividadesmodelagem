import java.util.Map;

public class ConversorMoeda {

    private Map<String, Double> taxasDeCambio;

    public ConversorMoeda(Map<String, Double> taxasDeCambio) {
        this.taxasDeCambio = taxasDeCambio;
    }

    public double converter(String moedaOrigem, String moedaDestino, double valor) {
        if (!taxasDeCambio.containsKey(moedaOrigem)) {
            throw new IllegalArgumentException("Moeda de origem '" + moedaOrigem + "' não suportada.");
        }
        if (!taxasDeCambio.containsKey(moedaDestino)) {
            throw new IllegalArgumentException("Moeda de destino '" + moedaDestino + "' não suportada.");
        }

        double taxaOrigem = taxasDeCambio.get(moedaOrigem);
        double taxaDestino = taxasDeCambio.get(moedaDestino);

        return (valor / taxaOrigem) * taxaDestino;
    }
}
