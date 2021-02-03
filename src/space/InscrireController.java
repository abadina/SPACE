/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;
import connexion.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * FXML Controller class
 *
 * @author Macbook Pro
 */
public class InscrireController implements Initializable {
DAOUSER dao=new DAOUSER();
user U=new user();
    /**
     * Initializes the controller class.
     */
@FXML
    private Label email;
     @FXML
    private PasswordField ps;

    @FXML
    private PasswordField cps;

    @FXML
    private TextField un;

    @FXML
    private TextField ml;

    @FXML
    private Label erre;
    public final String apikey="037a9f27186b300e9ef28d9e66334856";
    

      @FXML
    void inscrire(ActionEvent event) throws MalformedURLException, ProtocolException, IOException {
        
        U.setUsername(un.getText());
        U.setEmail(ml.getText());
        //U.setPassword((ps.getText()));
        if((dao.checkusername(U))!=0 )
        {erre.setText("Usarname existant!");
        }
        //username n'est pas existe
        else{
                if((dao.checkemail(U))!=0)
                {erre.setText("email existant!");
                }
                //mail n'est pas existe
                else
                {
                    if(ps.getText().equals(cps.getText()))
                    {
                        U.setPassword(ps.getText());
                                   
        String url = "https://apilayer.net/api/check?access_key="+apikey+"&email="+U.getEmail()+"&smtp=1&format=1";
   
   URL urlobj = new URL(url);
   
   HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();

   // optional default is GET
   con.setRequestMethod("GET");

   //add request header
   con.setRequestProperty("User-Agent", "Mozilla/17.0");

   
   BufferedReader in = new BufferedReader(
           new InputStreamReader(con.getInputStream()));
   String inputLine;
   StringBuffer response = new StringBuffer();

   while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
   }
   in.close();

   //print result
   System.out.println(response.toString());
   String inputJson=response.toString();
   ObjectMapper mapper= new ObjectMapper();
		try {
			
			JsonParser mp= mapper.readValue(inputJson,JsonParser.class);
			
			//System.out.println(mp.getScore());
                                               
                        if (mp.getScore()<0.8 && !mp.isFormat_valid()) {
                            email.setText("Email non valide!");
                            email.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");

                        }
                        else {
                            
                        dao.Create(U);
                        U.setAuthentification(1);
                        try {
         FileOutputStream fs = new FileOutputStream("user.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         os.writeObject(U); // 3
         os.close();
      } catch (Exception e) { 
         e.printStackTrace(); 
      }
                       try
                        {
                                Parent root = FXMLLoader.load(getClass().getResource("chooseavatar.fxml"));
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
                    }   }	
			
		 
                                   catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                    }
                
                       // U.setN(1);
                        
                        
                      
                    else
                    {erre.setText("Passwords non identique!");    
                    }
                }
        }
    }

  

        
    
          


//       
    
      @FXML
    void annuler(ActionEvent event) throws IOException {
    Parent root =  FXMLLoader.load(getClass().getResource("login.fxml"));
           Scene root_scene = new Scene(root);
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(root_scene);
           stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
