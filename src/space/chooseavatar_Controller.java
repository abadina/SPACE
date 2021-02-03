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
 *
 * @author YOUSSEF
 */
public  class chooseavatar_Controller implements Initializable {
   user U=new user();
   DAOUSER dao=new DAOUSER();
     private static int av=0;
    @FXML
    private Label lab1;
    @FXML
    private Label lab2;
    @FXML
    private Label lab3;
    @FXML
    private Label lab4;
    

    @FXML
        void CLICK(ActionEvent event) {

    try{
        /*
	FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("infolan.fxml"));
	Parent root1=(Parent) FXMLLoader.load();
	Stage stage = new Stage();
	stage.setScene(new Scene(root1));
	stage.show();*/
        U.setAvatar("space/Ressources/avatar"+av+".png");
     dao.Updateavatar(U);
     try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }
        Parent root = FXMLLoader.load(getClass().getResource("men.fxml"));
        Scene scene = new Scene(root);
       // Stage stage= new Stage();
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
}

catch (Exception e)
{
	System.err.println(e.getMessage());
}
    
        
}  
     
        
        
    @FXML
    private void AV1 (ActionEvent event) 
    {
        if(av==0)
        {lab1.setText("VOTRE AVATAR!");
        av=1;
        }
    
   if (av==2)
    {
        lab2.setText(" ");
        lab1.setText("VOTRE AVATAR!");
        av=1;
    }
     if(av==3)
    {
         lab3.setText(" ");
        lab1.setText("VOTRE AVATAR!");
        av=1;
    }
     if (av==4)
    {
        lab4.setText(" ");
        lab1.setText("VOTRE AVATAR!");
        av=1;
    }
    
     
    }
        
    
     @FXML
    private void AV2 (ActionEvent event) 
    {
     
    if(av==0)
    {lab2.setText("VOTRE AVATAR!");
    av=2;
    }
    
     if (av==1)
    {
        lab1.setText(" ");
        lab2.setText("VOTRE AVATAR!");
        av=2;
    }
     if(av==3)
    {
         lab3.setText(" ");
        lab2.setText("VOTRE AVATAR!");
        av=2;
    }
     if (av==4)
    {
        lab4.setText(" ");
        lab2.setText("VOTRE AVATAR!");
        av=2;
    }
     
    
    }
     @FXML
    private void AV3 (ActionEvent event) 
    {   
        if(av==0)
        {lab3.setText("VOTRE AVATAR!");
        av=3;
        }
     if (av==2)
    {
        lab2.setText(" ");
        lab3.setText("VOTRE AVATAR!");
        av=3;
    }
     if(av==1)
    {
        lab1.setText(" ");
        lab3.setText("VOTRE AVATAR!");
        av=3;
    }
     if (av==4)
    {
        lab4.setText(" ");
        lab3.setText("VOTRE AVATAR!");
        av=3;
    }
     
  
    }
   
    
     @FXML
    private void AV4 (ActionEvent event) 
    {
        if(av==0)
        {
        lab4.setText("VOTRE AVATAR!");
        av=4;
        }
    if (av==2)
    {
        lab2.setText(" ");
        lab4.setText("VOTRE AVATAR!");
        av=4;
    }
    if(av==3)
    {
         lab3.setText("  ");
        lab4.setText("VOTRE AVATAR!");
        av=4;
    }
     if (av==1)
    {
        lab1.setText("");
        lab4.setText("VOTRE AVATAR!");
        av=4;
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
   }
    
   }

