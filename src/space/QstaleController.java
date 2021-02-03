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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static space.qst_controller.sc;

/**
 * FXML Controller class
 *
 * @author YOUSSEF
 */
public class QstaleController implements Initializable {
DAOUSER dao=new DAOUSER();
     user U=new user();
    
 private static int nb=0;
 private static int nr;
 private int  m;
 private String n;

        

//private int n;
String T="";
    @FXML
    private RadioButton c3;
     @FXML
    private Text qst;
    @FXML
    private RadioButton c1;
    @FXML
    private RadioButton c2;
    
    private int a;
        public  static int i=1;
    
    @FXML
    private Label C;

        @FXML
    private Label score;
        
    private static int sc;
    
      private int v=0;
      
         int b=0;
         
          @FXML
    void showres(ActionEvent event) {
   int a;
   b=1;
   String S;
a=dao.getMo().getQuestion().get(nb).getRep();

if(a==1)
{S= dao.getMo().getQuestion().get(nb).getChoix1();
c1.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
        if(c2.isSelected())
            c2.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
        if(c3.isSelected())
            c3.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");

}
else if(a==2)
{
   S= dao.getMo().getQuestion().get(nb).getChoix2();
   c2.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
             if(c1.isSelected())
            c1.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
        if(c3.isSelected())
            c3.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
}
else if(a==3){
   S= dao.getMo().getQuestion().get(nb).getChoix3();
   c3.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
                 if(c2.isSelected())
            c2.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
        if(c1.isSelected())
            c1.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
}
    
    
    
                if(c1.isSelected())
                  {    v=1; 
                  } 
                  else if(c2.isSelected()){
                      v=2;
                  }
                  else if(c3.isSelected()) {v=3;}
              
                  
                  System.out.println("rep"+dao.getMo().getQuestion().get(nb).getRep());
                  if(v==dao.getMo().getQuestion().get(nb).getRep())
                  {System.out.println("rep"+dao.getMo().getQuestion().get(nb).getRep());
                  if(dao.getMo().getQuestion().get(nb).getVerifier() !=1)
                  {U.setScore(dao.getScoreLang(U));
                  
                  int s=U.getscore();
                  s=s+5;
                  sc=sc+5;
                         U.setScore(s);
                      
                            try {
                         FileOutputStream fs = new FileOutputStream("user.ser");
                         ObjectOutputStream os = new ObjectOutputStream(fs);
                         os.writeObject(U); // 3
                         os.close();
                      } catch (Exception e) { 
                                System.out.println("ERREEUUUUUR"); 
                      }

                      dao.updateChoisir(U); 
                    //  dao.valider(U);
                  }
                  
               }
    
    }
         
     @FXML      
    void next(ActionEvent event) {


        System.out.println("nbre de qst souhaitée  "+a+"\n" );

                  
                  if(c1.isSelected())
                  {    v=1; 
                  } 
                  else if(c2.isSelected()){
                      v=2;
                  }
                  else if(c3.isSelected()) {v=3;}
              
                   if(b==0)
               {
                  System.out.println("rep"+dao.getMo().getQuestion().get(nb).getRep());
                  if(v==dao.getMo().getQuestion().get(nb).getRep())
                  {System.out.println("rep"+dao.getMo().getQuestion().get(nb).getRep());
               
                  U.setScore(dao.getScoreLang(U));
                  
                  int s=U.getscore();
                  s=s+5;
                  sc=sc+5;
                         U.setScore(s);
                      
                            try {
                         FileOutputStream fs = new FileOutputStream("user.ser");
                         ObjectOutputStream os = new ObjectOutputStream(fs);
                         os.writeObject(U); // 3
                         os.close();
                      } catch (Exception e) { 
                                System.out.println("ERREEUUUUUR"); 
                      }

                      dao.updateChoisir(U); 
                   
                  
                  }
               }
                  
        if(nb<(a-1))
                     { nb++;    
                            System.out.println(" nb= " +nb +"\n");

                       int r = 0 + (int)(Math.random() * ((m - 0) + 1));
                     System.out.println("num de la qst par random : "+r+"\n");


                try {
                    Parent root = FXMLLoader.load(getClass().getResource("qstale.fxml"));   
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.show();
                     ((Node)(event.getSource())).getScene().getWindow().hide();

                } catch (IOException ex) {
                    Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
                } 

                    }
        
        else{ 
            
            if(sc>=5*(a/2))
                        { try {
                            sc=0;
                    Parent root = FXMLLoader.load(getClass().getResource("congrats.fxml"));   
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
              else 
       {                 
        try {
        Parent root = FXMLLoader.load(getClass().getResource("GAMEOVER.fxml")); 
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        nb=0;

         ((Node)(event.getSource())).getScene().getWindow().hide();
         
              
           
       
         
      
    } catch (IOException ex) {
        Logger.getLogger(qst_controller.class.getName()).log(Level.SEVERE, null, ex);
    } }
         System.out.println(nb);
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
           score.setText(" Score: " + dao.getScoreLang(U));


        a=U.getNbqst();
        System.out.println(U.getNbqst());
     
        C.setText( (nb+1) + "/" + a );


        C.setVisible(true);

       dao.getquestionaleatoire();
       m=dao.getMo().getQuestion().size();
       System.out.println(" num = " +m+"\n");
        
       nr= 0 + (int)(Math.random() * ((m - 0) + 1));
       System.out.println(" nr= " +nr+"\n");

       
              
       
    while((dao.getMo().getQuestion().get(nr).getVerifier())==1)
    {
       nr= 0 + (int)(Math.random() * ((m - 0) + 1));
    }
         
       dao.getMo().getQuestion().get(nr).setVerifier(1);
       qst.setText(dao.getMo().getQuestion().get(nr).getTexte());
       c1.setText(dao.getMo().getQuestion().get(nr).getChoix1());
       c2.setText(dao.getMo().getQuestion().get(nr).getChoix2());
       c3.setText(dao.getMo().getQuestion().get(nr).getChoix3());    
       
   
    }    
    
}
