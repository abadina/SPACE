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

/** @pdOid e7ccf38b-3ea2-4b89-9961-526a9d9b2742 */
public class Question {
   /** @pdOid ac5c5c70-dde9-419f-ac49-93c595772e40 */
   private String texte;
   /** @pdOid 71eebf27-1189-4062-b177-ac5a650aa0f2 */
   private int niveau;
   /** @pdOid 970683b1-40fb-4383-a2c4-a65dbd06f029 */
   private String choix1;
   /** @pdOid 3628f422-ca9b-4b31-8df5-562db54d1758 */
   private String choix2;
   /** @pdOid b85de854-9920-446f-92c4-3984b3167965 */
   private String choix3;
   /** @pdOid 819af264-7984-4509-b31e-9a0e8790aaa4 */
   private int rep;
   private int verifier;

    public int getVerifier() {
        return verifier;
    }

    public void setVerifier(int verifier) {
        this.verifier = verifier;
    }

   /** @pdOid 41cc8933-ab60-47e7-9d1b-7c74225c7845 */
   public int repondre() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid cb24f9e5-c9b2-49f8-9bb8-06f601ab0133 */
   public String getchoix1() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 2c07cf99-e1cc-4141-b4f3-ca958ffe24a4 */
   public String getchoix2() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 44d18bca-8947-4f24-989d-1cf5b953c536 */
   public String getchoix3() {
      // TODO: implement
      return null;
   }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setChoix1(String choix1) {
        this.choix1 = choix1;
    }

    public void setChoix2(String choix2) {
        this.choix2 = choix2;
    }

    public void setChoix3(String choix3) {
        this.choix3 = choix3;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public String getTexte() {
        return texte;
    }

    public int getNiveau() {
        return niveau;
    }

    public String getChoix1() {
        return choix1;
    }

    public String getChoix2() {
        return choix2;
    }

    public String getChoix3() {
        return choix3;
    }

    public int getRep() {
        return rep;
    }
   
   

}
