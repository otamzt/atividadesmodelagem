import java.time.LocalDate;
import java.util.UUID;

public class ReservaConfirmadaEvento {
    private final UUID reservaId;
    private final UUID clienteId;
    private final LocalDate dataEntrada;
    private final LocalDate dataSaida;
    private final double custoTotal;
    private final LocalDate dataConfirmacao;

    public ReservaConfirmadaEvento(UUID reservaId, UUID clienteId, LocalDate dataEntrada, LocalDate dataSaida, double custoTotal) {
        this.reservaId = reservaId;
        this.clienteId = clienteId;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.custoTotal = custoTotal;
        this.dataConfirmacao = LocalDate.now(); // Data em que o evento foi criado (confirmação)
    }

    public UUID getReservaId() {
        return reservaId;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public LocalDate getDataConfirmacao() {
        return dataConfirmacao;
    }

    @Override
    public String toString() {
        return "ReservaConfirmadaEvento{" +
               "reservaId=" + reservaId +
               ", clienteId=" + clienteId +
               ", dataEntrada=" + dataEntrada +
               ", dataSaida=" + dataSaida +
               ", custoTotal=" + custoTotal +
               ", dataConfirmacao=" + dataConfirmacao +
               '}';
    }
}
