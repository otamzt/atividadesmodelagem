import java.util.UUID;

public class ReservaHotel {
    private final UUID reservaId;
    private boolean checkedIn;

    public ReservaHotel() {
        this.reservaId = UUID.randomUUID();
        this.checkedIn = false;
    }

    public UUID getReservaId() {
        return reservaId;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void checkIn() {
        this.checkedIn = true;
    }

    public boolean podeCancelar() {
        return !this.checkedIn;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof ReservaHotel) && ((ReservaHotel) obj).reservaId.equals(this.reservaId);
    }

    @Override
    public int hashCode() {
        return reservaId.hashCode();
    }
}
