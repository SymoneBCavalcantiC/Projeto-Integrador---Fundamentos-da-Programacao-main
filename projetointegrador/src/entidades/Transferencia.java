package entidades;

public class Transferencia {
    protected Conta contaOrigem;
    protected Conta contaDestino;
    protected double valor;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    public void realizarTransferencia() {
        if (contaOrigem.getSaldo() >= valor) {
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }
}
