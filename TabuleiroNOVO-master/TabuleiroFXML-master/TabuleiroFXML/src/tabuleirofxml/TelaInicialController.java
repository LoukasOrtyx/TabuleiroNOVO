// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/11/2017 19:34:13
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TelaInicialController.java
package tabuleirofxml;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

// Referenced classes of package jogotabuleirofxml:
//            TabuleiroController

public class TelaInicialController implements Initializable {

    public TelaInicialController() {
    }

    @FXML
    private void handleButtonAction() {
        
        int Linhas = 0;
        int Colunas = 0;
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TabuleiroJanela.fxml"));
        Stage stage = new Stage();
        
        
        try {
            
            Linhas = Integer.parseInt(txtLinhas.getText());
            Colunas = Integer.parseInt(txtColunas.getText());
            
            Parent Raiz = (Parent) fxmlLoader.load();
            Scene Cena = new Scene(Raiz, Colunas * TamCasas, Linhas * TamCasas + 30);
            stage.setScene(Cena);
            
        } catch (IOException | NumberFormatException ex) {
            
            label = new Label("Formato Inválido");
            label.setFont(new Font("Times New Roman", 14));
            label.setLayoutX(ap.getWidth() / 2);
         
            
           ap.getChildren().add(label);
            
            System.out.print("Formato Inválido");
            return;
        }
        stage.initModality(Modality.APPLICATION_MODAL);
        
        TabuleiroJanelaController controller = fxmlLoader.<TabuleiroJanelaController>getController();
        
        controller.setColunas(Colunas);
        controller.setLinhas(Linhas);
        controller.setTamCasa(TamCasas);
       
        controller.MontarGrid();
        
        
        stage.setTitle("Tiririca");
        stage.show();
    }

    
    public void initialize(URL url1, ResourceBundle resourcebundle) {
        
    }
    
    @FXML
    private Label label;
    @FXML
    TextField txtLinhas;
    @FXML
    TextField txtColunas; 
    
    @FXML
    AnchorPane ap;
    
    final int TamCasas = 50;
}
