package entidades;

public class Transferencia {
    private Conta origem;
    private Conta destino;
    private double valor;

    public Transferencia(Conta origem, Conta destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public void realizarTransferencia() {
        if (origem.getSaldo() >= valor) {
            origem.realizarSaque(valor);
            destino.realizarDeposito(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }
}
