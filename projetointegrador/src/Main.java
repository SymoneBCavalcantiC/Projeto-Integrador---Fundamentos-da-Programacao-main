import entidades.*;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente(123, 1000, 500, 20);
        ContaCorrente cc2 = new ContaCorrente(321, 2000, 500, 20);
        ContaPoupanca cp1 = new ContaPoupanca(456, 1500, 0.01);
        ContaPoupanca cp2 = new ContaPoupanca(654, 2500, 0.01);
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
                                cc1.depositar(valorDeposito);
                                System.out.println("Depósito realizado com sucesso!");
                                break;
                            case 2:
                                System.out.println("Digite o valor a ser sacado: R$ ");
                                double valorSaque = scanner.nextDouble();
                                if (cc1.sacar(valorSaque)) {
                                    System.out.println("Saque realizado com sucesso!");
                                } else {
                                    System.out.println("Saldo insuficiente.");
                                }
                                break;
                            case 3:
                                System.out.println("Saldo disponível R$: " + cc1.getSaldo());
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
                                System.out.println(">>> Retornando ao Menu Inicial");
                                break;
                            default:
                                System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
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
                    int opcaoTransf = 0;
                    while (opcaoTransf != 3) {
                        System.out.println("================================================================");
                        System.out.println("MENU: TRANSFERÊNCIAS");
                        System.out.println("1. Efetuar transferência");
                        System.out.println("2. Retornar ao Menu Inicial");
                        System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

                        opcaoTransf = scanner.nextInt();

                        switch (opcaoTransf) {
                            case 1:
                                int opcaoTransferir = 0;
                                while (opcaoTransferir != 5) {
                                    System.out.println("================================================================");
                                    System.out.println("SUBMENU: Efetuar transferência");
                                    System.out.println("1. Transferir de Conta Corrente para Conta Corrente");
                                    System.out.println("2. Transferir de Conta Corrente para Conta Poupança");
                                    System.out.println("3. Transferir da Conta Poupança para Conta Corrente");
                                    System.out.println("4. Transferir da Conta Poupança para Conta Poupança");
                                    System.out.println("5. Retornar ao Menu Inicial");
                                    System.out.println("Selecione a opção desejada, digitando o número correspondente: ");

                                    opcaoTransferir = scanner.nextInt();

                                    Conta contaOrigem = null;
                                    Conta contaDestino = null;

                                    switch (opcaoTransferir) {
                                        case 1:
                                            System.out.println("Selecione a conta corrente de origem:");
                                            System.out.println("1. Conta Corrente 1 (Número: " + cc1.getNumeroConta() + ")");
                                            System.out.println("2. Conta Corrente 2 (Número: " + cc2.getNumeroConta() + ")");
                                            int opcaoOrigemCC = scanner.nextInt();

                                            System.out.println("Selecione a conta corrente de destino:");
                                            System.out.println("1. Conta Corrente 1 (Número: " + cc1.getNumeroConta() + ")");
                                            System.out.println("2. Conta Corrente 2 (Número: " + cc2.getNumeroConta() + ")");
                                            int opcaoDestinoCC = scanner.nextInt();

                                            if (opcaoOrigemCC == 1) {
                                                contaOrigem = cc1;
                                            } else if (opcaoOrigemCC == 2) {
                                                contaOrigem = cc2;
                                            }

                                            if (opcaoDestinoCC == 1) {
                                                contaDestino = cc1;
                                            } else if (opcaoDestinoCC == 2) {
                                                contaDestino = cc2;
                                            }
                                            break;

                                        case 2:
                                            System.out.println("Selecione a conta corrente de origem:");
                                            System.out.println("1. Conta Corrente 1 (Número: " + cc1.getNumeroConta() + ")");
                                            System.out.println("2. Conta Corrente 2 (Número: " + cc2.getNumeroConta() + ")");
                                            int opcaoOrigemCP = scanner.nextInt();

                                            System.out.println("Selecione a conta poupança de destino:");
                                            System.out.println("1. Conta Poupança 1 (Número: " + cp1.getNumeroConta() + ")");
                                            System.out.println("2. Conta Poupança 2 (Número: " + cp2.getNumeroConta() + ")");
                                            int opcaoDestinoCP = scanner.nextInt();

                                            if (opcaoOrigemCP == 1) {
                                                contaOrigem = cc1;
                                            } else if (opcaoOrigemCP == 2) {
                                                contaOrigem = cc2;
                                            }

                                            if (opcaoDestinoCP == 1) {
                                                contaDestino = cp1;
                                            } else if (opcaoDestinoCP == 2) {
                                                contaDestino = cp2;
                                            }
                                            break;

                                        case 3:
                                            System.out.println("Selecione a conta poupança de origem:");
                                            System.out.println("1. Conta Poupança 1 (Número: " + cp1.getNumeroConta() + ")");
                                            System.out.println("2. Conta Poupança 2 (Número: " + cp2.getNumeroConta() + ")");
                                            int opcaoOrigemPC = scanner.nextInt();

                                            System.out.println("Selecione a conta corrente de destino:");
                                            System.out.println("1. Conta Corrente 1 (Número: " + cc1.getNumeroConta() + ")");
                                            System.out.println("2. Conta Corrente 2 (Número: " + cc2.getNumeroConta() + ")");
                                            int opcaoDestinoPC = scanner.nextInt();

                                            if (opcaoOrigemPC == 1) {
                                                contaOrigem = cp1;
                                            } else if (opcaoOrigemPC == 2) {
                                                contaOrigem = cp2;
                                            }

                                            if (opcaoDestinoPC == 1) {
                                                contaDestino = cc1;
                                            } else if (opcaoDestinoPC == 2) {
                                                contaDestino = cc2;
                                            }
                                            break;

                                        case 4:
                                            System.out.println("Selecione a conta poupança de origem:");
                                            System.out.println("1. Conta Poupança 1 (Número: " + cp1.getNumeroConta() + ")");
                                            System.out.println("2. Conta Poupança 2 (Número: " + cp2.getNumeroConta() + ")");
                                            int opcaoOrigemPP = scanner.nextInt();

                                            System.out.println("Selecione a conta poupança de destino:");
                                            System.out.println("1. Conta Poupança 1 (Número: " + cp1.getNumeroConta() + ")");
                                            System.out.println("2. Conta Poupança 2 (Número: " + cp2.getNumeroConta() + ")");
                                            int opcaoDestinoPP = scanner.nextInt();

                                            if (opcaoOrigemPP == 1) {
                                                contaOrigem = cp1;
                                            } else if (opcaoOrigemPP == 2) {
                                                contaOrigem = cp2;
                                            }

                                            if (opcaoDestinoPP == 1) {
                                                contaDestino = cp1;
                                            } else if (opcaoDestinoPP == 2) {
                                                contaDestino = cp2;
                                            }
                                            break;

                                        case 5:
                                            System.out.println(">>> Retornando ao Menu Inicial");
                                            break;

                                        default:
                                            System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                                            break;
                                    }
                                    if (opcaoTransferir >= 1 && opcaoTransferir <= 4) {
                                        System.out.println("Digite o valor a ser transferido: R$");
                                        double valorTransferencia = scanner.nextDouble();

                                        Transferencia t1 = new Transferencia(contaOrigem, contaDestino, valorTransferencia);
                                        t1.realizarTransferencia();
                                    }
                                    break;
                                }
                                break;

                            case 2:
                                System.out.println(">>> Retornando ao Menu Inicial");
                                break;

                            default:
                                System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                                break;
                        }
                        break;
                    }
                    break;

                case 6:
                    System.out.println("================================================================");
                    System.out.println("O EFS3Bank agradece a sua visita, " + nomeCliente + "!");
                    System.out.println("Até breve! ;)");
                    break;

                default:
                    System.out.println(">>> ATENÇÃO! Opção inválida. Tente novamente");
                    break;
            }
            //break;
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