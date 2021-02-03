/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import connexion.DAOUSER;
import connexion.user;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */


public class MapJAVAController implements Initializable {
 DAOUSER dao=new DAOUSER();
        user U=new user();
        
        /**
     * Initializes the controller class.
     */
@FXML
private Label score;

      @FXML
    void nextpage(ActionEvent event) {

        String n=((Node)(event.getSource())).getId();
        U.setNbqst(Integer.parseInt(n));
        
        try {
                         FileOutputStream fs = new FileOutputStream("user.ser");
                         ObjectOutputStream os = new ObjectOutputStream(fs);
                         os.writeObject(U); // 3
                         os.close();
                      } catch (Exception e) { 
                                System.out.println("ERREEUUUUUR"); 
                      }
        
    if(U.getNbqst()>=11)
    {
     if((dao.getScoreLang(U))<30)
     {
          try {
            Parent root1 = FXMLLoader.load(getClass().getResource("menu.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            } catch (Exception e) {
            System.err.println(e.getMessage());
            }
     }
     else {
          try {
            Parent root1 = FXMLLoader.load(getClass().getResource("qst.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            } catch (Exception e) {
            System.err.println(e.getMessage());
            }
     }
    }
    
    
    else  if(U.getNbqst()>=6)
    {
             if((dao.getScoreLang(U))<15)
             {
                 try {
            Parent root1 = FXMLLoader.load(getClass().getResource("menu.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            } catch (Exception e) {
            System.err.println(e.getMessage());
            }
             }
             else 
             {
                  try {
            Parent root1 = FXMLLoader.load(getClass().getResource("qst.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            } catch (Exception e) {
            System.err.println(e.getMessage());
            }
             }
    }
        
    else
            try {
            Parent root1 = FXMLLoader.load(getClass().getResource("qst.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            } catch (Exception e) {
            System.err.println(e.getMessage());
            }
    
    }
    
    
    
    @FXML
    void back(ActionEvent event)
    {
         try {
            Parent root1 = FXMLLoader.load(getClass().getResource("modeSpecifique.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.show();
           ((Node)(event.getSource())).getScene().getWindow().hide();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       // ((Node)(event.getSource())).getScene().getWindow().hide();
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
        
    score.setText(" Score: " + dao.getScoreLang(U));

    }    
    
}
