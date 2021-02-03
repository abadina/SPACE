/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class DAO {
     private String Login;
    private String Pilote;
    private String URL;
    private Connection MaConnexion;
    private String Password="";
    
    
    public void ToConnect()
    {
        System.out.println("Chargement du driver... ");
        
        try {
            Class.forName(Pilote);
            System.out.println("Chargement du driver OK.");
            MaConnexion=DriverManager.getConnection(URL,Login,Password);
            System.out.println("Connexion etablie");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem de chargement du Pilote");
        } catch (SQLException ex) {
            System.out.println("Problem de connexion , Login ou URL");
        }
        
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setPilote(String Pilote) {
        this.Pilote = Pilote;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Connection getMaConnexion() {
        return MaConnexion;
    }

   
    
    
    
    

}
