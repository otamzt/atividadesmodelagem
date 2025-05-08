public record CPFRecord(String valor) {
    public CPFRecord {
        if (valor == null || valor.length() != 11) {
            throw new IllegalArgumentException("CPF inválido: deve ter 11 dígitos.");
        }
    }

    public static void main(String[] args) {
        CPFRecord cpf1 = new CPFRecord("12345678901");
        CPFRecord cpf2 = new CPFRecord("12345678901");
        CPFRecord cpf3 = new CPFRecord("98765432109");

        System.out.println("CPF 1: " + cpf1);
        System.out.println("CPF 1 é igual a CPF 2? " + cpf1.equals(cpf2)); // true
        System.out.println("CPF 1 é igual a CPF 3? " + cpf1.equals(cpf3)); // false

        try {
            CPFRecord cpfInvalido = new CPFRecord("123"); // Lançará IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
