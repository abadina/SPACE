/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

/**
 *
 * @author DELL
 */

import java.util.*;




import java.io.*;




/** @pdOid 4928da78-3e68-4c77-b22c-dbd5a0e74597 */
public class user implements Serializable {
   private String username;
   private String password;
   private String email;
   private int authentification;
   private String avatar="space/Ressources/avatar1.png";
   private int score;
   private String m;
   public java.util.Collection<Mode> mode;
 private int nbqst;
 private int Rec=0;

    public int getNbqst() {
        return nbqst;
    }

    public void setNbqst(int nbqst) {
        this.nbqst = nbqst;
    }
   
    public user(){}
    
   public int s_inscrire(String username,String password,String email,String avatar) {
       
      //checker f base de donnees
      //if not exist
      this.username=username;
      this.email=email;
      this.password=password;
      this.score=0;
      this.authentification=1;
      this.avatar=avatar;
      return 1;
      //else 
       //if email existe
        //sout mail deja existe
       //else
        //sout username existant
       //return 0;
   }
   
   public int s_authentifier(String username,String password) {
      
    //checker f base de donnees
        //if yes
            if (authentification ==0)
            { this.username=username;
        this.password=password;
       // this.score=base de donnees;
       // this.avatar=base de donnees;
       authentification=1;
      return 1;}
            
            else
            {  System.out.println("vous etes deja authentifié");
            return 0;}
            
        //else
        //sout smaaa7lna mshi tsejel
        //return 0;
   }
   
   public int seDeconnecter() {
      authentification=0;//rederiger vers page 1
      return 0;
   }
   
   
   
   
   public String choisiravatar() {
       if(authentification ==1)
       {
           //choisir avatar update base de donnees 
       }
      // TODO: implement
      return null;
   }
   
   public int getscore() {
      // TODO: implement
      return score;
   }
   
   
   public java.util.Collection<Mode> getMode() {
      if (mode == null)
         mode = new java.util.HashSet<Mode>();
      return mode;
   }
   
   public java.util.Iterator getIteratorMode() {
      if (mode == null)
         mode = new java.util.HashSet<Mode>();
      return mode.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMode */
   public void setMode(java.util.Collection<Mode> newMode) {
      removeAllMode();
      for (java.util.Iterator iter = newMode.iterator(); iter.hasNext();)
         addMode((Mode)iter.next());
   }
   
   public void addMode(Mode newMode) {
      if (newMode == null)
         return;
      if (this.mode == null)
         this.mode = new java.util.HashSet<Mode>();
      if (!this.mode.contains(newMode))
         this.mode.add(newMode);
   }
   

   public void removeMode(Mode oldMode) {
      if (oldMode == null)
         return;
      if (this.mode != null)
         if (this.mode.contains(oldMode))
            this.mode.remove(oldMode);
   }
   
 
   public void removeAllMode() {
      if (mode != null)
         mode.clear();
   }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAuthentification() {
        return authentification;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthentification(int authentification) {
        this.authentification = authentification;
    }

    public void setScore(int score) {
        this.score = score;
    }

//    public static user getInstance() {
//        return instance;
//    }
//
//    public void setN(int n) {
//        this.n = n;
//    }
//
//   
//   

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public int getRec() {
        return Rec;
    }

    public void setRec(int Rec) {
        this.Rec = Rec;
    }
   
   

}