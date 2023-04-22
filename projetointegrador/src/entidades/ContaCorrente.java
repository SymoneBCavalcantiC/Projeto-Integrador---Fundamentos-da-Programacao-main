package entidades;

public class ContaCorrente extends Conta {
    private double limite;
    private double taxaDeManutencao;

    public ContaCorrente(int numeroConta, double saldo, double limite, double taxaDeManutencao) {
        super(numeroConta, saldo);
        this.limite = limite;
        this.taxaDeManutencao = taxaDeManutencao;
    }

    public double getLimite() {
        return limite;
    }

    public double getTaxaDeManutencao() {
        return taxaDeManutencao;
    }

    @Override
    public void atualizarSaldo() {
        if (getSaldo() < 0) {
            double juros = getSaldo() * 0.005; // taxa de juros de 0,5% ao dia
            saldo += juros;
        } else {
            double rendimento = getSaldo() * 0.01; // rendimento de 1% ao mês
            saldo += rendimento;
        }
        saldo -= taxaDeManutencao;
    }
}