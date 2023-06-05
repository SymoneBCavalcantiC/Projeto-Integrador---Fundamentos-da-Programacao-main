package entidades;
import java.util.Scanner;

public class ContaPoupanca extends Conta {
    //atributos da classe: saldo da poupança e os índices de remuneração.
    private final double taxaDeRendimento;
    private final double taxaReferencial;
    private double saldoPoupanca;

    //método construtor da classe, contendo as inicializações.
    public ContaPoupanca(int numeroConta) {
        super(numeroConta);
        this.taxaDeRendimento = 0.02;
        this.taxaReferencial = 0.001;
        this.saldoPoupanca = 0;
    }

    //métodos getters e setters
    public double getSaldoPoupanca() {
        return saldoPoupanca;
    }

    public void setSaldoPoupanca(double saldoPoupanca) {
        this.saldoPoupanca = saldoPoupanca;
    }


    //método para depositar valores nas contas poupanças
    //Herdado da classe abstrata Conta (mãe)
    @Override
    public void depositar(double valor) {
        this.saldoPoupanca += valor;
    }

    //método que efetua depósito nas contas poupanças (aplicação).
    public static void aplicarContaPoupanca(int numeroConta, double valor, ContaPoupanca cp1, ContaPoupanca cp2) {
        if (cp1.getNumeroConta() == numeroConta) {
            cp1.depositar(valor);
            System.out.println(">>> Aplicação realizada com sucesso!");
            System.out.println(">>> Saldo atual: R$ " + cp1.getSaldoPoupanca());
        } else if (cp2.getNumeroConta() == numeroConta) {
            cp2.depositar(valor);
            System.out.println(">>> Aplicação realizada com sucesso!");
            System.out.println(">>> Saldo atual: R$ " + cp2.getSaldoPoupanca());
        } else {
            System.out.println(">>> Conta Poupança não localizada! Digite um número de poupança válido.");
        }
    }

    //método para sacar valores das contas poupanças
    //Herdado da classe abstrata Conta (mãe)
    @Override
    public boolean sacar(double valor) {
        if (valor <= this.saldoPoupanca) {
            this.saldoPoupanca -= valor;
            return true;
        } else {
            return false;
        }
    }

    //método que efetua saques das contas poupanças (resgates).
    public static void resgatarContaPoupanca(int numeroConta, double valor, ContaPoupanca cp1, ContaPoupanca cp2) {
        if (cp1.getNumeroConta() == numeroConta) {
            cp1.sacar(valor);
            System.out.println(">>> Resgate efetuado com sucesso!");
            System.out.println(">>> Saldo atual: R$ " + cp1.getSaldoPoupanca());
        } else if (cp2.getNumeroConta() == numeroConta) {
            cp2.sacar(valor);
            System.out.println(">>> Resgate efetuado com sucesso!");
            System.out.println(">>> Saldo atual: R$ " + cp2.getSaldoPoupanca());
        } else {
            System.out.println(">>> Conta Poupança não localizada!");
        }
    }

    //método que permite ao cliente consultar seus saldos das contas poupanças
    public static void consultarSaldoPoupanca(int numeroConta, ContaPoupanca cp1, ContaPoupanca cp2) {
        if (cp1.getNumeroConta() == numeroConta) {
            System.out.println(">>> Saldo atual da Poupança n. " + cp1.getNumeroConta() + " é: R$ " + cp1.getSaldoPoupanca());
        } else if (cp2.getNumeroConta() == numeroConta) {
            System.out.println(">>> Saldo atual da Poupança n. " + cp2.getNumeroConta() + " é: R$ " + cp2.getSaldoPoupanca());
        } else {
            System.out.println(">>> Conta Poupança não localizada!");
        }
    }

    //método que realiza as atualizações do saldo, gerando os rendimentos de juros e correção monetária
    @Override
    public void atualizarSaldo() {
        double jurosPoupanca = getSaldoPoupanca() * taxaDeRendimento;
        double correcaoMonetaria = getSaldoPoupanca() * taxaReferencial;
        double rendimentoPoupanca = jurosPoupanca + correcaoMonetaria;
        this.saldoPoupanca += rendimentoPoupanca;
        System.out.println(">>> O rendimento mensal foi de: R$ " + rendimentoPoupanca);
        System.out.println(">>> Juros: R$ " + jurosPoupanca + " ||  Correção Monetária: R$ " + correcaoMonetaria );
    }

    //método que efetua a atualização uma vez ao mês (no dia 1)
    static Scanner scanner = new Scanner(System.in);

    public static void atualizarRendimento(int numeroConta, ContaPoupanca cp1, ContaPoupanca cp2) {
        System.out.println("Hoje é que DIA do mês? ");
        int diaMes = scanner.nextInt();

        if (diaMes == 1) {

            if (cp1.getNumeroConta() == numeroConta) {
                cp1.atualizarSaldo();
                System.out.println(">>> Saldo disponível: R$ " + cp1.getSaldoPoupanca());

            } else if (cp2.getNumeroConta() == numeroConta) {
                cp2.atualizarSaldo();
                System.out.println(">>> Saldo disponível: R$ " + cp2.getSaldoPoupanca());

            } else {
                System.out.println(">>> Conta Poupança não localizada!");
            }
        } else {
            System.out.println(">>> Não é dia da Poupança obter rendimentos.");
        }
    }
}