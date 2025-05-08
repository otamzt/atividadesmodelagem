import java.math.BigDecimal;

public class FolhaPagamentoFactory {

    public FolhaPagamento gerarFolha(Funcionario funcionario, int horasTrabalhadas, int horasExtras) {
        BigDecimal salarioBaseMensal = funcionario.getSalarioBase();
        BigDecimal valorHoraNormal = salarioBaseMensal.divide(BigDecimal.valueOf(176), java.math.RoundingMode.HALF_UP);
        BigDecimal salarioHorasNormais = valorHoraNormal.multiply(BigDecimal.valueOf(horasTrabalhadas));
        BigDecimal salarioHorasExtras = funcionario.getValorHoraExtra().multiply(BigDecimal.valueOf(horasExtras));
        BigDecimal salarioBruto = salarioHorasNormais.add(salarioHorasExtras);

        BigDecimal valorImposto = salarioBruto.multiply(BigDecimal.valueOf(funcionario.getTaxaImposto()));
        BigDecimal salarioLiquido = salarioBruto.subtract(valorImposto);

        return new FolhaPagamento(funcionario, horasTrabalhadas, horasExtras, salarioBruto, valorImposto, salarioLiquido);
    }
}
