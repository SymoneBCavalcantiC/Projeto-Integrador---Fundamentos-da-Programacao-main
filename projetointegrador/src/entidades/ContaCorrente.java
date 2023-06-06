package entidades;
import java.util.Scanner;

public class ContaCorrente extends Conta {
    private final double limite;
    private final double taxaDeManutencao;

    //método construtor da classe
    public ContaCorrente(int numeroConta, double saldo, double limite, double taxaDeManutencao) {
        super(numeroConta, saldo);
        this.limite = limite;
        this.taxaDeManutencao = taxaDeManutencao;
    }

    //método getter (setter não gerado por não ter uso no código)
    public double getLimite() {
        return limite;
    }

    public double getTaxaDeManutencao() {
        return taxaDeManutencao;
    }


    // Método que atualiza os saldos. Utilizado nas funcionalidades conta corrente e poupança.
    //polimorfismo sobreposição
    //método herdado da classe abstrata Conta
    @Override
    public void atualizarSaldo() {
        if (getSaldo() < 0) {
            double juros = -(getSaldo()) * 0.1; // taxa de juros de 10% ao mês
            saldo -= juros;
            System.out.println(">>> Houve juros de R$ " + juros);
        } else {
            double rendimento = getSaldo() * 0.05; // rendimento de 5% ao mês
            saldo += rendimento;
            System.out.println(">>> Houve rendimento de R$ " + rendimento);
        }
        saldo -= taxaDeManutencao; //cobrança da taxa de manutenção da conta corrente

    }

    // Método que atualiza os saldos nas funcionalidades da conta corrente
    static Scanner scanner = new Scanner(System.in);
    public static void consultarSaldoContaCorrente(int numeroConta, ContaCorrente cc1, ContaCorrente cc2) {
        System.out.println("Hoje é qual DIA do mês? ");
        int diaDoMes = scanner.nextInt();

        if (diaDoMes == 1) {
            if (cc1.getNumeroConta() == numeroConta) {
                cc1.atualizarSaldo();
                System.out.println(">>> Obrigado por pagar a taxa de manutenção de conta! R$ " + cc1.getTaxaDeManutencao());
                System.out.println(">>> Saldo atual: R$ " + cc1.getSaldo());
            } else if (cc2.getNumeroConta() == numeroConta) {
                cc2.atualizarSaldo();
                System.out.println(">>> Obrigado por pagar a taxa de manutenção de conta! R$ " + cc2.getTaxaDeManutencao());
                System.out.println(">>> Saldo atual: R$ " + cc2.getSaldo());
            } else {
                System.out.println(">>> Número de conta inválido.");
            }
        } else {
            if (cc1.getNumeroConta() == numeroConta) {
                System.out.println(">>> Saldo atual: R$ " + cc1.getSaldo());
                System.out.println(">>> Limite da Conta Corrente: R$ " + cc1.getLimite());
            } else if (cc2.getNumeroConta() == numeroConta) {
                System.out.println(">>> Saldo atual: R$ " + cc2.getSaldo());
                System.out.println(">>> Limite da Conta Corrente: R$ " + cc1.getLimite());
            } else {
                System.out.println(">>> Número de conta inválido.");
            }
        }
    }

    // Método que deposita valores na funcionalidade conta corrente
    public static void depositarContaCorrente(int numeroConta, double valor, ContaCorrente cc1, ContaCorrente cc2) {
        if (cc1.getNumeroConta() == numeroConta) {
            cc1.depositar(valor);
            System.out.println(">>> Depósito realizado com sucesso!");
            System.out.println(">>> Saldo atual: R$ " + cc1.getSaldo());
        } else if (cc2.getNumeroConta() == numeroConta) {
            cc2.depositar(valor);
            System.out.println(">>> Depósito realizado com sucesso!");
            System.out.println(">>> Saldo atual: R$ " + cc2.getSaldo());
        } else {
            System.out.println(">>> Conta Corrente não localizada! Digite um número de conta válido!");
        }
    }

    //método que realiza saques. Utilizado nas funcionalidades que apresentam esse comportamento típico de 'debitar'
    //polimorfismo sobreposição
    //método herdado da classe abstrata Conta
    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println(">>> Saque realizado com sucesso! R$ " + valor);
            System.out.println(">>> Saldo atual: R$ " + saldo);
            System.out.println(">>> Limite da conta: R$ " + limite);
            System.out.println(">>> Saldo disponível para saque: R$ " + (saldo + limite));
        } else if (valor <= saldo + limite) {
            double limiteDisponivel = saldo + limite;
            saldo = valor - limiteDisponivel;
            System.out.println(">>> Saque realizado com sucesso! R$ " + valor);
            System.out.println(">>> Saldo disponível para saque: R$ " + limiteDisponivel);

        } else {
            System.out.println(">>> Saldo insuficiente!");
            System.out.println(">>> O valor máximo que pode ser sacado é: R$ " + saldo );
            System.out.println(">>> Saldo atual: R$ " + saldo + " | Limite atual: R$ " + limite);
            System.out.println("Saldo disponível para saque: R$ " + (saldo + limite));
        }
        return false;
    }

    //método que realiza saques.
    public static void sacarContaCorrente(int numeroConta, double valor, ContaCorrente cc1, ContaCorrente cc2) {
        if (cc1.getNumeroConta() == numeroConta) {
            if (cc1.sacar(valor)) {
                System.out.println(">>> Saque realizado com sucesso!");
            }
        } else if (cc2.getNumeroConta() == numeroConta) {
            if (cc2.sacar(valor)) {
                System.out.println(">>> Saque realizado com sucesso!");
            }
        } else {
            System.out.println(">>> Número de conta inválido.");
        }
    }

    //os próximos 3 métodos são para realizar transferências: entre contas correntes, para poupança, e para conta investimento
    //polimorfismo sobrecarga (alterada a assinatura)
    public static void transferir(ContaCorrente contaOrigem, ContaCorrente contaDestino, double valorTransf) {
        if (valorTransf <= contaOrigem.getSaldo() + contaOrigem.getLimite()) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTransf);
            contaDestino.depositar(valorTransf);
            System.out.println(">>> Transferência realizada com sucesso!");
            System.out.println(">>> Saldo atual da conta origem: R$ " + contaOrigem.getSaldo());
        } else {
            System.out.println(">>> Saldo insuficiente.");
            System.out.println(">>> Saldo atual da conta origem: R$ " + contaOrigem.getSaldo());
        }
    }

    public static void transferir(ContaCorrente contaOrigem, ContaPoupanca contaDestino, double valorTransf) {
        if (valorTransf <= contaOrigem.getSaldo() + contaOrigem.getLimite()) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTransf);
            contaDestino.depositar(valorTransf);
            System.out.println(">>> Transferência realizada com sucesso!");
            System.out.println(">>> Saldo atual da conta origem: R$ " + contaOrigem.getSaldo());
        } else {
            System.out.println(">>> Saldo insuficiente.");
            System.out.println(">>> Saldo atual da conta origem: R$ " + contaOrigem.getSaldo());
        }
    }

    public static void transferir(ContaCorrente contaOrigem, ContaInvestimento contaDestino, double valorTransf) {
        if (valorTransf <= contaOrigem.getSaldo() + contaOrigem.getLimite()) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTransf);
            contaDestino.depositar(valorTransf);
            System.out.println(">>> Transferência realizada com sucesso!");
            System.out.println(">>> Saldo atual da conta origem: R$ " + contaOrigem.getSaldo());
        } else {
            System.out.println(">>> Saldo insuficiente.");
            System.out.println(">>> Saldo atual da conta origem: R$ " + contaOrigem.getSaldo());
        }
    }

    //método usado na classe Cartão de cŕedito, que permite pagar a fatura mensal com recursos da conta corrente.
    public void debitarDoLimite(double valor) {
        saldo -= valor;
    }
}