package entidades;

public class ContaPoupanca extends Conta {
    private double taxaDeRendimento;

    public ContaPoupanca(int numeroConta, double saldo, double taxaDeRendimento) {
        super(numeroConta, saldo);
        this.taxaDeRendimento = taxaDeRendimento;
    }

    public double getTaxaDeRendimento() {
        return taxaDeRendimento;
    }

    @Override
    public void atualizarSaldo() {
        double rendimento = getSaldo() * taxaDeRendimento;
        saldo += rendimento;
    }
}