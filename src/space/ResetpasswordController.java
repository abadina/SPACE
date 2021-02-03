/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;
import connexion.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ResetpasswordController implements Initializable {
         @FXML
            private Button sauvegarder;
         @FXML
private Pane panelLoadLabel;
         @FXML
    private PasswordField cm;

    @FXML
    private PasswordField am;

    @FXML
    private PasswordField nm;
    @FXML
    private Label res;
         user U=new user();
         DAOUSER dao=new DAOUSER();
    
    
   @FXML
    void sauv(ActionEvent event) throws IOException  {
        
            //checker mdp
       U.getPassword();
       String oldpass=am.getText();
       String newpass=nm.getText();
       String conpass=cm.getText();
       //On compare le mot de passe  entré avec le mot de passe de l'utilisateur
       if(oldpass.equals(U.getPassword())){
        if( !(newpass.equals(""))){   //On compare le mot de passe confirmé avec le nouveau mot de passe entré
       if(newpass.equals(conpass) ){
           U.setPassword(conpass);
           U.getPassword();
           
           dao.Updatepassword(U);
       
        try {
                         FileOutputStream fs = new FileOutputStream("user.ser");
                         ObjectOutputStream os = new ObjectOutputStream(fs);
                         os.writeObject(U); // 3
                         os.close();
                      } catch (Exception e) { 
                                System.out.println("ERREEUUUUUR"); 
                      }
        
         ((Node)(event.getSource())).getScene().getWindow().hide();
          
       }
      
       else {
           res.setVisible(true);
           res.setText("Mot de passe non identique!");
       }
       }
        else{
            res.setVisible(true);
           res.setText("Nouveau mdp est vide");
        }
       }
       else
       {
           res.setVisible(true);
           res.setText("Ancien mot de passe erroné");
       }
              
      
        
    }
    
     @FXML
    void parametre(ActionEvent event) {
       
           ((Node)(event.getSource())).getScene().getWindow().hide();
       
    }

    @FXML
    void f5f2f2(ActionEvent event) {

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
