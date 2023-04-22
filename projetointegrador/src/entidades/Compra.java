package entidades;

import java.time.LocalDate;

public class Compra {
    private LocalDate data;
    private double valor;
    private String loja;

    public Compra(LocalDate data, double valor, String loja) {
        this.data = data;
        this.valor = valor;
        this.loja = loja;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getLoja() {
        return loja;
    }
}