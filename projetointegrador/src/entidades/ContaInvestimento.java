package entidades;
import java.util.Scanner;

public class ContaInvestimento extends Conta {
    //atributos da classe e suas inicializações: taxas dos rendimentos das opções de investimento, saldos das opçoes de investimento, e saldo da conta Investimento
    private static final double TXRENT_LCI = 0.02;
    private static final double TXRENT_CDB = 0.05;
    private static final double TXRENT_RENDA_FIXA = 0.07;
    private static final double TXRENT_FUNDO_ACOES = 0.1;
    private static final double IR = 0.275;
    private static final double TXADM = 10;
    private static final double TXCORRETAGEM = 0.01;
    private static double saldoLCI = 0;
    private static double saldoCDB = 0;
    private static double saldoFundoRendaFixa = 0;
    private static double saldoFundoAcoes = 0;
    private static double saldoInvestimento = 0;


    //método construtor da classe
    public ContaInvestimento(int numeroConta) {
        super(numeroConta);
    }


    //método getter (setter não gerado por não ter uso no código)
    public double getSaldoInvestimento() {
        return saldoInvestimento;
    }


    //método que apresenta ao cliente as opções de investimento disponíveis no portfólio, com suas características.
    public static void listarOpcoesInvestimento() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("* LCI-Letras de Crédito Imobiliário");
        System.out.println("- Risco: Baixíssimo");
        System.out.println("- Rentabilidade mensal: 2% ao mês");
        System.out.println("- Não há cobrança de tarifas, imposto de renda, taxa de administração ou taxa de corretagem");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("* CDB-Certificado de Depósito Bancário");
        System.out.println("- Risco: Baixo");
        System.out.println("- Rentabilidade mensal: 5% ao mês");
        System.out.println("- Imposto de Renda: 27,5% sobre o rendimento mensal");
        System.out.println("- Não há cobrança de tarifas, taxa de administração ou taxa de corretagem");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("* Fundo de Renda Fixa Tradicional");
        System.out.println("- Risco: Médio");
        System.out.println("- Rentabilidade mensal: 7% ao mês");
        System.out.println("- Imposto de Renda: 27,5% sobre o rendimento mensal");
        System.out.println("- Taxa de Administração: R$ 10");
        System.out.println("- Há cobrança de tarifa. Não há cobrança de taxa de corretagem");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("* Fundo de Ações da Bolsa de Valores Brasileira");
        System.out.println("- Risco: Alto");
        System.out.println("- Rentabilidade mensal: 10% ao mês");
        System.out.println("- Imposto de Renda: 27,5% sobre o rendimento mensal");
        System.out.println("- Taxa de Administração: R$ 10");
        System.out.println("- Taxa de Corretagem: 1% sobre o valor aplicado");
        System.out.println("- Há cobrança de tarifa.");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    //método que apresenta os saldos atuais da carteira do cliente.
    public static void verificarSaldoInv() {
        System.out.println("- Saldo disponível na conta investimento: R$ " + saldoInvestimento);
        System.out.println("- Saldo da aplicação LCI: R$ " + saldoLCI);
        System.out.println("- Saldo da aplicação CDB: R$ " + saldoCDB);
        System.out.println("- Saldo da aplicação Fundo de Renda Fixa Tradicional: R$ " + saldoFundoRendaFixa);
        System.out.println("- Saldo da aplicação Fundo de Ações da Bolsa de Valores Brasileira: R$ " + saldoFundoAcoes);
    }

    //método para 'depositar' valores na conta investimento.
    public void depositar(double valor) {
        saldoInvestimento += valor;
    }

    //método para realizar aplicações financeiras, montando a carteira do cliente.
    public static void aplicarContaInvestimento() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("* Saldo disponível para investir: R$ " + saldoInvestimento);
        System.out.print("Digite o valor que deseja aplicar: ");
        double valorInvest = scanner.nextDouble();
        scanner.nextLine();

        if (valorInvest <= saldoInvestimento) {

            int opcaoAplicInv = 0;
            while (opcaoAplicInv != 5) {
                System.out.println("================================================================");
                System.out.println("Submenu Investimentos: APLICAR");
                System.out.println("1. Aplicar em LCI");
                System.out.println("2. Aplicar em CDB");
                System.out.println("3. Aplicar em Fundo de Renda Fixa Tradicional");
                System.out.println("4. Aplicar em Fundo de Ações da Bolsa Brasileira");
                System.out.println("5. Retornar ao 'Menu Investimentos'");
                System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

                opcaoAplicInv = scanner.nextInt();

                switch (opcaoAplicInv) {
                    case 1:
                        if (valorInvest <= saldoInvestimento){
                            saldoLCI += valorInvest;
                            saldoInvestimento -= valorInvest;
                            System.out.println(">>> Valor aplicado com sucesso.");
                        } else {
                            System.out.println(">>> Saldo insuficiente na conta investimento.");
                        }
                        break;
                    case 2:
                        if (valorInvest <= saldoInvestimento){
                            saldoCDB += valorInvest;
                            saldoInvestimento -= valorInvest;
                            System.out.println(">>> Valor aplicado com sucesso.");
                        } else {
                            System.out.println(">>> Saldo insuficiente na conta investimento.");
                        }
                        break;
                    case 3:
                        if (valorInvest <= saldoInvestimento){
                            saldoFundoRendaFixa += valorInvest;
                            saldoInvestimento -= valorInvest;
                            System.out.println(">>> Valor aplicado com sucesso.");
                        } else {
                            System.out.println(">>> Saldo insuficiente na conta investimento.");
                        }
                        break;
                    case 4:
                        if (valorInvest <= saldoInvestimento){
                            saldoFundoAcoes += valorInvest;
                            saldoInvestimento -= valorInvest;
                            System.out.println(">>> Valor aplicado com sucesso.");
                        } else {
                            System.out.println(">>> Saldo insuficiente na conta investimento.");
                        }
                        break;
                    case 5:
                        System.out.println(">>> Retornando ao MENU INVESTIMENTOS");
                        break;
                    default:
                        System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                        break;
                }
            }
        } else {
            System.out.println(">>> Saldo insuficiente na conta investimento.");
        }
    }

    //método para efetuar resgates da carteira do cliente.
    //o saldo resgatado é enviado para a conta corrente principal do cliente.
    public static void resgatarContaInvestimento(ContaCorrente contaCorrente) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("* Saldo dos investimentos disponíveis para resgate: ");
        System.out.println("- Saldo aplicado em LCI: R$ " + saldoLCI);
        System.out.println("- Saldo aplicado em CBD: R$ " + saldoCDB);
        System.out.println("- Saldo aplicado em Fundo de Renda Fixa Tradicional: R$ " + saldoFundoRendaFixa);
        System.out.println("- Saldo aplicado em Fundo de Ações da Bolsa Brasileira: R$ " + saldoFundoAcoes);
        System.out.println("---------------------------------------------------------------------------------");

        int opcaoResgInv = 0;
        while (opcaoResgInv != 5) {
            System.out.println("================================================================");
            System.out.println("Submenu Investimentos: RESGATAR");
            System.out.println("1. Resgatar LCI");
            System.out.println("2. Resgatar CDB");
            System.out.println("3. Resgatar Fundo de Renda Fixa Tradicional");
            System.out.println("4. Resgatar Fundo de Ações da Bolsa Brasileira");
            System.out.println("5. Retornar ao 'Menu Investimentos'");
            System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

            opcaoResgInv = scanner.nextInt();

            double valorResgatado = 0.0;

            switch (opcaoResgInv) {
                case 1:
                    valorResgatado = saldoLCI;
                    saldoLCI = 0.0;
                    break;
                case 2:
                    valorResgatado = saldoCDB;
                    saldoCDB = 0.0;
                    break;
                case 3:
                    valorResgatado = saldoFundoRendaFixa;
                    saldoFundoRendaFixa = 0.0;
                    break;
                case 4:
                    valorResgatado = saldoFundoAcoes;
                    saldoFundoAcoes = 0.0;
                    break;
                case 5:
                    System.out.println(">>> Retornando ao MENU INVESTIMENTOS");
                    break;

                default:
                    System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                    break;
                }

            saldoInvestimento += valorResgatado;
            System.out.println(">>> Aplicação resgatada com sucesso.");
            contaCorrente.depositar(valorResgatado);
            System.out.println(">>> Valor creditado em Conta Corrente.");
            }
    }


    //método para calcular os rendimentos financeiros e as cobranças de impostos, tarifas e taxas das opções de investimento
    @Override
    public void calcularRendimento() {
        if (saldoCDB > 0) {
            double rendimentoCDB = saldoCDB * TXRENT_CDB;
            double impRendaCDB = rendimentoCDB * IR;
            saldoCDB += rendimentoCDB - impRendaCDB;
        }

        if (saldoLCI > 0) {
            double rendimentoLCI = saldoLCI * TXRENT_LCI;
            saldoLCI += rendimentoLCI;
        }

        if (saldoFundoRendaFixa > 0) {
            double rendimentoFundoRendaFixa = saldoFundoRendaFixa * TXRENT_RENDA_FIXA;
            double impRendaFundoRendaFixa = rendimentoFundoRendaFixa * IR;
            saldoFundoRendaFixa += rendimentoFundoRendaFixa - TXADM - impRendaFundoRendaFixa;
        }

        if (saldoFundoAcoes > 0) {
            double rendimentoFundoAcoes = saldoFundoAcoes * TXRENT_FUNDO_ACOES;
            double taxaFundoAcoes = saldoFundoAcoes * TXCORRETAGEM;
            double impRendaFundoAcoes = rendimentoFundoAcoes * IR;
            saldoFundoAcoes += rendimentoFundoAcoes - taxaFundoAcoes - TXADM - impRendaFundoAcoes;
        }

        System.out.println(">>> Rendimento atualizado com sucesso!");
        System.out.println(">>> Saldo atual CDB: R$ " + saldoCDB);
        System.out.println(">>> Saldo atual LCI: R$ " + saldoLCI);
        System.out.println(">>> Saldo atual Fundo de Renda Fixa Tradicional: R$ " + saldoFundoRendaFixa);
        System.out.println(">>> Saldo atual Fundo de Ações da Bolsa Brasileira: R$ " + saldoFundoAcoes);
    }
}