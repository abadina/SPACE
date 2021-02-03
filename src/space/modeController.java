/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

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
import connexion.*;
import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
/**
 *
 * @author YOUSSEF
 */
public class modeController implements Initializable{
      
    DAOUSER dao=new DAOUSER();
    user U=new user();
       S Sp=new S();
    private int z;
    @FXML
    private Label textnb;

    @FXML
    private Label LOST;
    
    @FXML
    private Button CL;

    @FXML
    private TextField inputnb;
    
    @FXML
    private Button V;
        
    @FXML
    private Button al;
    
      @FXML
    private Label exep;

    @FXML
    void menu(ActionEvent event) {
   
          try{
	Parent root = FXMLLoader.load(getClass().getResource("modes.fxml"));
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
    void getnb(ActionEvent event) {
           // System.out.println("BBBBBBBBBBBBBBBBBBBBB:");
         //  System.out.println());
         //  z=Integer.parseInt(inputnb.getText());
          
           
     
    }
    
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
    void modeale(ActionEvent event) {
        
      
           
           
       try{

        CL.setVisible(false);
        inputnb.setVisible(true);
        textnb.setVisible(true);   
        V.setVisible(true);
        al.setVisible(false);
        inputnb.setPromptText("exemple. 15");
       
           
        }
          catch (Exception e)
{
	System.err.println(e.getMessage());
}
    
    }
    
    @FXML
    void valider(ActionEvent event) {
           // U.setNbqst(z);
          //System.out.println("NOMBRE!"+inputnb.getText());
         //  System.out.println(z);
           U.setM("ALEATOIRE");
           z=Integer.parseInt(inputnb.getText());
           U.setNbqst(z);
          if(z>81)
          { exep.setVisible(true);
          
          }
          else{
              try {
                         FileOutputStream fs = new FileOutputStream("user.ser");
                         ObjectOutputStream os = new ObjectOutputStream(fs);
                         os.writeObject(U); 
                         os.close();
                } catch (Exception e) { 
                                System.out.println("ERREEUUUUUR"); 
                }
          try{
              
	Parent root = FXMLLoader.load(getClass().getResource("qstale.fxml"));
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
    }
    
    
     @FXML
    void spec(ActionEvent event) {
   
          try{
	Parent root = FXMLLoader.load(getClass().getResource("modeSpecifique.fxml"));
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
    void para(ActionEvent event) {
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
            
         textnb.setVisible(false);
         inputnb.setVisible(false);
         V.setVisible(false);
         exep.setVisible(false);
             LOST.setVisible(false);
       
 
//           z=Integer.parseInt(inputnb.getText());
//           U.setNbqst(z);
      if(U.getRec()==1)
 {   Sp.Recon();
     PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(16));
    
     pt.setOnFinished(event->{
         
     
     
            String R=Sp.getT();
         System.out.println("PT");
          
    if(R.contains("lan"))
    {    Sp.Recoff();
         U.setRec(0);

   V.getScene().getWindow().hide();   
   Load("modeSpecifique.fxml");
        
    }
    else if(R.contains("Alea"))
    { U.setRec(0);
        Sp.Recoff();
         V.getScene().getWindow().hide();
         U.setM("ALEATOIRE");
         SerialiserU();
  Load("qst.fxml");
  
    }
    else
        Sp.Recoff();
  
                    } );
       
   //load.getScene().getWindow().hide();
    
    pt.play(); 
    
 }  
       
    }
    
}


 
