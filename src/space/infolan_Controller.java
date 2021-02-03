/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;
import connexion.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author YOUSSEF
 */
public class infolan_Controller implements Initializable {
    private DAOUSER dao=new DAOUSER();
    user U=new user();
     @FXML
    private ImageView logo;

    @FXML
    private Label Langage;

    @FXML
    private Text info;
    @FXML
    void SV(ActionEvent event) {
   
          try{
	Parent root = FXMLLoader.load(getClass().getResource("SaviezVous.fxml"));
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
       dao.getLangage(U.getM());
      info.setText(dao.getLang().getDescription());
      Langage.setText(U.getM());
     
     
          Image I=new Image(dao.getLang().getLogo());
        ImageView i=new ImageView(I);
        logo.setImage(I);
     
      
      
    }     

    
}

