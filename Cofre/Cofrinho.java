package Cofre;

import java.util.ArrayList;
import java.util.List;



public class Cofrinho {
    
    private List<Moeda> moedas = new ArrayList<>();
    private double convertido;
    public Cofrinho() {
    }


    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
    }

    public void remover(Double moeda) {
        for (int i = 0; i < moedas.size(); i++) {
            boolean temOuNao = false;
            
            Moeda m = moedas.get(i);
            if (m.getValor().equals(moeda)) {
                temOuNao = true;
                moedas.remove(m);
                break;
            }
            else if(temOuNao == false){
                System.out.println("Valor não encontrado!");
            }
        }
        
    }

    public void listagemMoedas() {
        for (Moeda moeda : moedas) {
            System.out.println(moeda);
        }
    }


    public void totalConvertido() {
        for (Moeda moeda : moedas) {
            if(moeda instanceof Real){
                convertido += moeda.getValor();
            } else {
                convertido += moeda.converter();
            }
        }
        System.out.println(convertido);
    }

    
}
