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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class CongratsController implements Initializable {
    
user U=new user();
TranslateTransition T=new TranslateTransition();
TranslateTransition T2=new TranslateTransition();
//TranslateTransition T3=new TranslateTransition();
TranslateTransition T4=new TranslateTransition();
TranslateTransition T5=new TranslateTransition();
ScaleTransition T3 = new ScaleTransition();
 @FXML
    private ImageView im;
 @FXML
 private ImageView feu;
 
  @FXML
    private Label F;
  
  @FXML
    private Button S;
  
  @FXML
    private Button V;

  String SS;
  
    /**
     * Initializes the controller class.
     */
  
      @FXML
    void men(ActionEvent event) {
   
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
 void suivant(ActionEvent event)
 {
      try {
        Parent root = FXMLLoader.load(getClass().getResource("qst.fxml"));   
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
        catch (IOException ex) {
                Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
            } 
 }
 
    @FXML
    void tomap(ActionEvent event) {
        
         if(U.getM().equals("JAVA")){
             //System.out.println(" SSSSSSSSSSSSSSS "+U.getM());
        try {
        Parent root = FXMLLoader.load(getClass().getResource("mapjava.fxml"));   
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();


        } catch (IOException ex) {
        Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }
     
        if(U.getM().equals("JS")){
           
        try {
        Parent root = FXMLLoader.load(getClass().getResource("MapJS.fxml"));   
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();


        } catch (IOException ex) {
        Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }
         
          
     else    if(U.getM().equals("C")){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("MapC.fxml"));   
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();


        } catch (IOException ex) {
        Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }
        
     else if(U.getM().equals("C++")){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("MapCPP.fxml"));   
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        

        } catch (IOException ex) {
        Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
               }
        
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
        

        S.setVisible(false);
        V.setVisible(false);
        F.setVisible(false);
         Image I=new Image(U.getAvatar());
        im.setImage(I);
        System.out.println(U.getAvatar());
      
        im.setVisible(true);
       
        
  T.setDuration(Duration.seconds(5));
  T2.setDuration(Duration.seconds(5));

       T.setToY(-800);
       T2.setToY(-800);
       T.setNode(im);
        T2.setNode(feu);
    
        F.setVisible(true);
        
        
    

       T3.setDuration(Duration.seconds(5));
       T3.setToY(35);
       T3.setToX(45);
       T3.setNode(F);

        
       T4.setDuration(Duration.seconds(1));
       T5.setDuration(Duration.seconds(1));
     
       T4.setToY(-200);
       T5.setToY(-200);
       T4.setNode(S);
       T5.setNode(V);
     
       ParallelTransition p = new ParallelTransition(T, T2,T3);
       ParallelTransition p1 ;
     
       
          if(!U.getM().equals("ALEATOIRE") && !U.getM().equals("General"))
     {
         
          qst_controller Qs=new qst_controller();
           
         System.out.println(U.getNbqst());
    if( Qs.getNb()==14)
          {
              System.out.println("suis je le dernier??");
            V.setVisible(true);
            p1 = new ParallelTransition(T4, T5); 
       
            SequentialTransition seqT= new SequentialTransition(p,  p1);
            seqT.play();
          }
            else
          {
              System.out.println(" hna??");
              S.setVisible(true);
              V.setVisible(true);
        p1 = new ParallelTransition(T4, T5); 
       
       SequentialTransition seqT= new SequentialTransition(p,  p1);
     seqT.play();
         
    
}
     }
          else if (U.getM().equals("General"))
          {
              S.setText("Rejouer");
              S.setVisible(true);
          p1 = new ParallelTransition(T4, T5); 
       
       SequentialTransition seqT= new SequentialTransition(p,  p1);
     seqT.play();
          }
          
          else
          {
               p1 = new ParallelTransition(T4, T5); 
       
       SequentialTransition seqT= new SequentialTransition(p,  p1);
     seqT.play();
          }
               
    }
}