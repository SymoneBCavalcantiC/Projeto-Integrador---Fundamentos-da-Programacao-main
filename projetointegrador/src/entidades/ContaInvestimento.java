package entidades;

public class ContaInvestimento extends Conta {
    private final double taxaDeRetorno;

    private final double impostoRenda = 0.275;
    private final double taxaAdm = 0.0005;
    private final double txCorretagem = 0.0001;
    private double saldoInvestimento;

    public ContaInvestimento(int numeroConta, double taxaDeRetorno) {
        super(numeroConta);
        this.taxaDeRetorno = taxaDeRetorno;
        this.saldoInvestimento = 0;
    }

    public double getSaldoInvestimento() {
        return saldoInvestimento;
    }

    public void setSaldoInvestimento(double saldoInvestimento) {
        this.saldoInvestimento = saldoInvestimento;
    }

    public double getTaxaDeRetorno() {
        return taxaDeRetorno;
    }

    @Override
    public void atualizarSaldo() {
        double rendimentoInvestimento = getSaldoInvestimento() * taxaDeRetorno / 12; // taxa de retorno anual dividido por 12 meses
        saldo += rendimentoInvestimento;
    }
}