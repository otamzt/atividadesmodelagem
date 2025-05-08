public final class Temperatura {
    private final double celsius;

    public Temperatura(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Temperatura inválida: abaixo do zero absoluto.");
        }
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    public double toFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Temperatura) && Double.compare(((Temperatura) obj).celsius, this.celsius) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(celsius);
    }

    @Override
    public String toString() {
        return celsius + "°C";
    }

    public static void main(String[] args) {
        Temperatura temp1 = new Temperatura(25.0);
        System.out.println(temp1 + " em Fahrenheit: " + temp1.toFahrenheit() + "°F");

        try {
            Temperatura tempInvalida = new Temperatura(-300.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
