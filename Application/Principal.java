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
        int escolhaMenu;
        //um try-catch para caso o usuario escreva algo que nao seja um numero e evite assim o erro do programa
        
        try {
            do {
                cofre.listagemMoedas();
                System.out.println("================");
                System.out.println("----------");
                System.out.println("---MENU---");
                System.out.println("----------");
                System.out
                        .println("Escolha sua opção:\n1) Despositar \n2) retirar  \n3) Converter para real \n4) Sair");
                System.out.print("Escolha sua opção: ");
                escolhaMenu = sc.nextInt();
                switch (escolhaMenu) {
                    case 1:
                        System.out.print("Deseja adicionar [1] DOLAR, [2]EURO ou [3]REAL: ");
                        int escolhaMoeda = sc.nextInt();
                        Double valor = 0.0;

                        //De acordo com a escolha do usuario é feita um polimorfismo adicionando os valores digitados a lista na classe Cofrinho
                        switch (escolhaMoeda) {
                            case 1:
                                System.out.print("digite o valor a ser depositado: ");
                                valor = sc.nextDouble();
                                cofre.adicionar(new Dolar(valor));
                                limpartela();
                                break;
                            case 2:
                                System.out.print("digite o valor a ser depositado: ");
                                valor = sc.nextDouble();
                                cofre.adicionar(new Euro(valor));
                                limpartela();
                                break;
                            case 3:
                                System.out.print("digite o valor a ser depositado: ");
                                valor = sc.nextDouble();
                                cofre.adicionar(new Real(valor));
                                limpartela();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        limpartela();
                        System.out.println();
                        cofre.listagemMoedas();
                        System.out.println();
                        System.out.print("Digite o valor a ser retirado: ");
                        double valorRemover = sc.nextDouble();
                        cofre.remover(valorRemover);
                        limpartela();
                        break;
                    case 3:
                        limpartela();
                        cofre.totalConvertido();
                        break;
                    default:
                        break;
                }
            } while (escolhaMenu != 4);

        } 
        catch(InputMismatchException e){
            System.out.println("Erro InputMismatchException: Digitou algo incorretamente.");
        }
        sc.close();
    }
}
