package Tabuleiro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Scanner;

public class JogoTabuleiro {

    public static void main(String args[]) throws IOException {

        Scanner Ler = new Scanner(System.in);

        int Linhas, Colunas, vez = 0;
        int Opção = 0;

        BancoPeças Dados = new BancoPeças();
        Jogador Player[] = new Jogador[2];
        Tabuleiro Tab = null;
        String Nome, aux = null;

        boolean flag = false;

        do {

            try {

                System.out.print("Digite o número de linhas: ");
                aux = Ler.nextLine();

                Linhas = Integer.parseInt(aux);

                System.out.print("Digite o número de colunas: ");   //Pegando O tamanho do tabuleiro;
                aux = Ler.nextLine();

                Colunas = Integer.parseInt(aux);

                Tab = new Tabuleiro(Linhas, Colunas); //Definindo o Tamanho do Tabuleiro;
                flag = false;

            } catch (NumberFormatException ex) {

                System.out.println("Você digitou um caracter inválido no lugar das linhas/colunas, por favor, digite um número inteiro.");
                flag = true;

            } catch (NegativeArraySizeException ex) {

                System.out.println("Você digitou um número negativo no lugar de linhas/coluna, por favor, digite um número inteiro.");
                flag = true;
            }
        } while (flag);

        System.out.print("Digite o nome do jogador 1, que começa: ");
        Nome = Ler.nextLine();
        Player[0] = new Jogador(Nome);

        do {

            if (flag) {

                System.out.println("Nome já foi escolhido por jogador 1.");
            }

            flag = true;

            System.out.print("Digite o nome do jogador 2: ");
            Nome = Ler.nextLine();
            Player[1] = new Jogador(Nome);

        } while (Nome.equals(Player[0].getNome()));

        flag = false;

        Tab.ExibirTab();

        do {

            try {

                System.out.println("\nQuantas Peças por Jogador?");
                aux = Ler.nextLine();

                Opção = Integer.parseInt(aux);

                flag = false;
            } catch (NumberFormatException ex) {

                System.out.println("Você digitou uma quantidade inválida, tente novamente:");
                flag = true;
            }

            if (Opção < 1) {

                System.out.println("Você digitou uma quantidade negativa ou nula, tente novamente:");
                flag = true;
            }
        } while (flag);

        Dados.ExibirPeças();

        new JogoTabuleiro().AtribuindoPeças(Player[0], 0, Ler, Dados, Tab, Opção);
        new JogoTabuleiro().AtribuindoPeças(Player[1], 1, Ler, Dados, Tab, Opção);

        do {
            System.out.println("Vez de " + Player[vez].getNome());
            System.out.println("A) Mover peça");
            System.out.println("B) Mover e capturar");
            System.out.println("C) Dar a vez");

            try {

                Opção = (char) System.in.read();
                Ler.nextLine();
            } catch (IOException ex) {

                System.out.println("Imput Inválido");
            }

            switch (Opção) {

                case 'a':
                case 'A':

                    flag = new JogoTabuleiro().OpçãoMover(Player[vez], vez, Ler, Tab, aux);

                    if (flag == false) {
                        vez ^= 1;
                    }
                    break;

                case 'b':
                case 'B':

                    if (flag == false) {
                        vez ^= 1;
                    }
                    break;

                case 'c':
                case 'C':

                    if (flag == false) {
                        vez ^= 1;
                    }
                    break;

                default:

                    System.out.println("Você não selecionou uma alternativa válida");
                    break;
            }

            vez ^= 1;
        } while (Tab.Supremacia() == 2);

    }

    public void AtribuindoPeças(Jogador Player, int Posição, Scanner Ler, BancoPeças Dados, Tabuleiro Tab, int Opção) {

        int PosiçãoX = 0, PosiçãoY = 0, Index = 0;
        boolean flag = false;

        String aux = null;
        Peça Nova = null;

        for (int i = 0; i < Opção; i++) {

            do {

                try {

                    System.out.println("Qual a " + (i + 1) + "ª peça de " + Player.getNome() + "?");
                    aux = Ler.nextLine();

                    Index = Integer.parseInt(aux);

                    System.out.println("Qual a coordenada x de sua peça?");
                    aux = Ler.nextLine();

                    PosiçãoX = Integer.parseInt(aux);

                    System.out.println("Qual a coordenada y de sua peça?");
                    aux = Ler.nextLine();

                    PosiçãoY = Integer.parseInt(aux);

                    flag = false;

                    Tab.getCasas()[PosiçãoX][PosiçãoY].getUnidade();
                } catch (NumberFormatException ex) {

                    System.out.println("Você digitou um dos items de forma inválida, tente novamente:");
                    flag = true;

                } catch (ArrayIndexOutOfBoundsException ex) {

                    System.out.println("Você digitou uma coordenada fora do tabuleiro");
                    flag = true;
                }

                Nova = Dados.NovaPeça(Index, Posição, PosiçãoX, PosiçãoY);

                if (Nova == null) {

                    System.out.println("Você não escolheu uma peça válida, tente novamente:");
                    flag = true;
                }
            } while (flag);

            Tab.PreencherCasa(PosiçãoX, PosiçãoY, Nova);

            Tab.ExibirTab();
        }
    }

    public boolean OpçãoMover(Jogador Player, int Posição, Scanner Ler, Tabuleiro Tab, String aux) {

        int PosiçãoX, PosiçãoY;
        int NovoX, NovoY;

        try {

            System.out.println("Digite a coordenada x da peça de " + Player.getNome() + " que se moverá:");
            aux = Ler.nextLine();

            PosiçãoX = Integer.parseInt(aux);

            System.out.println("Digite a coordenada y da peça de " + Player.getNome() + " que se moverá:");
            aux = Ler.nextLine();

            PosiçãoY = Integer.parseInt(aux);

            System.out.println("Digite a coordenada x da aonde a peça se moverá:");
            aux = Ler.nextLine();

            NovoX = Integer.parseInt(aux);

            System.out.println("Digite a coordenada x da aonde a peça se moverá:");
            aux = Ler.nextLine();

            NovoY = Integer.parseInt(aux);

            Tab.getCasas()[PosiçãoX][PosiçãoY].getUnidade();
            Tab.getCasas()[NovoX][NovoY].getUnidade();

        } catch (NumberFormatException ex) {

            System.out.println("Você digitou um formato para coordenadas errado");
            return false;
        } catch (ArrayIndexOutOfBoundsException ex) {

            System.out.println("Você digitou uma coordenada fora do tabuleiro");
            return false;
        }

        if (Tab.getCasas()[PosiçãoX][PosiçãoY].getUnidade().Cor == Posição) {

            if (Tab.MoverPeça(PosiçãoX, PosiçãoY, NovoX, NovoY) == false) {

                System.out.println("A nova coordenada não pode ser alcançada");
                return false;
            }

            return true;
        } else {

            System.out.println("A peça na coordenada não é de " + Player.getNome());
            return false;
        }
    }
}
