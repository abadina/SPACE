/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import connexion.user;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Macbook Pro
 */
public class loadController implements Initializable{
user U=new user();
    
      @FXML
    private ImageView load;
      private ActionEvent event;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         try {
         FileInputStream fis = new FileInputStream("user.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         U = (user) ois.readObject(); // 4
         ois.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }

        load.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        //((Node)(event.getSource())).getScene().getWindow().hide();
        pt.setOnFinished(event->{
            if(U.getAuthentification()==0)
            {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("StarT.fxml"));
            
            load.getScene().getWindow().hide();
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setTitle("WELCOME");
            stage1.setScene(scene);
            stage1.show();
        
            //load.setVisible(false);
  load.getScene().getWindow().hide();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       }
          else
            {
                try {
            Parent root1 = FXMLLoader.load(getClass().getResource("men.fxml"));
            
              load.getScene().getWindow().hide();
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setTitle("LOADING...");
            stage1.setScene(scene);
            stage1.show();
        
            //load.setVisible(false);
  load.getScene().getWindow().hide();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
            }
        } );
       
   //load.getScene().getWindow().hide();
    
    pt.play(); 
}
}
