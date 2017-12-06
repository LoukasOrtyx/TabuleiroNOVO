// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/11/2017 19:26:55
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Casa.java
package Tabuleiro;

import javafx.scene.shape.Rectangle;

// Referenced classes of package jogotabuleirofxml:
//            Peça
public class Casa extends Rectangle {

    public void setX(int X) {
        
        this.X = X;
    }
    
    public void setY(int Y) {
        
        this.Y = Y;
    }

    public Casa(int X, int Y) {
        
        
        setX(X);
        setY(Y);
        Unidade = null;
    }
    
    public int getCoordX() {
        
        return X;
    }
    
    public int getCoordY() {
    
        return Y;
    }

    public void setPeça(Peça Tipo) {
        
        Unidade = Tipo;
    }

    public Peça getUnidade() {
        
        return Unidade;
    }

    private int X;
    private int Y;
    private Peça Unidade;
}
