import entidades.ContaCorrente;
import entidades.ContaInvestimento;
import entidades.ContaPoupanca;
import entidades.CartaoCredito;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(123, 1000, 500, 20);
        ContaPoupanca cp = new ContaPoupanca(456, 2000, 0.01);
        ContaInvestimento ci = new ContaInvestimento(789, 5000, 0.08);
        CartaoCredito cartao = new CartaoCredito(10000);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao EFS3Bank!");
        System.out.println("Qual é o seu nome?");
        String nomeCliente = scanner.nextLine();
        System.out.println("Olá, " + nomeCliente + "!");
        System.out.println("Sua conta está pronta e é uma alegria para nós atendê-lo(a).");

        int opcao = 0;
        while (opcao != 6) {
            System.out.println("===============================================================");
            System.out.println("MENU INICIAL");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Cartão de crédito");
            System.out.println("3. Investimentos");
            System.out.println("4. Poupança");
            System.out.println("5. Transferências");
            System.out.println("6. Sair");
            System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoConta = 0;
                    while (opcaoConta != 4) {
                        System.out.println("================================================================");
                        System.out.println("MENU: CONTA CORRENTE");
                        System.out.println("1. Depositar");
                        System.out.println("2. Sacar");
                        System.out.println("3. Consultar saldo");
                        System.out.println("4. Retornar ao Menu Inicial");
                        System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

                        opcaoConta = scanner.nextInt();

                        switch (opcaoConta) {
                            case 1:
                                System.out.println("Digite o valor a ser depositado: R$ ");
                                double valorDeposito = scanner.nextDouble();
                                cc.depositar(valorDeposito);
                                System.out.println("Depósito realizado com sucesso!");
                                break;
                            case 2:
                                System.out.println("Digite o valor a ser sacado: R$ ");
                                double valorSaque = scanner.nextDouble();
                                if (cc.sacar(valorSaque)) {
                                    System.out.println("Saque realizado com sucesso!");
                                } else {
                                    System.out.println("Saldo insuficiente.");
                                }
                                break;
                            case 3:
                                System.out.println("Saldo disponível R$: " + cc.getSaldo());
                                break;
                            case 4:
                                System.out.println("Retornando ao Menu Inicial");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente");
                                break;
                        }
                    }
                    break;

                case 2:
                    int opcaoCartao = 0;
                    while (opcaoCartao != 4) {
                        System.out.println("================================================================");
                        System.out.println("MENU: CARTÃO DE CRÉDITO");
                        System.out.println("1. Efetuar uma compra");
                        System.out.println("2. Listar histórico de compras");
                        System.out.println("3. Emitir a fatura mensal");
                        System.out.println("4. Retornar ao Menu Inicial");
                        System.out.println("Selecione a opção desejada, digitando o número correspondente: ");
                        opcaoCartao = scanner.nextInt();

                        switch (opcaoCartao) {
                            case 1:
                                cartao.efetuarCompra();
                                break;
                            case 2:
                                cartao.listarCompras();
                                break;
                            case 3:
                                cartao.emitirFatura();
                                break;
                            case 4:
                                System.out.println("Retornando ao Menu Inicial");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                                break;
                        }
                    }
                    break;
                case 3:
                    // Código para a classe Investimento
                    System.out.println("MENU: INVESTIMENTOS");
                    System.out.println("Em desenvolvimento");
                    System.out.println("Retornando ao Menu Inicial.");
                    break;
                case 4:
                    //Código para a classe Poupança
                    System.out.println("MENU: POUPANÇA");
                    System.out.println("Em desenvolvimento");
                    System.out.println("Retornando ao Menu Inicial.");
                    break;
                case 5:
                    //Código para a classe Transferência
                    System.out.println("MENU: TRANSFERÊNCIAS");
                    System.out.println("Em desenvolvimento");
                    System.out.println("Retornando ao Menu Inicial.");
                    break;
                case 6:
                    System.out.println("================================================================");
                    System.out.println("O EFS3Bank agradece a sua visita, " + nomeCliente + "!");
                    System.out.println(" Até breve!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();

        /*
        cc.atualizarSaldo();
        cp.atualizarSaldo();
        ci.atualizarSaldo();

        System.out.println("Saldo da conta corrente: " + cc.getSaldo());
        System.out.println("Saldo da conta poupança: " + cp.getSaldo());
        System.out.println("Saldo da conta de investimento: " + ci.getSaldo());

        cc.depositar(500);
        cp.sacar(1000);
        ci.sacar(6000);

        System.out.println("Saldo da conta corrente após depósito: " + cc.getSaldo());
        System.out.println("Saldo da conta poupança após saque: " + cp.getSaldo());
        System.out.println("Saldo da conta de investimento após saque: " + ci.getSaldo());

        cc.atualizarSaldo();
        cp.atualizarSaldo();
        ci.atualizarSaldo();

        System.out.println("Saldo da conta corrente após atualização: " + cc.getSaldo());
        System.out.println("Saldo da conta poupança após atualização: " + cp.getSaldo());
        System.out.println("Saldo da conta de investimento após atualização: " + ci.getSaldo());
        */


    }
}