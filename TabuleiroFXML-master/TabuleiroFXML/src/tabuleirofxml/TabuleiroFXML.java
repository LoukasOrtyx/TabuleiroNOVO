// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/11/2017 19:37:51
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JogoTabuleiroFXML.java
package tabuleirofxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TabuleiroFXML extends Application {

    public TabuleiroFXML() {
        
    }
    
    public void start(Stage stage) throws Exception {
        
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("FXMLTelaInicial.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        
        launch(args);
    }
}
