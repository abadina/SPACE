/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;
import connexion.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author YOUSSEF
 */
public class SPACE extends Application {
    user U=new user();
    @Override
    public void start(Stage stage) throws Exception {

{
    
   
    Parent root = FXMLLoader.load(getClass().getResource("load.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("LOADING...");
        stage.setScene(scene);
        stage.show();
        
    //    System.out.println("EWAAA");
//        S S= new S();
//     S.Recon();  
     
}


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        launch(args);
    }
    
}
