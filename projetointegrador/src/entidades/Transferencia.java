package entidades;
import java.util.Scanner;


public class Transferencia {
    private Conta contaOrigem;
    private Conta contaDestino;
    private double valorTransf;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTransf = valor;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public void realizarTransferencia() {
        if (contaOrigem.getSaldo() >= valorTransf) {
            contaOrigem.sacar(valorTransf);
            contaDestino.depositar(valorTransf);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }
    public static void transferir(Scanner scanner, ContaCorrente cc1, ContaCorrente cc2, ContaPoupanca cp1, ContaPoupanca cp2) {
        int opcaoTransferir = 0;
        while (opcaoTransferir != 5) {
            System.out.println("================================================================");
            System.out.println("SUBMENU: Efetuar transferência");
            System.out.println("1. Transferir da Conta Corrente para Conta Corrente");
            System.out.println("2. Transferir da Conta Corrente para Conta Poupança");
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

            if (contaOrigem != null && contaDestino != null) {
                System.out.println("Informe o valor a ser transferido: ");
                double valorTransferencia = scanner.nextDouble();

                if (contaOrigem.sacar(valorTransferencia)) {
                    contaDestino.depositar(valorTransferencia);
                    System.out.println(">>> Transferência realizada com sucesso!");
                    System.out.println(">>> Saldo atual da conta de origem" + contaOrigem.getNumeroConta() + ": " + contaOrigem.getSaldo());
                    System.out.println(">>> Saldo atual da conta de destino" + contaDestino.getNumeroConta() + ": " + contaDestino.getSaldo());
                } else {
                    System.out.println(">>> ATENÇÃO! Saldo insuficiente para realizar a transferência.");
                }
            }
        }
    }
}
