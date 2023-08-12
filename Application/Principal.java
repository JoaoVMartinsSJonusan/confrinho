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

    public static void limpartela() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        limpartela();
        Cofrinho cofre= new Cofrinho();
        char escolha;
        try {
            do {
                cofre.listagemMoedas();
                System.out.println("------------------------------------------------------------");
                System.out.print("Deseja adicionar [1] DOLAR, [2]EURO ou [3]REAL: ");
                int escolhaMoeda = sc.nextInt();
                Double valor = 0.0;
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

            System.out.println("Deseja remover algum valor? [S]/[N] ");
            escolha = sc.next().toUpperCase().charAt(0);
            while(escolha == 'S'){
                System.out.println();
                cofre.listagemMoedas();
                System.out.println();
                System.out.println("Digete o valor a ser retirado: ");
                double valorRemover = sc.nextDouble();
                cofre.remover(valorRemover);
                System.out.println("Deseja remover outro valor? [S]/[N] ");
                escolha = sc.next().toUpperCase().charAt(0);
                limpartela();
            }
                

        } catch(InputMismatchException e){
            System.out.println("Erro InputMismatchException: Digitou algo diferente de um número.");
        }

        System.out.println();

        cofre.listagemMoedas();
        System.out.println();
        cofre.totalConvertido();
        sc.close();
    }
}
