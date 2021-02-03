/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;
import connexion.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.util.Duration;
/**
 *
 * @author DELL
 */
public class menController implements Initializable{
    DAOUSER dao=new DAOUSER();
    user U=new user();
    
    @FXML
    private Button but;
    
    pdf PDF = new pdf();
//fx:id de button help dans men.fxml******
 @FXML
    private Button aide;   
       @FXML
    private AnchorPane anchorpane;
       
       
       S Sp=new S();

private void Load(String P)
{
    try {
                   
                    Parent root = FXMLLoader.load(getClass().getResource(P));   
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.show();
                    
                        } 
                    catch (IOException ex) {
                    Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    
}
private void SerialiserU()
{
         try {
                         FileOutputStream fs = new FileOutputStream("user.ser");
                         ObjectOutputStream os = new ObjectOutputStream(fs);
                         os.writeObject(U); // 3
                         os.close();
                      } catch (Exception e) { 
                                System.out.println("ERREEUUUUUR"); 
                      }
}


@FXML
    void Aide (ActionEvent event) {
                    anchorpane=new AnchorPane();
                

            
            Scene scene = new Scene(anchorpane);
            
            Stage stage=new Stage();
           
		stage.setScene(scene);
		stage.centerOnScreen();
               URL url = getClass().getResource("\\Ressources\\manual.pdf");
               File myFile = null;
    try {
        myFile = new File(url.toURI());
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
                 
                PDF.host(myFile);
    }
    
    @FXML
    void jouer(ActionEvent event) {
         if(U.getAuthentification()==1)
         
        {try {
            Parent root1 = FXMLLoader.load(getClass().getResource("modes.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.setTitle("MODES");
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
           
        
 
    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }}
    
    
    @FXML
    void langage(ActionEvent event) {
         if(U.getAuthentification()==1)
         {try {
            Parent root1 = FXMLLoader.load(getClass().getResource("SaviezVous.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
             stage1.setTitle("SAVIEZ-VOUS");
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
           
        
 
    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }}
    }
  @FXML
    void score(ActionEvent event) {
         if(U.getAuthentification()==1){
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("score.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.setTitle("SCORE");
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
           
        
 
    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }}
    }
    
  
       @FXML
    void parametre(ActionEvent event) {
         if(U.getAuthentification()==1)
         {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("parametre.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.initOwner( ((Node)(event.getSource())).getScene().getWindow());
            stage1.setScene(scene);
            stage1.setTitle("PARAMETRES");
            stage1.show();
         
    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }}
    }
    
    
    
     @FXML
    void quitter(ActionEvent event) {
         if(U.getAuthentification()==1)
         {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("login.fxml"));
            
            Scene scene = new Scene(root1);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
           
        
 
    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        U.setAuthentification(0);
        dao.deconnecter(U);
         try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }
         }
    }

    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
         FileInputStream fis = new FileInputStream("user.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         U = (user) ois.readObject(); // 4
         ois.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }
           
        qst_controller Qs=new qst_controller();
           Qs.setNb(0);
         try {
                         FileOutputStream fs = new FileOutputStream("user.ser");
                         ObjectOutputStream os = new ObjectOutputStream(fs);
                         os.writeObject(U); 
                         os.close();
                } catch (Exception e) { 
                                System.out.println("ERREEUUUUUR"); 
                }
        
        Image I=new Image(U.getAvatar());
        ImageView i=new ImageView(I);
        but.setGraphic(i);
        System.out.println(U.getAvatar());
        
        
        
        if(U.getRec()==1)
{ 
 Sp.Recon();
    
     PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(16));
    
     pt.setOnFinished(event->{
         
     
     
            String R=Sp.getT();
         System.out.println("PT");
          
    if(R.contains("jouer"))
    {    Sp.Recoff();
        System.out.println("GEEN");
        but.getScene().getWindow().hide();
        Load("modes.fxml");
    }
    else if(R.contains("vous"))
    {
        Sp.Recoff();
        but.getScene().getWindow().hide();
        Load("SaviezVous.fxml");
    }
    else if(R.contains("score"))
    {
        Sp.Recoff();
        but.getScene().getWindow().hide();
        Load("score.fxml");
    }
    else if(R.contains("deco"))
    {
        Sp.Recoff();
        U.setAuthentification(0);
        SerialiserU();
        but.getScene().getWindow().hide();
        Load("login.fxml");
    }
    else
        Sp.Recoff();
  
                    } );
       
   //load.getScene().getWindow().hide();
    
    pt.play(); 

    }
   }
    }
    

