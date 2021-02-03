/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAOUSER {
      private Connection MaCon;
      Mode Mo=new Mode();
      
     public DAOUSER()
    {
        DAO Daouser=new DAO();
        Daouser.setLogin("root");
        Daouser.setPilote("com.mysql.jdbc.Driver");
        Daouser.setURL("jdbc:mysql://localhost:3306/space_it");
        Daouser.ToConnect();
        MaCon=Daouser.getMaConnexion();
        
    }
     
    
     
     public int Create(user U)
    {
        if((checkusername(U)==0) && (checkemail(U)==0))
        {
        
         PreparedStatement S;
        try {
            S=MaCon.prepareStatement("insert into users values(?,?,?,?,?,?);");
            S.setString(1,U.getUsername());
            S.setString(2,U.getPassword());
            S.setString(3,U.getEmail());
            S.setInt(4,U.getAuthentification());
            S.setString(5,U.getAvatar());
            S.setInt(6,U.getscore());
            S.execute();
            S=MaCon.prepareStatement("insert into choisir values(?,?,?);");
            S.setString(2,U.getUsername());
            S.setString(1,"JAVA");
            S.setInt(3,0);
            S.execute();
            S.setString(1,"C");
            S.execute();
            S.setString(1,"C++");
            S.execute();
            S.setString(1,"JS");
            S.execute();
            S.setString(1,"GENERAL");
            S.execute();
            S.setString(1,"ALEATOIRE");
            S.execute();
            return 1;
            
        } catch (SQLException ex) {
            System.out.println("Pb dans req update");
        } 
       
        }
        else if ((checkusername(U)==0) && (checkemail(U)!=0))
            return 0;
        else 
            return 2;
        //erreur
     return -1;   
    }
     
      public int checkusername(user U)
    {
        int nl=-1;
         PreparedStatement S;
        try {
            S=MaCon.prepareStatement("select * from users where username=?;");
            S.setString(1,U.getUsername());
            ResultSet RS=S.executeQuery();
            RS.last(); 
            //on récupère le numéro de la ligne 
            nl = RS.getRow(); 
            //on replace le curseur avant la première ligne 
            RS.beforeFirst(); 
        } catch (SQLException ex) {
            System.out.println("Pb dans req select");
        } 
        
        return nl;
    }
      
      
        public int checkemail(user U)
    {
        int nl=-1;
         PreparedStatement S;
        try {
            S=MaCon.prepareStatement("select * from users where email=?;");
            S.setString(1,U.getEmail());
            ResultSet RS=S.executeQuery();
            RS.last(); 
            //on récupère le numéro de la ligne 
            nl = RS.getRow(); 
            //on replace le curseur avant la première ligne 
            RS.beforeFirst(); 
        } catch (SQLException ex) {
            System.out.println("Pb dans req select");
        } 
        
        return nl;
    }
        
              public int checkpassword(user U)
    {
        int nl=-1;
         PreparedStatement S;
        try {
            S=MaCon.prepareStatement("select * from users where password=?;");
            S.setString(1,U.getPassword());
            ResultSet RS=S.executeQuery();
            RS.last(); 
            //on récupère le numéro de la ligne 
            nl = RS.getRow(); 
            //on replace le curseur avant la première ligne 
            RS.beforeFirst(); 
        } catch (SQLException ex) {
            System.out.println("Pb dans req select");
        } 
        
        return nl;
    }
      
 
     
       public void Updatepassword(user U)
    {
       
        PreparedStatement S;
        try {
            //S = MaCon.createStatement();
            S=MaCon.prepareStatement("Update users set password=? where username=? ;");
            S.setString(1,U.getPassword());
            S.setString(2,U.getUsername());
            S.executeUpdate();
            System.out.println("update effectue");
            
            //S.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Pb dans req update");
        }
        
    }
       
      public void Updateavatar(user U)
    {
       
        PreparedStatement S;
        try {
            //S = MaCon.createStatement();
            S=MaCon.prepareStatement("Update users set avatar=? where username=? ;");
            S.setString(1,U.getAvatar());
            S.setString(2,U.getUsername());
            S.executeUpdate();
            System.out.println("update effectue");
            
            //S.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Pb dans req update");
        }
        
    }   
     
     public void deconnecter(user U)
     {
         PreparedStatement S;
        try {
            //S = MaCon.createStatement();
            S=MaCon.prepareStatement("Update users set authentification=? where username=? ;");
            S.setInt(1,U.getAuthentification());
            S.setString(2,U.getUsername());
            S.executeUpdate();
            System.out.println("update effectue");
            
            //S.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Pb dans req update");
        } 
     }
     
     
     public void seconnecter(user U)
     {
         PreparedStatement S;
        try {
            //S = MaCon.createStatement();
            S=MaCon.prepareStatement("Update users set authentification=? where username=? ;");
            S.setInt(1,U.getAuthentification());
            S.setString(2,U.getUsername());
            S.executeUpdate();
            System.out.println("update effectue");
            
            //S.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Pb dans req update");
        } 
     }
     
     public void getquestion(String M)
     {
        Mo.setNom(M);
        ArrayList<Question> question=new ArrayList<Question>();
//        Question q=new Question();
         PreparedStatement S;
          ResultSet RS=null;
        try {
            S=MaCon.prepareStatement("select * from question Q,estcompose E where nom=? and Q.Texte=E.Texte order by niveau;");
            S.setString(1,M);
             RS=S.executeQuery();
             int n=0;
             while(RS.next())
             {Question q=new Question();
               q.setTexte(RS.getString("texte"));
               q.setChoix1(RS.getString(3));
               q.setChoix2(RS.getString(4));
               q.setChoix3(RS.getString(5));
               q.setNiveau(RS.getInt(2));
               q.setRep(RS.getInt(6));
               q.setVerifier(RS.getInt(7));
           Mo.addQuestion(q);
             }
        
//             RS.last();
//             n=RS.getRow();
//             Mo.setNb(n);
           
        } catch (SQLException ex) {
            System.out.println("Pb dans req select");
        } 
          
           
     }
        
     
      Langage Lang=new Langage();

 public Langage getLang() {
        return Lang;
    }



       public void getLangage(String M)
     {
        Lang.setNom(M);
       
         PreparedStatement S;
          ResultSet RS=null;
        try {
            S=MaCon.prepareStatement("SELECT * FROM langage where nom=? ;");
            S.setString(1,M);
            // S.setString(2,Lang.getDescription());
             RS=S.executeQuery();
            
             RS.next();
               Lang.setDescription(RS.getString("description"));
              Lang.setLogo(RS.getString("logo"));
            // System.out.println(Lang.getDescription());
         
        } catch (SQLException ex) {
            System.out.println("Pb dans req select");
        } 
          
           
     }
       
   public user getUser(user U)
     {
       user us=new user();
      us.setUsername(U.getUsername());
      us.setPassword(U.getPassword());
//        Question q=new Question();
         PreparedStatement S;
          ResultSet RS=null;
        try {
            S=MaCon.prepareStatement("select * from users where username=? and password=?;");
            S.setString(1,U.getUsername());
            S.setString(2,U.getPassword());
             RS=S.executeQuery();
            
           RS.next();
           
            us.setAvatar(RS.getString(5));
            us.setEmail(RS.getString(3));
            us.setAuthentification(RS.getInt(4));
             us.setScore(RS.getInt(6));
          
           
        } catch (SQLException ex) {
            System.out.println("Pb dans req select");
        } 
          
          return us; 
     }
         
    
      
     public void getquestionaleatoire()
     {
          Mo.setNom("ALEATOIRE");
         ArrayList<Question> question=new ArrayList<Question>();
         PreparedStatement S;
          ResultSet RS=null;

        try {
            S=MaCon.prepareStatement("select * from question Q,estcompose E where Q.texte=E.texte and (nom='JAVA' or nom='C' or nom='C++' or nom='JS');");
             RS=S.executeQuery();
             
             while(RS.next())
             {Question q=new Question();
               q.setTexte(RS.getString("texte"));
               q.setChoix1(RS.getString(3));
               q.setChoix2(RS.getString(4));
               q.setChoix3(RS.getString(5));
           // q.setNiveau(RS.getInt(2));
            q.setRep(RS.getInt(6));
           Mo.addQuestion(q);
             }
        } catch (SQLException ex) {
            System.out.println("Pb dans req select aleatoire");
        } 
            
 }
      
       public int getScorespecifique(user U)
     {
        
         PreparedStatement S;
          ResultSet RS=null;
        try {
           
            S=MaCon.prepareStatement("SELECT score FROM choisir where (nom=? or nom=? or nom=? or nom=? )and username=?;");
            S.setString(1,"C++");
            S.setString(2,"JS");
            S.setString(3,"JAVA");
            S.setString(4,"C");
            S.setString(5,U.getUsername());
             RS=S.executeQuery();
             
              int res=0;
            while(RS.next())
            {  
               // System.out.println(RS.getInt("score"));
                res+=(RS.getInt("score"));
            }
            
            return res;
        } catch (SQLException ex) {
            System.out.println("Pb dans req SCORE");
        }  
        return 0;
     }
       
       
       
       
        public int getScoregen(user U )
     {    
        
         PreparedStatement S;
          ResultSet RS=null;
        try {
            S=MaCon.prepareStatement("SELECT score FROM choisir where nom=? and username=? ;");
            S.setString(1,"General");
            S.setString(2,U.getUsername());
             RS=S.executeQuery();
             RS.next();
            
            return(RS.getInt("score"));
             
            
        } catch (SQLException ex) {
            System.out.println("Pb dans req select");
        } 
        return 0;
          
         
     }

        public void updateChoisir( user U)
     {
        
         PreparedStatement S;
      
        try {
            S=MaCon.prepareStatement("Update choisir set score=? where username=? and nom=?;");
             S.setInt(1,U.getscore());
            S.setString(2,U.getUsername());
            S.setString(3, U.getM());
            
             S.executeUpdate();
           
            
            
        } catch (SQLException ex) {
            System.out.println("Pb dans req update");
        }  
  
     }
        public int getScoreLang(user U )
     {    
        
         PreparedStatement S;
          ResultSet RS=null;
     try {
            S=MaCon.prepareStatement("SELECT score FROM choisir where nom=? and username=? ;");

         //System.out.println(U.getM());
         //System.out.println(U.getUsername());
            S.setString(1,U.getM());
            S.setString(2,U.getUsername());

             RS=S.executeQuery();
             //RS.next();
        // System.out.println("NO PROBLEM HERE\n");
            RS.next();
         //System.out.println("NO PROBLEM HERE\n");
            return(RS.getInt("score"));
             
            
        } catch (SQLException ex) {
            System.out.println("Pb dans req select score");
        } 
        return 0;
        
        }
        
         public int setScoreLang(user U )
     {    
        
         PreparedStatement S;
          ResultSet RS=null;
        try {
            S=MaCon.prepareStatement("update choisir set score=? where nom=? and username=? ;");
            S.setInt(1, U.getscore());
            S.setString(2,U.getM());
            S.setString(3,U.getUsername());
            RS=S.executeQuery();
             //RS.next();
             
            RS.next();
            return(RS.getInt("score"));
             
            
        } catch (SQLException ex) {
            System.out.println("Pb dans req update score");
        } 
        return 0;
        
        }
        
      public void setscore(user U)
      {
         PreparedStatement S;
        try {
            //S = MaCon.createStatement();
            S=MaCon.prepareStatement("Update users set score=? where username=? ;");
            S.setInt(1,U.getscore());
            S.setString(2,U.getUsername());
            S.executeUpdate();
            System.out.println("update effectue");
            
            //S.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Pb dans req update");
        } 
     }
          
        public void valider(user U)
        {
            PreparedStatement S;
        try {
            //S = MaCon.createStatement();
            S=MaCon.prepareStatement("Update choisir set score=? where username=? ;");
            S.setInt(1,U.getscore());
            S.setString(2,U.getUsername());
            S.executeUpdate();
            System.out.println("update effectue");
            
            //S.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Pb dans req update");
        } 
        }

    public Mode getMo() {
        return Mo;
    }
    
     
}
