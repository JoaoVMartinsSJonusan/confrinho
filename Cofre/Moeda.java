package Cofre;

public abstract class Moeda extends Cofrinho {
    
    private double valor;
    //Contrutores usados para usar o super() nas outras classes
    public Moeda() {

    }
    
    public Moeda(double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public void info() {}

    public double converter() {
        return 0.0;
    }
}
