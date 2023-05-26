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


    public static void consultarSaldoContaCorrente(int numeroConta, ContaCorrente cc1, ContaCorrente cc2) {
        if (cc1.getNumeroConta() == numeroConta) {
            cc1.atualizarSaldo();
            System.out.println(">>> Saldo disponível: R$ " + cc1.getSaldo());
        } else if (cc2.getNumeroConta() == numeroConta) {
            cc2.atualizarSaldo();
            System.out.println(">>> Saldo disponível: R$ " + cc2.getSaldo());
        } else {
            System.out.println(">>> Número de conta inválido.");
        }
    }


    public static void depositarContaCorrente(int numeroConta, double valor, ContaCorrente cc1, ContaCorrente cc2) {
        if (cc1.getNumeroConta() == numeroConta) {
            cc1.depositar(valor);
            System.out.println(">>> Depósito realizado com sucesso!");
        } else if (cc2.getNumeroConta() == numeroConta) {
            cc2.depositar(valor);
            System.out.println(">>> Depósito realizado com sucesso!");
        } else {
            System.out.println(">>> Número de conta inválido.");
        }
    }

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


    public void sacarDoLimite(double valor) {
        saldo -= valor;
    }
}