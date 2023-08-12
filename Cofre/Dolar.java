package Cofre;

public class Dolar extends Moeda {
    

    public Dolar(Double valor) {
        super(valor);
    }



    @Override
    public void info() {
        System.out.println("Saldo em conta: $" + String.format("%.2f", getValor()));
    }

    @Override
    public double converter() {
        double convertReal = getValor() * 4.91;
        return convertReal;
    }

    
    public String toString() {
        return "Saldo em Dolar: " + getValor() + "";
    }

    

}
