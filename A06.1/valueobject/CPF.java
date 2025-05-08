public final class CPF {
    private final String valor;

    public CPF(String valor) {
        if (valor == null || valor.length() != 11) {
            throw new IllegalArgumentException("CPF inválido: deve ter 11 dígitos.");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof CPF) && ((CPF) obj).valor.equals(this.valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }

    @Override
    public String toString() {
        return valor;
    }

    public static void main(String[] args) {
        CPF cpf1 = new CPF("12345678901");
        CPF cpf2 = new CPF("12345678901");
        CPF cpf3 = new CPF("98765432109");

        System.out.println("CPF 1: " + cpf1);
        System.out.println("CPF 1 é igual a CPF 2? " + cpf1.equals(cpf2)); 
        System.out.println("CPF 1 é igual a CPF 3? " + cpf1.equals(cpf3)); 

        try {
            CPF cpfInvalido = new CPF("123"); 
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
