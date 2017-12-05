/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabuleiro;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 *
 * @author
 */
public final class Tridente extends Peça {
    char nome='T';
    public char getNome(){
        return this.nome;
    }
    public Tridente(int cor, int x, int y) {
        
        super("png/Tridente.jpg");
        
        setFitHeight(TamCasa);
        setFitWidth(TamCasa);
        
        setCor(cor);
        setX(x);
        setY(y);
        
        if(cor == 0) Formato = 'T';
        else Formato = 't';
    }

    public int getCor() {
        
        return Cor;
    }

    public void setCor(int Cor) {
        Cor = Cor;
    }


    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public char getFormato() {
        return Formato;
    }

    public void setFormato(char Formato) {
        this.Formato = Formato;
    }

    @Override
    public ArrayList<Integer> TraçarCaminhos(int NovoX, int NovoY) { //A peça se move no formato de um tridente, tanto pra cima quanto para baixo.
        
        ArrayList<Integer> Caminho = new ArrayList<>();
        
        if(NovoX == -1 && NovoY == -1) {
            
            Caminho.add(X);
            Caminho.add(Y - 1);
            
            Caminho.add(X);
            Caminho.add(Y - 2);
            
            Caminho.add(SeparaRumos);
            
            Caminho.add(X);
            Caminho.add(Y - 1);
            
            Caminho.add(X - 1);
            Caminho.add(Y - 1);
            
            Caminho.add(X - 1);
            Caminho.add(Y - 2);
            
            Caminho.add(SeparaRumos);
            
            Caminho.add(X);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 1);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 1);
            Caminho.add(Y - 2);
            
            Caminho.add(SeparaRumos);
            Caminho.add(FIM);

        } else if ((X) == NovoX && (Y - 2) == NovoY) {//Traçando caminho pra cima
            
            Caminho.add(X);
            Caminho.add(Y - 1);
            
            Caminho.add(X);
            Caminho.add(Y - 2);

        } else if ((X - 1) == NovoX && (Y - 2) == NovoY) {//Traçando caminho pra cima e a esquerda
            
            Caminho.add(X);
            Caminho.add(Y - 1);
            
            Caminho.add(X - 1);
            Caminho.add(Y - 1);
            
            Caminho.add(X - 1);
            Caminho.add(Y - 2);
        } else if ((X + 1) == NovoX && (Y - 2) == NovoY) {    //Traçando caminho pra cima e a direita
            
            Caminho.add(X);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 1);
            Caminho.add(Y - 1);
            
            Caminho.add(X + 1);
            Caminho.add(Y - 2);
        } else {

            return null;
        }

        return Caminho;
    }

    @Override
    public ArrayList<Integer> TraçarCaptura(int NovoX, int NovoY) { //A peça comerá em diagonal da sua posiçao atual
        
        ArrayList<Integer> Captura = new ArrayList<>();
        
        if (NovoX == -1 && NovoY == -1) {
            
            Captura.add(X - 1);
            Captura.add(Y - 1);
            
            Captura.add(SeparaRumos);
            
            Captura.add(X + 1);
            Captura.add(Y - 1);
            
            Captura.add(SeparaRumos);
            
            Captura.add(X + 1);
            Captura.add(Y + 1);
            
            Captura.add(SeparaRumos);
            
            Captura.add(X - 1);
            Captura.add(Y + 1);
            
            Captura.add(SeparaRumos);
            Captura.add(FIM);
        
        } else if ((X - 1) == NovoX && (Y - 1) == NovoY) {     //(5,5)  -> (4,4) (6,4) (6,6) (4,6)
            
            Captura.add(X - 1);
            Captura.add(Y - 1);
        } else if ((X + 1) == NovoX && (Y - 1) == NovoY) {
            
            Captura.add(X + 1);
            Captura.add(Y - 1);
        } else if ((X + 1) == NovoX && (Y + 1) == NovoY) {
            
            Captura.add(X + 1);
            Captura.add(Y + 1);
        } else if ((X - 1) == NovoX && (Y + 1) == NovoY) {
            
            Captura.add(X - 1);
            Captura.add(Y + 1);
        } else {
            
            return null;
        }

        return Captura;
    }

}
