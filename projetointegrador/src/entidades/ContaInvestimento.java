package entidades;
import java.util.Scanner;

public class ContaInvestimento extends Conta {
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


    public ContaInvestimento(int numeroConta) {
        super(numeroConta);
    }


    public double getSaldoInvestimento() {
        return saldoInvestimento;
    }


    public static void listarOpcoesInvestimento() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("* LCI-Letras de Crédito Imobiliário");
        System.out.println("- Risco: Baixíssimo");
        System.out.println("- Rentabilidade mensal: 2% ao mês");
        System.out.println("- Não há tarifas, imposto de renda, taxa de administração ou taxa de corretagem");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("* CDB-Certificado de Depósito Bancário");
        System.out.println("- Risco: Baixo");
        System.out.println("- Rentabilidade mensal: 5% ao mês");
        System.out.println("- Imposto de Renda: 27,5% sobre o rendimento mensal");
        System.out.println("- Não há tarifas, taxa de administração ou taxa de corretagem");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("* Fundo de Renda Fixa Tradicional");
        System.out.println("- Risco: Médio");
        System.out.println("- Rentabilidade mensal: 7% ao mês");
        System.out.println("- Imposto de Renda: 27,5% sobre o rendimento mensal");
        System.out.println("- Taxa de Administração: R$ 10");
        System.out.println("- Não há tarifas ou taxa de corretagem");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("* Fundo de Ações da Bolsa de Valores Brasileira");
        System.out.println("- Risco: Alto");
        System.out.println("- Rentabilidade mensal: 10% ao mês");
        System.out.println("- Imposto de Renda: 27,5% sobre o rendimento mensal");
        System.out.println("- Taxa de Administração: R$ 10");
        System.out.println("- Taxa de Corretagem: 1% sobre o valor aplicado");
        System.out.println("- Não há tarifas");
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void verificarSaldoInv() {
        System.out.println("Saldo disponível na conta investimento: " + saldoInvestimento);
        System.out.println("Saldo da aplicação LCI: " + saldoLCI);
        System.out.println("Saldo da aplicação CDB: " + saldoCDB);
        System.out.println("Saldo da aplicação Fundo de Renda Fixa Tradicional: " + saldoFundoRendaFixa);
        System.out.println("Saldo da aplicação Fundo de Ações da Bolsa de Valores Brasileira: " + saldoFundoAcoes);
    }

    public static void aplicarContaInvestimento() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saldo disponível para investir: " + saldoInvestimento);
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
                        saldoLCI += valorInvest;
                        break;
                    case 2:
                        saldoCDB += valorInvest;
                        break;
                    case 3:
                        saldoFundoRendaFixa += valorInvest;
                        break;
                    case 4:
                        saldoFundoAcoes += valorInvest;
                        break;
                    case 5:
                        System.out.println(">>> Retornando ao MENU INVESTIMENTOS");
                        break;
                    default:
                        System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                        break;
                }
            }

            saldoInvestimento -= valorInvest;
            System.out.println("Valor aplicado com sucesso.");

        } else {
            System.out.println("Saldo insuficiente na conta investimento.");
        }
    } //Fim do método para Realizar Aplicações na carteira do cliente



    //inserir os demais métodos a partir daqui...


    @Override
    public void atualizarSaldo() {
        double rendimentoInvestimento = getSaldoInvestimento() * taxaDeRetorno / 12; // taxa de retorno anual dividido por 12 meses
        saldoInvestimento += rendimentoInvestimento;
    }


    @Override
    public void transferir(Conta origem, Conta destino, double valorTransf) {

    }


}