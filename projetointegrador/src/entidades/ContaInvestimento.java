package entidades;

public class ContaInvestimento extends Conta {
    private double taxaDeRetorno;

    public ContaInvestimento(int numeroConta, double saldo, double taxaDeRetorno) {
        super(numeroConta, saldo);
        this.taxaDeRetorno = taxaDeRetorno;
    }

    public double getTaxaDeRetorno() {

        return taxaDeRetorno;
    }

    /*@Override
    public void atualizarSaldo() {
        double rendimento = getSaldo() * taxaDeRetorno / 12; // taxa de retorno anual dividido por 12 meses
        saldo += rendimento;
    }*/
}