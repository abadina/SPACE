/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import connexion.user;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;



     
    

/**
 * FXML Controller class
 *
 * @author YOUSSEF
 */
public class GAMEOVERController implements Initializable {
     
user U=new user();
TranslateTransition T=new TranslateTransition();
TranslateTransition T2=new TranslateTransition();
TranslateTransition T4=new TranslateTransition();
TranslateTransition T5=new TranslateTransition();
ScaleTransition T3 = new ScaleTransition();
    
        @FXML
    private Button RJ;
        @FXML
    private Label go;
    @FXML
    private ImageView im;
    @FXML
    private ImageView feu;
 
     @FXML
    private ImageView exp;

 
     @FXML
    void menu(ActionEvent event) {
     
           qst_controller Qs=new qst_controller();
           Qs.setNb(0);
           
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
 void rejouer(ActionEvent event)
 {
 
             
     
     Parent root=null;
      
     if(U.getM().equals("JAVA"))
     {
 try {
       root = FXMLLoader.load(getClass().getResource("mapjava.fxml"));   

            } 
 catch (IOException ex) {
 Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
  
     else  if(U.getM().equals("C"))
     {
 try {
     
     root = FXMLLoader.load(getClass().getResource("MapC.fxml"));   

            } 
 catch (IOException ex) {
 Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
         else  if(U.getM().equals("C++"))
     {
 try {
       root = FXMLLoader.load(getClass().getResource("MapCPP.fxml"));   

            } 
 catch (IOException ex) {
 Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
     
          else if(U.getM().equals("JS"))
     {
 try {
       root = FXMLLoader.load(getClass().getResource("MapJS.fxml"));   

            } 
 catch (IOException ex) {
 Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
          else if(U.getM().equals("General"))
     {
 try {     qst_controller Qs=new qst_controller();
           Qs.setNb(0);
       root = FXMLLoader.load(getClass().getResource("modes.fxml"));   

            } 
 catch (IOException ex) {
 Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
             else if(U.getM().equals("ALEATOIRE"))
     {
 try {     qst_controller Qs=new qst_controller();
           Qs.setNb(0);
       root = FXMLLoader.load(getClass().getResource("modes.fxml"));   

            } 
 catch (IOException ex) {
 Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
     
     
      Scene scene = new Scene(root);
 Stage stage=new Stage();
 stage.setScene(scene);
 stage.show();
((Node)(event.getSource())).getScene().getWindow().hide();
           
 }
 
    
    
    /**
     * Initializes the controller class.
     */
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
        im.setImage(I);

        RJ.setVisible(false);
        feu.setVisible(true);
        RJ.setVisible(false);   
        im.setVisible(true);

        
           T.setDuration(Duration.seconds(3));
           T2.setDuration(Duration.seconds(3));

       
               im.setRotate(90);    
               feu.setRotate(90);    

       T.setToY(700);
       T2.setToY(700);
       T.setToX(700);
       T2.setToX(700);
       T.setNode(im);
       T2.setNode(feu);
   ParallelTransition p = new ParallelTransition(T, T2);
         
       go.setVisible(true);
       T3.setDuration(Duration.seconds(2));
       T3.setToY(35);
       T3.setToX(45);
       T3.setNode(go);  
      // T3.play();
      
      T4.setDuration(Duration.seconds(2));
      RJ.setVisible(true);
      T4.setToY(-180);
       T4.setNode(RJ);
    ParallelTransition p1 = new ParallelTransition(T3,T4);
        
  
    SequentialTransition seqT= new SequentialTransition(p,  p1);
    seqT.play();

     
     
     
     
   
            }
}
    
    

