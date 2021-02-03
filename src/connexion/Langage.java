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

/** @pdOid da16ec59-e3a1-44d7-baa8-783f38084158 */
public class Langage {
   /** @pdOid 8ee7d4af-1fb2-489b-abb4-2f64b79e29c6 */
   private String nom;
   /** @pdOid 9f5bcd0d-c1f3-43e1-9d82-b05feafa334f */
   private String description;
   /** @pdOid b20928da-6b97-42ae-84b1-c7bd06939419 */
   private String logo;
   
   /** @pdOid f95b5c8f-48c1-4186-8121-62541287c105 */
   public String toString() {
      return null;
   }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getLogo() {
        return logo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
