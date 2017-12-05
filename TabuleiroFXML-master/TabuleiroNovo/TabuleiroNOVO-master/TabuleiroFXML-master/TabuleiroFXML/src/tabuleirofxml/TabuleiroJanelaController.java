// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/11/2017 19:39:29
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TabuleiroController.java
package tabuleirofxml;

import Tabuleiro.Bolsonaro;
import Tabuleiro.Cajahyba;
import Tabuleiro.Casa;
import Tabuleiro.Peça;
import Tabuleiro.Tabuleiro;
import Tabuleiro.Tridente;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

// Referenced classes of package jogotabuleirofxml:
//            Tabuleiro, Casa
public class TabuleiroJanelaController implements Initializable {
        boolean tracado=false;//ver se ta traçado o caminho
        boolean pegou=false;
        int xvelho,yvelho,xnovo,ynovo;//xvideos yvideos
        Peça aux;
        char nomePeca;
    public TabuleiroJanelaController() {
        
        this.TrataCliqueDoMouse = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /*
                Peça aux = new Cajahyba(0, i, j);
                
                Tab.InserirPeça(i, j, aux);
                
                Tab.getCasas()[i][j].getUnidade().setOnMouseClicked(TrataCliqueDoMouse);
                
                gridPane.add(Tab.getCasas()[i][j].getUnidade(), i, j);
                
                
                */
                if(event.getSource() instanceof Casa) {
                    
                    System.out.print(((Casa) event.getSource()).getCoordX());
                    System.out.println(" " + ((Casa) event.getSource()).getCoordY());
                    
                    System.out.println("clicou em casa");
                    if(pegou==true && Tab.CasaÉVerde(((Casa) event.getSource()).getCoordX(),((Casa) event.getSource()).getCoordY()) == true){   //MOVER
                                                                                                                        
                        Peça aux;
                        
                        try {
                            nomePeca= Tab.getCasaEspecifica(xvelho, yvelho).getUnidade().getNome();
                            
                        } catch(Exception ex) {
                            
                            System.out.println("null");
                        }
                        
                        switch(nomePeca){
                            case 'B':
                                aux = new Bolsonaro(0, ((Casa) event.getSource()).getCoordX(), ((Casa) event.getSource()).getCoordY());
                                
                                Tab.InserirPeça(((Casa) event.getSource()).getCoordX(), ((Casa) event.getSource()).getCoordY(), aux, TrataCliqueDoMouse);
                                
                                Tab.RemoverPeça(xvelho, yvelho);
                                
                                Tab.getCasas()[((Casa) event.getSource()).getCoordX()][((Casa) event.getSource()).getCoordY()].getUnidade().setOnMouseClicked(TrataCliqueDoMouse);
                                
                                gridPane.add(Tab.getCasas()[((Casa) event.getSource()).getCoordX()][((Casa) event.getSource()).getCoordY()].getUnidade(), ((Casa) event.getSource()).getCoordX(),((Casa) event.getSource()).getCoordY());
                                break;
                            case 'C':
                                aux = new Cajahyba(0, ((Casa) event.getSource()).getCoordX(), ((Casa) event.getSource()).getCoordY());
                                
                                Tab.InserirPeça(((Casa) event.getSource()).getCoordX(), ((Casa) event.getSource()).getCoordY(), aux);
                                
                                Tab.RemoverPeça(xvelho, yvelho);
                                
                                Tab.getCasas()[((Casa) event.getSource()).getCoordX()][((Casa) event.getSource()).getCoordY()].getUnidade().setOnMouseClicked(TrataCliqueDoMouse);
                                
                                gridPane.add(Tab.getCasas()[((Casa) event.getSource()).getCoordX()][((Casa) event.getSource()).getCoordY()].getUnidade(), ((Casa) event.getSource()).getCoordX(),((Casa) event.getSource()).getCoordY());
                                
                                
                                break;
                                
                            case 'T':
                                 aux = new Tridente(0, ((Casa) event.getSource()).getCoordX(), ((Casa) event.getSource()).getCoordY());
                                
                                 Tab.InserirPeça(((Casa) event.getSource()).getCoordX(), ((Casa) event.getSource()).getCoordY(), aux, TrataCliqueDoMouse);
                                 
                                Tab.RemoverPeça(xvelho, yvelho);
                                
                                 Tab.getCasas()[((Casa) event.getSource()).getCoordX()][((Casa) event.getSource()).getCoordY()].getUnidade().setOnMouseClicked(TrataCliqueDoMouse);
                                
                                gridPane.add(Tab.getCasas()[((Casa) event.getSource()).getCoordX()][((Casa) event.getSource()).getCoordY()].getUnidade(), ((Casa) event.getSource()).getCoordX(),((Casa) event.getSource()).getCoordY());
                                
                                break;
                        }
                        pegou=false;
                    }
                    
                    if(tracado=true){
                    
                    System.out.println("cor voltou a preto");
                    voltaCor(Tab);
                    tracado=false;
                }
                }
                
                if(event.getSource() instanceof ImageView) {//LEMBRAR BOTAR COMER
                    if(pegou==false){
                        xvelho=((Peça) event.getSource()).getCoordX();
                        yvelho=((Peça) event.getSource()).getCoordY();
                        pegou=true;
                    }
                    System.out.println(event.getSource());
                    System.out.println("é Peça");
                    
                    TreatMovements(((Peça) event.getSource()), Tab);
                }
            }
        };
        
        gridPane = new GridPane();
    }
    
    public int getTamCasa() {

        return TamCasa;
    }

    public void setTamCasa(int TamCasa) {

        this.TamCasa = TamCasa;
    }

    public int getLinhas() {

        return Linhas;
    }

    public void setLinhas(int Linhas) {

        this.Linhas = Linhas;
    }

    public int getColunas() {

        return Colunas;
    }

    public void setColunas(int Colunas) {

        this.Colunas = Colunas;
    }

    public void MontarGrid() {
        boolean aq=false;
        boolean tembolsonaro=false;
        Tab = new Tabuleiro(Linhas, Colunas);

        for (int i = 0; i < Linhas; i++) {

            RowConstraints RC = new RowConstraints();
            RC.setPrefHeight(TamCasa);
            

            gridPane.getRowConstraints().add(RC);
        }

        for (int i = 0; i < Colunas; i++) {

            ColumnConstraints RC = new ColumnConstraints();
            RC.setPrefWidth(TamCasa);

            gridPane.getColumnConstraints().add(RC);
        }

        for (int i = 0; i < Linhas; i++) {

            for (int j = 0; j < Colunas; j++) {
             System.out.println("aaaaaaaaaaaaaaaaaaaaa");
                Tab.getCasas()[i][j].setHeight(TamCasa);
                Tab.getCasas()[i][j].setWidth(TamCasa);
                
                Tab.getCasas()[i][j].setOnMouseClicked(TrataCliqueDoMouse);

                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {

                    Tab.getCasas()[i][j].setFill(Color.BLACK);
                } else {

                    Tab.getCasas()[i][j].setFill(Color.ANTIQUEWHITE);
                }

                   gridPane.add(Tab.getCasas()[i][j], i, j);
                
                if(i == Linhas/2 && j == Colunas/2) {
                    
                   Peça aux = new Tridente(0, i, j);
                    
                   Tab.InserirPeça(i, j, aux);
                    
                   Tab.getCasas()[i][j].getUnidade().setOnMouseClicked(TrataCliqueDoMouse);
                    
                    gridPane.add(Tab.getCasas()[i][j].getUnidade(), i, j);
                }
                
                if(i == Linhas/3 && j == Colunas/3) {
                    if(Tab.CasaTemPeça(i, j)){
                        for(int lin=1;lin<Linhas;lin++){
                            for(int col=1;col<Colunas;col++){
                                if(!Tab.CasaTemPeça(lin,col)){
                                    i=lin;
                                    j=col;
                                    break;
                                }
                            }
                            if(!Tab.CasaTemPeça(i,j)){
                                    break;
                                }
                        }
                    }
                    Peça aux = new Cajahyba(0, i, j);
                    
                    Tab.InserirPeça(i, j, aux);
                    
                    Tab.getCasas()[i][j].getUnidade().setOnMouseClicked(TrataCliqueDoMouse);
                    
                    gridPane.add(Tab.getCasas()[i][j].getUnidade(), i, j);
                    
                   
                }
              
                
            }
        }
                    //BOTAR BOLSONARO
                    aq=false; 
                    int lin=0,col=0;
                    if(!tembolsonaro){
                            for(lin=0;lin<Linhas;lin++){
                           for( col=0;col<Colunas;col++){
                               if(!Tab.CasaTemPeça(lin,col)){
                                  
                                   aq=true;
                                   break;
                                   //goto fora;
                               }
                           }
                           if(aq==true){
                               break;
                             }
                       //    fora:

                       }
                           
                            if(lin<Linhas && col<Colunas){
                    Peça aux = new Bolsonaro(0, lin, col);
                  
                   Tab.InserirPeça(lin, col, aux,TrataCliqueDoMouse);
                    
                   Tab.getCasas()[lin][col].getUnidade().setOnMouseClicked(TrataCliqueDoMouse);
                      
                    gridPane.add(Tab.getCasas()[lin][col].getUnidade(), lin, col);
                     
                            }
                       
                   
                    }
               
         

                
        apPrincipal.getChildren().add(gridPane);
    }
    
    ImageView png;
    
    private final EventHandler<MouseEvent> TrataCliqueDoMouse;
    
    public void voltaCor(Tabuleiro Tab){
           for(int i = 0; i < Linhas; i ++) {
               for(int j=0;j<Colunas;j++){
                  if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                
                Tab.getCasas()[i][j].setFill(Color.BLACK);    
            } else {

                Tab.getCasas()[i][j].setFill(Color.ANTIQUEWHITE);
            } 
            tracado=false; 
               }    
        }
    }
    
    @FXML
    public void TreatMovements(Peça Unidade, Tabuleiro Tab) {
        
        ArrayList <Integer> AllTrajetos, TrajetosVálidos = new ArrayList();
        int i, x, y;
        int All = -1;
        
        AllTrajetos = Unidade.TraçarCaminhos(All, All);
        
        TrajetosVálidos = Tab.ChecarCadaRumo(AllTrajetos);
        
        for(i = 0; i < TrajetosVálidos.size(); i += 2) {
            
            x = TrajetosVálidos.get(i);
            y = TrajetosVálidos.get(i + 1);
            
            if (x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0) {
                
                Tab.getCasas()[x][y].setFill(Color.DARKGREEN);    
            } else {

                Tab.getCasas()[x][y].setFill(Color.LIGHTGREEN);
            } 
            tracado=true;
        }
        
    }
    
    @FXML
    public void initialize(URL url1, ResourceBundle resourcebundle) {
        
        

    }

    private int Linhas;
    private int Colunas;
    private int TamCasa;

    private Tabuleiro Tab;
    GridPane gridPane;
    
    Casa casa;

    @FXML
    AnchorPane apPrincipal;
}
