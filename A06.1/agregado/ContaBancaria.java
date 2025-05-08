import java.util.UUID;

public class ContaBancaria {
    private final UUID contaId;
    private double saldo;

    public ContaBancaria() {
        this.contaId = UUID.randomUUID();
        this.saldo = 0.0;
    }

    public UUID getContaId() {
        return contaId;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (this.saldo - valor < 0) {
            throw new IllegalStateException("Saldo insuficiente para saque.");
        }
        this.saldo -= valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ContaBancaria that = (ContaBancaria) obj;
        return contaId.equals(that.contaId);
    }

    @Override
    public int hashCode() {
        return contaId.hashCode();
    }
}
