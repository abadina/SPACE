package space;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;
/**
 *
 * @author YOUSSEF
 */
public class modesController implements Initializable{
private user U=new user();
S Sp=new S();
@FXML
    private Button mg;

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
    
    
    @FXML
    void modespe(ActionEvent event) {
      qst_controller Qs=new qst_controller();
           Qs.setNb(0);
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
    System.out.println("erreur mode specifiiiiiiiiiiiiiiii");
}
    
    }
    
     @FXML
    void modeG(ActionEvent event) {
            qst_controller Qs=new qst_controller();
           Qs.setNb(0);
           U.setNbqst(0);
     U.setM("General");


     SerialiserU();
     /*
           try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }  */
   
          try{
	Parent root = FXMLLoader.load(getClass().getResource("qst.fxml"));
        Scene scene = new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
         mg.getScene().getWindow().hide();
               
}
          catch (Exception e)
{
    System.out.println("erreur affichage de question");
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
       
       
              
     
       
       
//       
//        if(U.getRec()==1)
//{ 
//    Sp.Recon();
//    
//    long startTime = System.currentTimeMillis();
//   
//    while (true) {
//      long estimatedTime = System.currentTimeMillis() - startTime;
//      if (estimatedTime > 60000) { // 60 seconds
//        System.out.println("Stop speaking.");
//        break;
//      }
//    }
//        System.out.println("WAAAAAAA");
// 
//       String R=Sp.getT();
//       
//       if(R.contains("g"))
//    {    Sp.Recoff();
//        System.out.println("GEEN");
//        U.setM("General");
//    SerialiserU();
//   // Sp.Recoff();
//
//        Load("qst.fxml");
//    }
//    else if(R.contains("sp"))
//    {
//        Sp.Recoff();
//     
//        Load("Mode.fxml");
//       
// }}
//



if(U.getRec()==1)
 {   Sp.Recon();
     PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(16));
    
     pt.setOnFinished(event->{
         
     
     
            String R=Sp.getT();
         System.out.println("PT");
          
    if(R.contains("g"))
    {    Sp.Recoff();
         U.setRec(0);
        System.out.println("GEEN");
        U.setM("General");
    SerialiserU();
   // Sp.Recoff();
   mg.getScene().getWindow().hide();   
   Load("qst.fxml");
        
    }
    else if(R.contains("sp"))
    { U.setRec(0);
        Sp.Recoff();
         mg.getScene().getWindow().hide();
  Load("Mode.fxml");
    }
    else
        Sp.Recoff();
  
                    } );
       
   //load.getScene().getWindow().hide();
    
    pt.play(); 
    
 }
    

}  
 
    
}
