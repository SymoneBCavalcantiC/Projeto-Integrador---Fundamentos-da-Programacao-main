package entidades;
import java.time.LocalDate;
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

        System.out.print("Digite o valor da compra: ");
        double valor = input.nextDouble();

        input.nextLine();

        System.out.print("Digite o nome da loja: ");
        String loja = input.nextLine();

        Compra novaCompra = new Compra(LocalDate.now(), valor, loja);
        this.compras.add(novaCompra);

        double cashback = valor * 0.01;
        this.faturaMensal += valor - cashback;

        System.out.println("Compra realizada com sucesso!");
        System.out.printf("Valor da compra: R$ %.2f\n", valor);
        System.out.printf("Cashback pela compra: R$ %.2f\n", cashback);
        System.out.printf("Valor a pagar na fatura: R$ %.2f\n", this.faturaMensal);
    }

    public void listarCompras() {
        if (this.compras.size() == 0) {
            System.out.println("Nenhuma compra realizada ainda.");
            return;
        }

        System.out.println("Histórico de compras:");
        for (Compra compra : this.compras) {
            System.out.printf("Data: %s | Loja: %s | Valor: R$ %.2f\n",
                    compra.getData(), compra.getLoja(), compra.getValor());
        }
    }

    public void emitirFatura() {
        if (this.compras.size() == 0) {
            System.out.println("Nenhuma compra realizada ainda.");
            return;
        }

        double totalCompras = 0.0;
        double cashbackAcumulado = 0.0;

        for (Compra compra : this.compras) {
            totalCompras += compra.getValor();
            cashbackAcumulado += compra.getValor() * 0.01;
        }

        this.faturaMensal = totalCompras - cashbackAcumulado;

        System.out.println("Fatura do mês:");
        System.out.printf("Valor total das compras: R$ %.2f\n", totalCompras);
        System.out.printf("Montante acumulado de cashback: R$ %.2f\n", cashbackAcumulado);
        System.out.printf("Valor a pagar na fatura: R$ %.2f\n", this.faturaMensal);
    }

}

