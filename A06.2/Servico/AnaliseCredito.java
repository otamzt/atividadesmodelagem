public class AnaliseCredito {

    public boolean concederEmprestimo(Cliente cliente, double valorEmprestimo) {

        boolean bomHistorico = cliente.getHistoricoCompras().stream()
                .noneMatch(compra -> compra.isInadimplente()); 

        double proporcaoDividaSalario = cliente.getDividasAtivas() / cliente.getSalario();
        boolean dividaBaixa = proporcaoDividaSalario < 0.3; 

        double parcelaMensalEstimada = valorEmprestimo / 12; 
        boolean salarioSuficiente = cliente.getSalario() > parcelaMensalEstimada * 1.5; 

        return bomHistorico && dividaBaixa && salarioSuficiente;
    }
}
