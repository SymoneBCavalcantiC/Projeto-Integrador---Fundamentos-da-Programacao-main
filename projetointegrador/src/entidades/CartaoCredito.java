package entidades;
import java.util.ArrayList;
import java.util.Scanner;

public class CartaoCredito {
    private double limite;
    private double faturaMensal;
    private ArrayList<Compra> compras;

    public CartaoCredito(double limite) {
        this.limite = limite;
        this.faturaMensal = 0.0;
        this.compras = new ArrayList<>();
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getFaturaMensal() {
        return faturaMensal;
    }

    public void setFaturaMensal(double faturaMensal) {
        this.faturaMensal = faturaMensal;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public void efetuarCompra() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o dia da compra: ");
        int dia = input.nextInt();

        System.out.print("Digite o valor da compra (R$): ");
        double valor = input.nextDouble();

        input.nextLine();

        System.out.print("Digite o nome da loja: ");
        String loja = input.nextLine();

        Compra novaCompra = new Compra(dia, valor, loja);
        this.compras.add(novaCompra);

        double cashback = valor * 0.01;
        this.faturaMensal += valor - cashback;

        System.out.println(">>> Compra realizada com sucesso!");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Valor da compra: R$ %.2f\n", valor);
        System.out.printf("Cashback pela compra: R$ %.2f\n", cashback);
        System.out.printf("Valor a pagar na fatura mensal: R$ %.2f\n", this.faturaMensal);
    }

    public void listarCompras() {
        if (this.compras.size() == 0) {
            System.out.println(">>> Nenhuma compra realizada ainda.");
            return;
        }

        System.out.println("HISTÓRICO DE COMPRAS:");
        System.out.println("---------------------------------------------------------------");
        for (Compra compra : this.compras) {
            System.out.printf("Data: %s | Loja: %s | Valor: R$ %.2f\n",
                    compra.getDia(), compra.getLoja(), compra.getValorCompra());
        }

        double soma = 0;
        for (Compra compra : this.compras) {
            soma += compra.getValorCompra();
        }
        System.out.printf("Somatório das compras: R$ %.2f\n", soma);
    }

    public void emitirFatura() {
        if (this.compras.size() == 0) {
            System.out.println(">>> Nenhuma compra realizada ainda.");
            return;
        }

        double totalCompras = 0.0;
        double cashbackAcumulado = 0.0;

        for (Compra compra : this.compras) {
            totalCompras += compra.getValorCompra();
            cashbackAcumulado += compra.getValorCompra() * 0.01;
        }

        this.faturaMensal = totalCompras - cashbackAcumulado;

        System.out.println("FATURA DO MÊS:");
        System.out.printf("Valor total das compras: R$ %.2f\n", totalCompras);
        System.out.printf("Montante acumulado de cashback: R$ %.2f\n", cashbackAcumulado);
        System.out.printf("Valor a pagar na fatura: R$ %.2f\n", this.faturaMensal);
    }

    public void debitarFatura(ContaCorrente contaCorrente1, ContaCorrente contaCorrente2) {
        if (faturaMensal <= 0.0) {
            System.out.println(">>> Nenhuma fatura pendente.");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Selecione a conta corrente para debitar a fatura:");
        System.out.println("1. Conta Corrente 1");
        System.out.println("2. Conta Corrente 2");
        int opcao = input.nextInt();

        ContaCorrente contaCorrente;

        if (opcao == 1) {
            contaCorrente = contaCorrente1;
        } else if (opcao == 2) {
            contaCorrente = contaCorrente2;
        } else {
            System.out.println(">>> Opção inválida.");
            return;
        }

        if (faturaMensal <= contaCorrente.getSaldo() + contaCorrente.getLimite()) {
            if (faturaMensal <= contaCorrente.getSaldo()) {
                contaCorrente.sacar(faturaMensal);
            } else {
                double valorRestante = faturaMensal - contaCorrente.getSaldo();
                contaCorrente.sacar(contaCorrente.getSaldo());
                contaCorrente.sacarDoLimite(valorRestante);
            }

            // Remover as compras quitadas da lista de compras
            ArrayList<Compra> comprasQuitadas = new ArrayList<>();
            for (Compra compra : compras) {
                if (compra.getValorCompra() <= faturaMensal) {
                    comprasQuitadas.add(compra);
                }
            }
            compras.removeAll(comprasQuitadas);

            System.out.println(">>> Fatura debitada com sucesso!");
            System.out.println("---------------------------------------------------------------");
            System.out.printf("Valor debitado: R$ %.2f\n", faturaMensal);
            faturaMensal = 0.0;
        } else {
            System.out.println(">>> Saldo insuficiente na conta corrente selecionada!");
        }
    }

}

