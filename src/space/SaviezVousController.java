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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ACER
 */
public class SaviezVousController implements Initializable {
user U=new user();
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
    void parametre(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("parametre.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.initOwner( ((Node)(event.getSource())).getScene().getWindow());
            stage1.setScene(scene);
            stage1.show();
         
    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    /**
     * Initializes the controller class.
     */
    
       @FXML
    void toinfojava(ActionEvent event) throws IOException{
        U.setM("JAVA");
        try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      } 
        
        Parent root = FXMLLoader.load(getClass().getResource("infos.fxml")); 
      Scene scene = new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    
     @FXML
    void toinfoC(ActionEvent event) throws IOException{
        U.setM("C");
        try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      } 
        
        Parent root = FXMLLoader.load(getClass().getResource("infos.fxml")); 
      Scene scene = new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
    }

     @FXML
    void toinfojs(ActionEvent event) throws IOException{
        U.setM("JS");
        try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      } 
        
        Parent root = FXMLLoader.load(getClass().getResource("infos.fxml")); 
      Scene scene = new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
     @FXML
    void toinfocpp(ActionEvent event) throws IOException{
        U.setM("C++");
        try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      } 
        
        Parent root = FXMLLoader.load(getClass().getResource("infos.fxml")); 
      Scene scene = new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
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
    }
        // TODO
    }    
    

