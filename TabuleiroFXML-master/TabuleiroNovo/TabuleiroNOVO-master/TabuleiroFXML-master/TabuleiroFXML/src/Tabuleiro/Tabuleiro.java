
// Source File Name:   Tabuleiro.java
package Tabuleiro;

import java.io.PrintStream;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

// Referenced classes of package jogotabuleirofxml:
//            BancoPeças, Casa, Peça
public class Tabuleiro {

    public void setCasas(int Linhas, int Colunas) {
        Casas = new Casa[Linhas][Colunas];
        BordaX = Linhas - 1;
        BordaY = Colunas - 1;
    }

    public Casa[][] getCasas() {
        return Casas;
    }

    public Casa getCasaEspecifica(int x,int y) {
        return Casas[x][y];
    }    
    
    public int getBordaX() {
        return BordaX;
    }

    public int getBordaY() {
        return BordaY;
    }

    public int getPeçasBrancas() {
        return PeçasBrancas;
    }

    private void setPeçasBrancas(int peçasBrancas) {
        PeçasBrancas = peçasBrancas;
    }

    public int getPeçasPretas() {
        return PeçasPretas;
    }

    private void setPeçasPretas(int peçasPretas) {
        PeçasPretas = peçasPretas;
    }

    public Tabuleiro(int Linhas, int Colunas) {
        setPeçasBrancas(0);
        setPeçasPretas(0);
        Dados = new BancoPeças();
        setCasas(Linhas, Colunas);
        for (int i = 0; i < Linhas; i++) {
            for (int j = 0; j < Colunas; j++) {
                Casas[i][j] = new Casa(i, j);
            }

        }

    }

    public boolean MovimentoVálido(ArrayList<Integer> Trajeto) {
        
        for (int i = 0; i < Trajeto.size(); i += 2) {
            
            int x = ((Integer) Trajeto.get(i)).intValue();
            int y = ((Integer) Trajeto.get(i + 1)).intValue();
            
            if (x > BordaX || y > BordaY || x < 0 || y < 0) {
                return false;
            }
            if (CasaTemPeça(x, y)) {
                return false;
            }
        }

        return true;
    }
    
    public ArrayList ChecarCadaRumo(ArrayList<Integer> AllRumos) {
        
        int i = 0, x, y;
        int FIM = -200;
        int SepararRumo = -100;
        
        ArrayList aux, Final = new ArrayList();
        
        aux = new ArrayList();
        
        while(AllRumos.get(i) != null) {
            
            if(AllRumos.get(i) == SepararRumo) {

                if(MovimentoVálido(aux) == true) {
                    
                    Final.addAll(aux);
                }
                
                
                if(AllRumos.get(i + 1) == FIM) {
                    
                    return Final;
                }
                
               i++;
               aux.clear();
            }
            
            x = AllRumos.get(i);
            y = AllRumos.get(i + 1);
            
            aux.add(x);
            aux.add(y);
            
            i += 2;
        }
        
        return Final;
    }

    public boolean CasaTemPeça(int X, int Y) {
        return Casas[X][Y].getUnidade() != null;
    }
    
    
    public boolean CasaÉVerde(int X, int Y) {
        
        if(this.Casas[X][Y].getFill().equals(Color.DARKGREEN) || this.Casas[X][Y].getFill().equals(Color.LIGHTGREEN)) return true;
        else return false;
    }

    @Deprecated
    public boolean MoverPeça(int X, int Y, int NovoX, int NovoY) {
        if (!CasaTemPeça(X, Y)) {
            return false;
        }
      //  if (!MovimentoVálido(X, Y, NovoX, NovoY)) {
          //  return false;
        //}
        if (CasaTemPeça(NovoX, NovoY)) {
            if (Casas[NovoX][NovoY].getUnidade().Cor == 0) {
                PeçasBrancas--;
            } else {
                PeçasPretas--;
            }
        }
        Peça Transitória = Casas[X][Y].getUnidade();
        Transitória.X = NovoX;
        Transitória.Y = NovoY;
        RemoverPeça(X, Y);
        InserirPeça(NovoX, NovoY, Transitória);
        return true;
    }

    public boolean CapturaVálida(int X, int Y, int NovoX, int NovoY) {
        if (Casas[NovoX][NovoY].getUnidade().Cor == Casas[X][Y].getUnidade().Cor) {
            
            return false;
        }
        
        ArrayList Investida = Casas[X][Y].getUnidade().TraçarCaptura(NovoX, NovoY);
        
        if (Investida == null) {
            
            return false;
        }
        int i = 0;
        
        if (i < Investida.size() / 2) {
            
            int x = ((Integer) Investida.get(i)).intValue();
            int y = ((Integer) Investida.get(i + 1)).intValue();
            if (x == NovoX && y == NovoY) {
                return true;
            }
            if (x > BordaX || y > BordaY || x < 0 || y < 0) {
                return false;
            }
            if (CasaTemPeça(x, y)) {
                System.out.println("Aqui3");
            }
            return false;
        } else {
            return true;
        }
    }

    public boolean CapturarPeça(int X, int Y, int NovoX, int NovoY) {
        if (!CasaTemPeça(X, Y) || !CasaTemPeça(NovoX, NovoY)) {
            return false;
        }
        if (!CapturaVálida(X, Y, NovoX, NovoY)) {
            
            return false;
        }
        
        Peça Transitória = Casas[X][Y].getUnidade();
        Transitória.X = NovoX;
        Transitória.Y = NovoY;
        if (Casas[X][Y].getUnidade().Cor == 0) {
            PeçasBrancas--;
        } else {
            PeçasPretas--;
        }
        RemoverPeça(X, Y);
        InserirPeça(NovoX, NovoY, Transitória);
        return true;
    }

    public boolean PreencherCasa(int X, int Y, Peça Tipo) {
        if (CasaTemPeça(X, Y)) {
            return false;
        }
        if (Tipo.Cor == 0) {
            
            PeçasBrancas++;
        } else {
            
            PeçasPretas++;
        }
        Casas[X][Y].setPeça(Tipo);
        return true;
    }

    public void RemoverPeça(int X, int Y) {
        
        Casas[X][Y].getUnidade().SetImage();
        Casas[X][Y].setPeça(null);
    }
    
    public void InserirPeça(int NovoX, int NovoY, Peça Unidade) {
         
        
        Casas[NovoX][NovoY].setPeça(Unidade);
       // this.Casas[NovoX][NovoY].getUnidade().setOnMouseClicked(TrataCliqueDoMouse);
    }
    public void InserirPeça(int NovoX,int NovoY, Peça Unidade, EventHandler<MouseEvent> lugar){
        Casas[NovoX][NovoY].setPeça(Unidade);
       this.Casas[NovoX][NovoY].getUnidade().setOnMouseClicked(lugar);
    }
    public void ExibirTab() {
        for (int i = 0; i <= BordaY; i++) {
            System.out.print((new StringBuilder()).append("   ").append(i).toString());
        }

        System.out.println();
        for (int i = 0; i <= BordaX; i++) {
            System.out.print(" -");
            for (int DivisF3ria = 0; DivisF3ria <= BordaY; DivisF3ria++) {
                System.out.print("----");
            }

            System.out.print("\n");
            System.out.print(i);
            for (int j = 0; j <= BordaY; j++) {
                if (Casas[i][j].getUnidade() == null) {
                    System.out.print("|   ");
                } else {
                    System.out.print((new StringBuilder()).append("| ").append(Casas[i][j].getUnidade().Formato).append(" ").toString());
                }
            }

            System.out.print("|\n");
        }

        System.out.print(" -");
        for (int DivisF3ria = 0; DivisF3ria <= BordaY; DivisF3ria++) {
            System.out.print("----");
        }

        System.out.println();
    }

    public int Supremacia() {
        if (PeçasBrancas == 0) {
            return 0;
        }
        return PeçasPretas != 0 ? 2 : 1;
    }

    private Casa Casas[][];
    private int BordaX;
    private int BordaY;
    private int PeçasBrancas;
    private int PeçasPretas;
    private BancoPeças Dados;
}
