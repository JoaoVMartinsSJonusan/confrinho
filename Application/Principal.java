package Application;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import Cofre.Cofrinho;
import Cofre.Euro;
import Cofre.Dolar;
import Cofre.Real;


public class Principal {
    //Função para limpar a tela do terminal
    public static void limpartela() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        limpartela();
        Cofrinho cofre= new Cofrinho();
        char escolha;
        //um try-catch para caso o usuario escreva algo que nao seja um numero e evite assim o erro do programa
        
        try {
            do {
                cofre.listagemMoedas();
                System.out.println("------------------------------------------------------------");
                System.out.print("Deseja adicionar [1] DOLAR, [2]EURO ou [3]REAL: ");
                int escolhaMoeda = sc.nextInt();
                Double valor = 0.0;
                
                //De acordo com a escolha do usuario é feita um polimorfismo adicionando os valores digitados a lista na classe Cofrinho
                switch (escolhaMoeda) {
                    case 1:
                        System.out.print("digite o valor a ser depositado: ");
                        valor = sc.nextDouble();
                        cofre.adicionar(new Dolar(valor));
                        break;
                    case 2:
                        System.out.print("digite o valor a ser depositado: ");
                        valor = sc.nextDouble();
                        cofre.adicionar(new Euro(valor));
                        break;
                    case 3:
                        System.out.print("digite o valor a ser depositado: ");
                        valor = sc.nextDouble();
                        cofre.adicionar(new Real(valor));
                        break;
                    default:
                        break;
                }
                System.out.print("Deseja continuar adicionando valores? [S]/[N] ");
                escolha = sc.next().toUpperCase().charAt(0);
                limpartela();
            } while (escolha != 'N');

            cofre.listagemMoedas();
            //Linhas de comando para remoção de valores da lista
            System.out.print("Deseja remover algum valor? [S]/[N] ");
            escolha = sc.next().toUpperCase().charAt(0);
            while(escolha == 'S'){
                System.out.println();
                cofre.listagemMoedas();
                System.out.println();
                System.out.print("Digite o valor a ser retirado: ");
                double valorRemover = sc.nextDouble();
                cofre.remover(valorRemover);
                limpartela();
                cofre.listagemMoedas();
                System.out.print("Deseja remover outro valor? [S]/[N] ");
                escolha = sc.next().toUpperCase().charAt(0);
                limpartela();
            }
                
        } catch(InputMismatchException e){
            System.out.println("Erro InputMismatchException: Digitou algo incorretamente.");
        }

        System.out.println();

        cofre.listagemMoedas();
        System.out.println();
        cofre.totalConvertido();

        
        sc.close();
    }
}
