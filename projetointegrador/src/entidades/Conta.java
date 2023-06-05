package entidades;
public abstract class Conta {
    //atributos da classe que serão herdados pelas classes filhas: Conta Corrente, Conta Poupança e Conta Investimento
    private int numeroConta;
    public double saldo;

    //método construtor da classe
    public Conta(int numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    //método construtor da classe
    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    //métodos getters e setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //método que realiza depósitos.
    //utilizados nas funcionalidades que apresentam comportamento típico de entrada de valores (creditar, depositar)
    //Herdado pelas classes filhas
    public void depositar(double valor) {
        saldo += valor;
    }


    //método que realiza saques.
    //utilizados nas funcionalidades que apresentam comportamento típico de saída de valores (debitar, sacar)
    //Herdado pelas classes filhas
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            System.out.println(">>> Saldo insuficiente!");
            return false;
        }
    }

    //método que efetua atualização de saldos
    //Herdado pelas filhas
    public void atualizarSaldo() {
    }


    //método que calcula rendimentos.
    //Herdado pelas filhas
    public void calcularRendimento(){

    }
}