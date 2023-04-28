package entidades;

import java.time.LocalDate;

public class Compra {
    private LocalDate data;
    private double valorCompra;
    private String loja;

    public Compra(LocalDate data, double valorCompra, String loja) {
        this.data = data;
        this.valorCompra = valorCompra;
        this.loja = loja;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public String getLoja() {
        return loja;
    }
}