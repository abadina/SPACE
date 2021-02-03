/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;
import connexion.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Macbook Pro
 */
public class LoginController implements Initializable {
DAOUSER dao=new DAOUSER();
user U=new user();
private static final String FILE_NAME = "user.ser";
    /**
     * Initializes the controller class.
     */
   @FXML
    private PasswordField ps;

    @FXML
    private TextField un;
    @FXML
    private Label erre;
    @FXML
    void inscrire(ActionEvent event) throws IOException {
 
           Parent root =  FXMLLoader.load(getClass().getResource("inscrire.fxml"));
           Scene root_scene = new Scene(root);
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(root_scene);
           stage.show();
        
    }
    
    
    
    
    @FXML 
    void mode(ActionEvent event) throws IOException {
 //U.setN(1);
// un.getCharacters();
        U.setUsername(un.getText());
//        U.setUsername((String) un.getCharacters());
        U.setPassword(ps.getText());
//        U.setPassword((String) ps.getCharacters());
        if((dao.checkusername(U)==1) && ( dao.checkpassword(U)==1))
            
        {
            U.setAuthentification(1);
            dao.seconnecter(U);
            U=dao.getUser(U);
            
            try {
         FileOutputStream fs = new FileOutputStream(FILE_NAME);
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }
            
            
           Parent root1 =  FXMLLoader.load(getClass().getResource("men.fxml"));
           Scene root_scene = new Scene(root1);
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(root_scene);
           stage.show();
        }
        
        else if((dao.checkusername(U)==1) && ( dao.checkpassword(U)==0))
        {
            erre.setText("Mot de passe erroné!");
        }
        
        else
        {
            erre.setText("Username erroné!");
        }


    }
//    @FXML 
//    void mode(ActionEvent event)  {
//        
//        label.setText("Hello World!");
//        
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
