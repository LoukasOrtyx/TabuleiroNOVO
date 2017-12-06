// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/11/2017 19:28:55
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Source File Name:   BancoPeças.java
package Tabuleiro;

import java.io.PrintStream;
import java.util.ArrayList;

public class BancoPeças {

    int QtdPeças;
    Peça Aux;
    ArrayList<String> Tipos;

    private void setTipos() {
        
        this.Tipos = new ArrayList();
        
        this.Tipos.add("C++Jahyba");
        this.Tipos.add("Tridente");
        
        this.QtdPeças = this.Tipos.size();
    }

    public void ExibirPeças() {
        
        this.setTipos();
        for (int i = 0; i < this.QtdPeças; ++i) {
            
            System.out.println("" + (i + 1) + ". " + this.Tipos.get(i));
        }
    }

    public Peça NovaPeça(int Index, int Cor, int X, int Y) {
        
        switch (Index) {
            
            case 1: {
                
                this.Aux = new Cajahyba(Cor, X, Y);
            } break;
            
            case 2: {
                
                this.Aux = new Tridente(Cor, X, Y);
            } break;
        }
        
        return this.Aux;
    }
}
