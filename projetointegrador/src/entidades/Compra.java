package entidades;

import java.time.LocalDate;

public class Compra {
    private int dia;
    private double valorCompra;
    private String loja;

    public Compra(int dia, double valorCompra, String loja) {
        this.dia = dia;
        this.valorCompra = valorCompra;
        this.loja = loja;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public String getLoja() {
        return loja;
    }
}