package Cofre;

public abstract class Moeda {
    
    private double valor;
    
    //Contrutores usados para usar o super() nas outras classes
    public Moeda(double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public abstract void info();

    public abstract double converter();
    
}
