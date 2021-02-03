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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ModeSpecifiqueController implements Initializable {
private user U=new user();
    private m mde ;
    @FXML
    private Button mg;
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
    void menu(ActionEvent event) {
   
          try{
	Parent root = FXMLLoader.load(getClass().getResource("Mode.fxml"));
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
    void toqstjava(ActionEvent event) {
 try{ U.setM("JAVA");

     /*
           try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }*/
     SerialiserU();
	Parent root = FXMLLoader.load(getClass().getResource("mapjava.fxml")); 
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
    void toqstC(ActionEvent event) {
 try{  U.setM("C");
     /*
           try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }*/

     SerialiserU();
     
	Parent root = FXMLLoader.load(getClass().getResource("MapC.fxml")); 
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
    void toqstCpp(ActionEvent event) {
 try{  U.setM("C++");
         /*  try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }
     */

     SerialiserU();

	Parent root = FXMLLoader.load(getClass().getResource("MapCPP.fxml")); 
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
    void toqstJS(ActionEvent event) {
 try{
     
     U.setM("JS");
     SerialiserU();
     /*
           try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }

      */
	Parent root = FXMLLoader.load(getClass().getResource("MapJS.fxml")); 
      Scene scene = new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
        
          // System.out.println(mde.getMode());
}
          catch (Exception e)
{
	   System.out.println("prob aller js");
}

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
        
                 if(U.getRec()==1)
 {   Sp.Recon();
     PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(16));
    
     pt.setOnFinished(event->{
         
     
     
            String R=Sp.getT();
         System.out.println("PT");
          
    if(R.contains("java")|| R.contains("Java"))
    {    Sp.Recoff();
    
         U.setM("JAVA");
         SerialiserU();
   mg.getScene().getWindow().hide();   
   Load("qst.fxml");
        
    }
    else if(R.contains("js"))
    { 
        Sp.Recoff();
        U.setM("JS");
         SerialiserU();
   mg.getScene().getWindow().hide();   
   Load("qst.fxml");
    }
    
     else if(R.contains("cpp"))
    {
        Sp.Recoff();
        U.setM("C++");
       SerialiserU();
   mg.getScene().getWindow().hide();   
   Load("qst.fxml");
    }
     
      else if(R.contains("c"))
    {
        Sp.Recoff();
        U.setM("C");
      SerialiserU();
   mg.getScene().getWindow().hide();   
   Load("qst.fxml");
    }
    else
        Sp.Recoff();
  
                    } );
       
   //load.getScene().getWindow().hide();
    
    pt.play(); 
    
 }  
        // TODO
    }    
    
}
