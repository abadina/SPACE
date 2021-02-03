/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;
import connexion.*;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class StarTController implements Initializable {

@FXML
private ImageView F;
    /**
     * Initializes the controller class.
     */
     @FXML
    void nextpage(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("login.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.setTitle("WELCOME");
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    
    
}
