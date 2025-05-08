import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Voo {
    private UUID vooId;
    private int capacidadeMaxima;
    private List<Passageiro> passageiros;

    public Voo(int capacidadeMaxima) {
        this.vooId = UUID.randomUUID();
        this.capacidadeMaxima = capacidadeMaxima;
        this.passageiros = new ArrayList<>();
    }

    public UUID getVooId() {
        return vooId;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getAssentosDisponiveis() {
        return capacidadeMaxima - passageiros.size();
    }

    public boolean adicionarPassageiro(Passageiro passageiro) {
        if (getAssentosDisponiveis() > 0) {
            return passageiros.add(passageiro);
        }
        return false;
    }
}

class Passageiro {
    private UUID passageiroId;
    private String nome;

    public Passageiro(String nome) {
        this.passageiroId = UUID.randomUUID();
        this.nome = nome;
    }

    public UUID getPassageiroId() {
        return passageiroId;
    }

    public String getNome() {
        return nome;
    }
}

public class Reserva {
    private UUID reservaId;
    private Voo voo;
    private Passageiro passageiro;
    private boolean confirmada;

    public Reserva(Voo voo, Passageiro passageiro) {
        this.reservaId = UUID.randomUUID();
        this.voo = voo;
        this.passageiro = passageiro;
        this.confirmada = false;
    }

    public UUID getReservaId() {
        return reservaId;
    }

    public Voo getVoo() {
        return voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public boolean confirmarReserva() {
        if (!confirmada && voo.adicionarPassageiro(passageiro)) {
            this.confirmada = true;
            return true;
        }
        return false;
    }
}
