import entidades.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente(123, 1000, 500, 20);
        ContaCorrente cc2 = new ContaCorrente(321, 2000, 500, 20);
        ContaPoupanca cp1 = new ContaPoupanca(456);
        ContaPoupanca cp2 = new ContaPoupanca(654);
        ContaInvestimento ci = new ContaInvestimento(789);
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
                    //Código para a funcionalidade Conta Corrente
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
                                System.out.println("Digite o número da conta corrente: ");
                                int numContaDeposito = scanner.nextInt();
                                ContaCorrente.depositarContaCorrente(numContaDeposito, valorDeposito, cc1, cc2);
                                break;
                            case 2:
                                System.out.println("Digite o valor a ser sacado: R$ ");
                                double valorSaque = scanner.nextDouble();
                                System.out.println("Digite o número da conta corrente: ");
                                int numContaSaque = scanner.nextInt();
                                ContaCorrente.sacarContaCorrente(numContaSaque, valorSaque, cc1, cc2);
                                break;
                            case 3:
                                System.out.println("Digite o número da conta corrente: ");
                                int numContaSaldo = scanner.nextInt();
                                ContaCorrente.consultarSaldoContaCorrente(numContaSaldo, cc1, cc2);
                                break;
                            case 4:
                                System.out.println(">>> Retornando ao Menu Inicial");
                                break;
                            default:
                                System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                                break;
                        }
                    }
                    break;

                case 2:
                    //Código para a funcionalidade Cartão de crédito
                    int opcaoCartao = 0;
                    while (opcaoCartao != 5) {
                        System.out.println("================================================================");
                        System.out.println("MENU: CARTÃO DE CRÉDITO");
                        System.out.println("1. Efetuar COMPRA");
                        System.out.println("2. Listar HISTÓRICO DE COMPRAS");
                        System.out.println("3. Emitir FATURA MENSAL");
                        System.out.println("4. PAGAR FATURA mensal");
                        System.out.println("5. Retornar ao Menu Inicial");
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
                                cartao.debitarFatura(cc1, cc2);
                                break;
                            case 5:
                                System.out.println(">>> Retornando ao Menu Inicial");
                                break;
                            default:
                                System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                                break;
                        }
                    }
                    break;

                case 3:
                    // Código para a funcionalidade Investimentos
                    int opcaoInvest = 0;
                    while (opcaoInvest != 6) {
                        System.out.println("================================================================");
                        System.out.println("MENU: INVESTIMENTOS");
                        System.out.println("1. Listar OPÇÕES DE INVESTIMENTO do portfólio");
                        System.out.println("2. Verificar SALDO DISPONÍVEL da carteira");
                        System.out.println("3. Efetuar APLICAÇÃO");
                        System.out.println("4. Efetuar RESGATE");
                        System.out.println("5. Atualizar RENTABILIDADE MENSAL da carteira");
                        System.out.println("6. Retornar ao Menu Inicial");
                        System.out.println("Selecione a opção desejada, digitando o número correspondente: ");
                        System.out.println("----------------------------------------------------------------");
                        opcaoInvest = scanner.nextInt();

                        switch (opcaoInvest) {
                            case 1://Lista as opções de investimento disponíveis no portfólio
                                ContaInvestimento.listarOpcoesInvestimento();
                                break;

                            case 2://Verifica o saldo disponível na conta investimento e na carteira da conta
                                ContaInvestimento.verificarSaldoInv();
                                break;

                            case 3://Apresenta menu com as opções de investimento para cliente decidir em qual aplicar
                                ContaInvestimento.aplicarContaInvestimento();
                                break;

                            case 4: //Apresenta menu com as opções de investimento para cliente decidir de qual resgatar
                                ContaInvestimento.resgatarContaInvestimento();
                                break;

                            case 5: //Efetua atualização da rentabilidade mensal da carteira

                                break; //Fim da opção "Atualizar Rentabilidade mensal", dentro do 'Menu Investimentos'

                            case 6:
                                System.out.println(">>> Retornando ao Menu Inicial");
                                break;

                            default:
                                System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                                break;
                        }
                    }
                    break; //Fim do 'Menu Investimentos'


                case 4:
                    //Código para a classe Poupança
                    int opcaoPoup = 0;
                    while (opcaoPoup != 5) {
                        System.out.println("================================================================");
                        System.out.println("MENU: POUPANÇA");
                        System.out.println("1. APLICAR em Poupança");
                        System.out.println("2. RESGATAR da poupança");
                        System.out.println("3. Consultar SALDO DISPONÍVEL");
                        System.out.println("4. Atualizar RENDIMENTO MENSAL: juros e correção monetária");
                        System.out.println("5. Retornar ao Menu Inicial");

                        opcaoPoup = scanner.nextInt();

                        switch (opcaoPoup) {
                            case 1:
                                System.out.println("Digite o valor da aplicação: R$ ");
                                double valorAplicacaoPoup = scanner.nextDouble();
                                System.out.println("Digite o número da Conta Poupança: ");
                                int numContaPoupanca = scanner.nextInt();
                                ContaPoupanca.aplicarContaPoupanca(numContaPoupanca, valorAplicacaoPoup, cp1, cp2);
                                break;

                            case 2:
                                System.out.println("Digite o valor do resgate: R$ ");
                                double valorResgatePoup = scanner.nextDouble();
                                System.out.println("Digite o número da Conta Poupança: ");
                                int numCtPoupanca = scanner.nextInt();
                                ContaPoupanca.resgatarContaPoupanca(numCtPoupanca, valorResgatePoup, cp1, cp2);
                                break;

                            case 3:
                                System.out.println("Digite o número da Conta Poupança desejada: ");
                                int numPoupanca = scanner.nextInt();
                                ContaPoupanca.consultarSaldoPoupanca(numPoupanca, cp1, cp2);
                                break;

                            case 4:
                                System.out.println("Digite o número da conta corrente: ");
                                int numCtaPoup = scanner.nextInt();
                                ContaPoupanca.atualizarRendimento(numCtaPoup, cp1, cp2);
                                break;

                            case 5:
                                System.out.println(">>> Retornando ao Menu Inicial");
                                break;

                            default:
                                System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                                break;

                        }
                    }
                    break;

                case 5:
                    //Código para a funcionalidade Transferência
                    int opcaoTransf = 0;
                    while (opcaoTransf != 3) {
                        System.out.println("================================================================");
                        System.out.println("MENU: TRANSFERÊNCIAS");
                        System.out.println("1. Realizar TRANSFERÊNCIA ENTRE CONTAS");
                        System.out.println("2. Realizar TRANSFERÊNCIA para CONTA INVESTIMENTO");
                        System.out.println("3. Retornar ao Menu Inicial");
                        System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

                        opcaoTransf = scanner.nextInt();

                        switch (opcaoTransf) {
                            case 1:
                                Transferencia.transferir(scanner, cc1, cc2, cp1, cp2);
                                break;

                            case 2:
                                System.out.println(">>> Transferência para Conta Investimento");
                                break;

                            case 3:
                                System.out.println(">>> Retornando ao Menu Inicial");
                                break;

                            default:
                                System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                                break;
                        }
                    }
                    break;

                case 6:
                    //Código para encerrar o programa
                    System.out.println("================================================================");
                    System.out.println("O EFS3Bank agradece a sua visita, " + nomeCliente + "!");
                    System.out.println("Até breve! ;)");
                    break;

                default:
                    System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                    break;

            }
           }

        scanner.close();

        /*cc.atualizarSaldo();
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
        System.out.println("Saldo da conta de investimento após atualização: " + ci.getSaldo());*/


    }
}