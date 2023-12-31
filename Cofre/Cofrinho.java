package Cofre;

import java.util.ArrayList;
import java.util.List;



public class Cofrinho {
    //Lista onde as moedas serao adicionadas.
    private List<Moeda> moedas;

    private double convertido;

    public Cofrinho() {
        this.moedas = new ArrayList<>();
    }


    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
    }


    public void remover(Double moeda) {
        //Laço for para percorrer todo a lista verificando se tem o valor que quer ser removido.
        for (int i = 0; i < moedas.size(); i++) {
            //variavel Booleana para saber se foi ou nao encontrado o valor para remover.
            boolean temOuNao = false;
            Moeda m = moedas.get(i);
            //Comando if para saber se o valor na posição "i" da lista é igual o valor solicitado para remoção.
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
        System.out.println("--- CARTEIRA ---");
        //foreach para listar moedas
        for (Moeda moeda : moedas) {
            System.out.println(moeda);
        }
    }


    public void totalConvertido() {
        int controle = 0;
        for (Moeda moeda : moedas) {
            //Verificação feita para saber o valor é da classe real ou nao, ja que quando tinha somente o moeda.converter(), chamava o metodo do real perguntando para qual moeda queria converter, porem essa função totalConvertido() serve para retornar o valor total convertido em reais.
            if (moeda instanceof Real) {
                convertido += moeda.getValor();
            } else {
                convertido += moeda.converter();
                controle++;
            }
        }
        System.out.println("Saldo total convertido para Reais: R$" + String.format("%.2f", convertido));
        //Serve para saber se ja foi convertido, pois quando chamava sem esse controle varias vezes seguidas o valor se duplicava, essa linha de codigo abaixo faz com que isso seja evitado, fazendo com que o valor convertido seja exatamente sobre o valor que esta na carteira naquele exato momento.
        if(controle > 0){
            convertido = 0;
        }
    }

    
}
