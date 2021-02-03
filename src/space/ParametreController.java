/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import connexion.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ParametreController implements Initializable {
    @FXML
   private Button button;
    S Sp=new S();
  private static int rec=0;
  
  user U=new user();

    @FXML
    private Label voix;
    
@FXML
    void menu(ActionEvent event) {
   
          try{
	Parent root = FXMLLoader.load(getClass().getResource("men.fxml"));
        Scene scene = new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
               
}
          catch (Exception e)
{
	System.err.println(e.getMessage());
}
    
    }
     @FXML
    void avatar(ActionEvent event) {
   
          try{
	Parent root = FXMLLoader.load(getClass().getResource("updateavatar.fxml"));
        Scene scene = new Scene(root);
        Stage stage= new Stage();
          stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner( ((Node)(event.getSource())).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
         
               
}
          catch (Exception e)
{
	System.err.println(e.getMessage());
}
    
    }

   @FXML
    
   
    void resetpage(ActionEvent event) throws IOException  {
        
       
            Parent root=FXMLLoader.load( getClass().getResource("resetpassword.fxml"));
            Scene root_scene=new Scene(root);
            Stage stage= new Stage() ;
             stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner( ((Node)(event.getSource())).getScene().getWindow());
            stage.setScene(root_scene);
            stage.show();
        
    }
    
    @FXML
     void rec(ActionEvent event) throws IOException  {
        
        if(rec==0)
        { rec=1;
        voix.setText("Activé");
        voix.setVisible(true);
        }
        else
        {
            rec=0;
            voix.setText("Désactivé");
            voix.setVisible(true);

        }
       
        System.out.println("rec= "+rec);
        
         U.setRec(rec);
         
          try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }
        
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
         FileInputStream fis = new FileInputStream("user.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         U = (user) ois.readObject(); // 4
         ois.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }
         
        // TODO
    }    
    
}
