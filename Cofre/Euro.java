package Cofre;

public class Euro extends Moeda {
    
    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Saldo em conta: EU " + String.format("%.2f", getValor()));
    }

    @Override
    public double converter() {
        double convertReal = getValor() * 5.38;
        return convertReal;
    }

    public String toString() {
        return "Saldo em Euro: " + getValor();
    }

}
