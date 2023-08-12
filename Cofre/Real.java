package Cofre;

import java.util.Scanner;



public class Real extends Moeda {
    

    public Real(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Saldo em conta: R$" + String.format("%.2f", getValor()));
    }

    @Override
    public double converter() {
        Scanner sc = new Scanner(System.in);
        double convertDolar = 0;
        System.out.println("Deseja converter para [1]EURO ou [2]DOLAR? ");
        int escolha = sc.nextInt();
        
        switch (escolha) {
            case 1:
                convertDolar = getValor() / 4.91;
                break;
            case 2:
                convertDolar = getValor() / 5.38;
                break;
        
            default:
                break;
        }
        sc.close();
        return convertDolar;
    }

    public String toString() {
        return "Saldo em Reais: R$" + getValor();
    }
    
}
