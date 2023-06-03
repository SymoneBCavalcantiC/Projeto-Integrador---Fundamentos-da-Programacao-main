package entidades;
public abstract class Conta {
    private int numeroConta;
    public double saldo;

    public Conta(int numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            System.out.println(">>> Saldo insuficiente!");
            return false;
        }
    }

    public void atualizarSaldo() {
    }

    public void calcularRendimentos(){

    }

    public void transferir(Conta origem, Conta destino, double valorTransf){

    }

}