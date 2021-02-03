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
/** @pdOid c26a9c66-b9af-427d-97fa-4c6c06305fcf */
public class Mode {
   /** @pdOid 7524cee5-699f-4085-a03d-b294b59c3a9b */
   private String nom;
   /** @pdOid 4cc10150-2a9e-42cc-944c-53ec28020241 */
   private int score;
   private int nb;
   /** @pdRoleInfo migr=no name=Question assc=estCompose coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public ArrayList<Question> question=new ArrayList<Question>();
   /** @pdRoleInfo migr=no name=Mode assc=contient coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public ArrayList<Mode> modeB;
   
 
   public int choisir() {
  
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public ArrayList<Question> getQuestion() {
     
      return question;
   }
   
  

   public void setQuestion(ArrayList<Question> newQuestion) {
      for (java.util.Iterator iter = newQuestion.iterator(); iter.hasNext();)
         addQuestion((Question)iter.next());
   }

   public void addQuestion(Question newQuestion) {
      if (newQuestion == null)
         return;
      if (this.question == null)
         this.question = new ArrayList<Question>();
      if (!this.question.contains(newQuestion))
         this.question.add(newQuestion);
   }


  
   public ArrayList<Mode> getModeB() {
      if (modeB == null)
         modeB = new ArrayList<Mode>();
      return modeB;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorModeB() {
      if (modeB == null)
         modeB = new ArrayList<Mode>();
      return modeB.iterator();
   }
   

   public void setModeB(ArrayList<Mode> newModeB) {
      removeAllModeB();
      for (java.util.Iterator iter = newModeB.iterator(); iter.hasNext();)
         addModeB((Mode)iter.next());
   }
   

   public void addModeB(Mode newMode) {
      if (newMode == null)
         return;
      if (this.modeB == null)
         this.modeB = new ArrayList<Mode>();
      if (!this.modeB.contains(newMode))
         this.modeB.add(newMode);
   }
   
   /** @pdGenerated default remove
     * @param oldMode */
   public void removeModeB(Mode oldMode) {
      if (oldMode == null)
         return;
      if (this.modeB != null)
         if (this.modeB.contains(oldMode))
            this.modeB.remove(oldMode);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllModeB() {
      if (modeB != null)
         modeB.clear();
   }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public String getNom() {
        return nom;
    }
    

}
