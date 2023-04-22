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
        System.out.println("Bem-vindo ao EFS3Bank! Qual é o seu nome?");
        String nomeCliente = scanner.nextLine();
        System.out.println("Olá, " + nomeCliente + "!");
        System.out.println("Sua conta está pronta e é uma alegria para nós atendê-lo(a).");

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("MENU INICIAL");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Cartão de crédito");
            System.out.println("3. Investimento");
            System.out.println("3. Poupança");
            System.out.println("4. Sair");
            System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoConta = 0;
                    while (opcaoConta != 5) {
                        System.out.println("MENU: CONTA CORRENTE");
                        System.out.println("1. Depositar");
                        System.out.println("2. Sacar");
                        System.out.println("3. Consultar saldo");
                        System.out.println("4. Emitir extrato");
                        System.out.println("5. Voltar");
                        System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

                        opcaoConta = scanner.nextInt();

                        switch (opcaoConta) {
                            case 1:
                                System.out.println("Digite o valor a ser depositado:");
                                double valorDeposito = scanner.nextDouble();
                                cc.depositar(valorDeposito);
                                System.out.println("Depósito realizado com sucesso.");
                                break;
                            case 2:
                                System.out.println("Digite o valor a ser sacado:");
                                double valorSaque = scanner.nextDouble();
                                if (cc.sacar(valorSaque)) {
                                    System.out.println("Saque realizado com sucesso.");
                                } else {
                                    System.out.println("Saldo insuficiente.");
                                }
                                break;
                            case 3:
                                System.out.println("Saldo disponível: " + cc.getSaldo());
                                break;
                            case 4:
                                cc.emitirExtrato();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente");
                                break;
                        }
                    }
                    break;

                case 2:
                    int opcaoCartao = 0;
                    while (opcaoCartao != 5) {
                        System.out.println("MENU: CONTA CORRENTE");
                        System.out.println("1. Efetuar uma compra");
                        System.out.println("2. Listar histórico de compras");
                        System.out.println("3. Emitir a fatura mensal");
                        System.out.println("4. Pagar a fatura mensal");
                        System.out.println("5. Voltar");
                        System.out.println("Selecione a opção desejada, digitando o número correspondente: ");
                        opcaoCartao = scanner.nextInt();

                        switch (opcaoCartao) {
                            case 1:
                                System.out.print("Informe o dia da compra: ");
                                int dia = scanner.nextInt();
                                System.out.print("Informe o valor da compra: ");
                                double valor = scanner.nextDouble();
                                scanner.nextLine(); // Consumir o buffer do teclado
                                System.out.print("Informe a loja da compra: ");
                                String loja = scanner.nextLine();

                                cartao.efetuarCompra();
                                System.out.println("Compra efetuada com sucesso!");
                                break;
                            case 2:
                                cartao.listarCompras();
                                break;
                            case 3:
                                cartao.emitirFatura();
                                break;
                            case 4:
                                System.out.print("Informe o valor da fatura a ser paga: ");
                                double faturaMensal = scanner.nextDouble();
                                scanner.nextLine(); // Consumir o buffer do teclado

                                cartao.pagarFaturaMensal(faturaMensal);
                                break;
                            case 5:
                                System.out.println("Voltando ao Menu Principal...");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                                break;
                        }
                    }
                    break;
                case 3:
                    // Código para a classe Investimento
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();





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


    }
}