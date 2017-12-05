// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/11/2017 19:28:23
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Cajahyba.java
package Tabuleiro;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

// Referenced classes of package jogotabuleirofxml:
//            Peça
public class Cajahyba extends Peça {
 char nome='C';
 public char getNome(){
        return this.nome;
    }
 
    private void setCor(int cor) {
        Cor = cor;
    }

    public int getCor() {
        return Cor;
    }

    private void setX(int x) {
        X = x;
    }

    private void setY(int y) {
        Y = y;
    }

    public Cajahyba(int cor, int x, int y) {
        
        
        super("png/C++.png");
        
        setFitHeight(TamCasa);
        setFitWidth(TamCasa);
        
        
        setCor(cor);
        setX(x);
        setY(y);
        
        
        if (Cor == 0) {
            Formato = 'c';
        } else {
            Formato = 'C';
        }
    }
    
    public ArrayList TraçarCaminhos(int NovoX, int NovoY) {
        ArrayList Caminho = new ArrayList();
        
        // Delimitador entre uma trajetória e outra;
        
        
        if(NovoX == -1 && NovoY == -1) {
            
            Caminho.add(X);
            Caminho.add(Y + 1);
            
            Caminho.add(X - 1);
            Caminho.add(Y + 1);
            
            Caminho.add(X - 2);
            Caminho.add(Y + 1);
            
            Caminho.add(X - 2);
            Caminho.add(Y);
            
            Caminho.add(SeparaRumos); 
            
            Caminho.add(X);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 1);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 2);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 2);
            Caminho.add(Y);
            
            Caminho.add(SeparaRumos);
            
            Caminho.add(X - 1);
            Caminho.add(Y);
            
            Caminho.add(X - 1);
            Caminho.add(Y - 1);
            
            Caminho.add(X - 1);
            Caminho.add(Y - 2);
            
            Caminho.add(X);
            Caminho.add(Y - 2);
            
            Caminho.add(SeparaRumos); 
            
            Caminho.add(X + 1);
            Caminho.add(Y);
            
            Caminho.add(X + 1);
            Caminho.add(Y + 1);
            
            Caminho.add(X + 1);
            Caminho.add(Y + 2);
            
            Caminho.add(X);
            Caminho.add(Y + 2);
            
            Caminho.add(SeparaRumos);
            
            Caminho.add(FIM);
        } else if (X - 2 == NovoX && Y == NovoY) {
            
            Caminho.add(X);
            Caminho.add(Y + 1);
            
            Caminho.add(X - 1);
            Caminho.add(Y + 1);
            
            Caminho.add(X - 2);
            Caminho.add(Y + 1);
            
            Caminho.add(X - 2);
            Caminho.add(Y);
        } else if (X + 2 == NovoX && Y == NovoY) {
            
            Caminho.add(X);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 1);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 2);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 2);
            Caminho.add(Y);
            
        } else if (X == NovoX && Y - 2 == NovoY) {
            Caminho.add(X - 1);
            Caminho.add(Y);
            
            Caminho.add(X - 1);
            Caminho.add(Y - 1);
            
            Caminho.add(X - 1);
            Caminho.add(Y - 2);
            
            Caminho.add(X);
            Caminho.add(Y - 2);
        } else if (X == NovoX && Y + 2 == NovoY) {
            
            Caminho.add(X + 1);
            Caminho.add(Y);
            
            Caminho.add(X + 1);
            Caminho.add(Y + 1);
            
            Caminho.add(X + 1);
            Caminho.add(Y + 2);
            
            Caminho.add(X);
            Caminho.add(Y + 2);
        } else {
            
            return null;
        }
        
        return Caminho;
    }

    public ArrayList TraçarCaptura(int NovoX, int NovoY) {
        
        ArrayList Captura = new ArrayList();
        
        if(NovoX == -1 && NovoY == -1) {
            
            Captura.add(X - 1);
            Captura.add(Y);
            
            Captura.add(SeparaRumos); 
            
            Captura.add(X - 1);
            Captura.add(Y);
            
            Captura.add(X + 1);
            Captura.add(Y);
            
            Captura.add(SeparaRumos); 
            
            Captura.add(X);
            Captura.add(Y + 1);
            
            Captura.add(SeparaRumos);
            Captura.add(FIM);
        } else if (X - 1 == NovoX && Y == NovoY) {
            
            Captura.add(X - 1);
            Captura.add(Y);
        } else if (X == NovoX && Y - 1 == NovoY) {
            
            Captura.add(X);
            Captura.add(Y - 1);
        } else if (X + 1 == NovoX && Y == NovoY) {
            
            Captura.add(X + 1);
            Captura.add(Y);
        } else if (X == NovoX && Y + 1 == NovoY) {
            
            Captura.add(X);
            Captura.add(Y + 1);
        } else {
            
            return null;
        }
        
        return Captura;
    }
}
