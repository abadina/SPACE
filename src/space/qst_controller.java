    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package space;
    import connexion.*;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.net.URL;
    import java.util.ResourceBundle;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javafx.animation.PauseTransition;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Label;
    import javafx.scene.control.RadioButton;
    import javafx.scene.control.ToggleGroup;
    import javafx.scene.text.Text;
    import javafx.stage.Stage;
    import javafx.scene.control.Toggle;
    import javafx.scene.control.ToggleGroup;
    import javafx.beans.value.ChangeListener;
    import javafx.beans.value.ObservableValue;
    import javafx.scene.control.ToggleButton;
    import javafx.util.Duration;


    /**
     *
     * @author YOUSSEF
     */
    public class qst_controller implements Initializable{
        DAOUSER dao=new DAOUSER();
        user U=new user();

        @FXML
        private ToggleGroup group1;

        @FXML
        private Label score;

        @FXML
        private RadioButton c3;

        @FXML
        private Label title;

        @FXML
        private Text qst;

        @FXML
        private RadioButton c1;

        @FXML
        private RadioButton c2;

        @FXML
        private Label c;

        S Sp=new S();
        int a;
        int b=0;
        public static int sc=0;
        public  static int i=1;
        private static int nb=0;
        private int n;
        String T="";
        Question qs=new Question();

        public static void setNb(int nb) {
            qst_controller.nb = nb;
        }

        private int v=0;


    private int choix()
    {int v=0;
     if(U.getRec()==1)
    { 
       String R=Sp.getT();
        if(R.contains("un")||R.contains("1"))
        {
            v=1;
        }
        else if(R.contains("de")||R.contains("2"))
        {
            v=2;
        }
        else if(R.contains("trois")||R.contains("3"))
        {
            v=3;
        }
       // if (R.contains("suivant"))
       //     next();
        Sp.Recoff();
    }
    else{
           if(c1.isSelected())
                      {    v=1; 
                      } 
                      else if(c2.isSelected()){
                          v=2;
                      }
                    else if(c3.isSelected()) {v=3;}
    }
           return v;
    }

    private void verifier()
    {
        //System.out.println(v);
       // System.out.println("b="+b);
                      if(v==dao.getMo().getQuestion().get(nb).getRep())
                      {
                      U.setScore(dao.getScoreLang(U));
                      int s=U.getscore();
                      s=s+5;
                      sc=sc+5;
                      U.setScore(s);
                      SerialiserU();
                      dao.updateChoisir(U);
                      b=1;
    }}

    private void SerialiserU()
    {
             try {
                             FileOutputStream fs = new FileOutputStream("user.ser");
                             ObjectOutputStream os = new ObjectOutputStream(fs);
                             os.writeObject(U); 
                             os.close();
                          } catch (Exception e) { 
                                    System.out.println("ERREEUUUUUR"); 
                          }
    }
    //
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

        @FXML
        void showres(ActionEvent event) {
       showres();

        }

        private void showres ()
        {
            int a;
       b=1;
       String S;
    a=dao.getMo().getQuestion().get(nb).getRep();
    v=choix();

    if(a==1)
    {S= dao.getMo().getQuestion().get(nb).getChoix1();
    c1.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
            if(v==2)
                c2.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            if(v==3)
                c3.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");

    }
    else if(a==2)
    {
       S= dao.getMo().getQuestion().get(nb).getChoix2();
       c2.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
                 if(v==1)
                c1.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            if(v==3)
                c3.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
    }
        else if(a==3){
       S= dao.getMo().getQuestion().get(nb).getChoix3();
       c3.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
                     if(v==2)
                c2.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            if(v==1)
                c1.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
    }


                      if(v==dao.getMo().getQuestion().get(nb).getRep())
                      {
                      if(dao.getMo().getQuestion().get(nb).getVerifier() !=1)
                      {
                          U.setScore(dao.getScoreLang(U));

                      int s=U.getscore();
                      s=s+5;
                      sc=sc+5;
                      U.setScore(s);
                      dao.setScoreLang(U); 
                      SerialiserU();
                      dao.updateChoisir(U); 
                      }

                   }
        }

         @FXML
        void next(ActionEvent event) {

                 next();
    }

        private void next()
        {

                   v=choix();
                       if(b==0)
                   {
                      verifier();
                   }


      if(nb<(n-1))
                { nb++;
                if(!(U.getM().equals("General"))){
                if(nb==5 || nb==10  )
                        {

                            if(sc>=15)
                            { sc=0;

                            Load("congrats.fxml");
                            qst.getScene().getWindow().hide();
                            }
                            else 
                            {  

                              Load("GAMEOVER.fxml");
                              qst.getScene().getWindow().hide();
                            }
                        }
            else{
            Load("qst.fxml");
            c1.getScene().getWindow().hide();
              }

        }

         else
     {
         Load("qst.fxml");
         c1.getScene().getWindow().hide();
     }
            }
     else if(U.getM().equals("General") && nb==18)
                        {
                          if(sc>=45)
                         Load("congrats.fxml");  

                          else
                         Load("GAMEOVER.fxml");        
            nb=0;


             c1.getScene().getWindow().hide();

                        }

     else{ 
          Parent root=null;
        if(sc>=15)
        {
           Load("congrats.fxml");
        }
        else
            Load("GAMEOVER.fxml"); 

        U.setNbqst(nb);
        SerialiserU();
     nb=0;

     Scene scene = new Scene(root);
     Stage stage=new Stage();
     stage.setScene(scene);
     stage.show();
    qst.getScene().getWindow().hide();
     }

        }


          @Override
      public void initialize(URL location, ResourceBundle resources) {
                    b=0;

          try {
             FileInputStream fis = new FileInputStream("user.ser");
             ObjectInputStream ois = new ObjectInputStream(fis);
             U = (user) ois.readObject(); 
             ois.close();
          } catch (Exception e) { 
             e.printStackTrace(); 
          }

            if(U.getNbqst()!=0) 
         { 
           title.setText(U.getM());
           dao.getquestion(U.getM());
           n=dao.getMo().getQuestion().size();
           nb=U.getNbqst()-1;
           qst.setText(dao.getMo().getQuestion().get(nb).getTexte());
           c1.setText(dao.getMo().getQuestion().get(nb).getChoix1());
           c2.setText(dao.getMo().getQuestion().get(nb).getChoix2());
           c3.setText(dao.getMo().getQuestion().get(nb).getChoix3());
           U.setNbqst(0);
           score.setText(" Score: " + dao.getScoreLang(U));

            try {
                             FileOutputStream fs = new FileOutputStream("user.ser");
                             ObjectOutputStream os = new ObjectOutputStream(fs);
                             os.writeObject(U); // 3
                             os.close();
                          } catch (Exception e) { 
                                    System.out.println("ERREEUUUR"); 
                          }


         if(nb<5)
             c.setText( (nb+1) + "/" +"5" ); 
         else if (nb<10)
             c.setText( (nb+1-5) + "/" +"5" );
         else
             c.setText( (nb+1-10) + "/" +"5" );


           }

    else{ 
           //System.out.println(nb);
           title.setText(U.getM());
           dao.getquestion(U.getM());
           n=dao.getMo().getQuestion().size();
           qst.setText(dao.getMo().getQuestion().get(nb).getTexte());
           c1.setText(dao.getMo().getQuestion().get(nb).getChoix1());
           c2.setText(dao.getMo().getQuestion().get(nb).getChoix2());
           c3.setText(dao.getMo().getQuestion().get(nb).getChoix3());
           score.setText(" Score: " + dao.getScoreLang(U));

          //  System.out.println("nb = " +nb);
                     // System.out.println( " waaa getnbqst = " + U.getNbqst());


     if((U.getM().equals("General")))
           c.setText( (nb+1) + "/" +"19" );
     else{
         if(nb<5)
             c.setText( (nb+1) + "/" +"5" ); 
         else if (nb<10)
             c.setText( (nb+1-5) + "/" +"5" );
         else
             c.setText( (nb+1-10) + "/" +"5" );
     }


    } 
        if(U.getRec()==1)
    { Sp.Recon();
     PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(16));

         pt.setOnFinished(event->{
             String R=Sp.getT();

        if(R.contains("sui"))
        {    Sp.Recoff();
             next();

        }
        else if(R.contains("v"))
        { 
            Sp.Recoff();
            showres();
            nb++;
            PauseTransition pt2 = new PauseTransition();
            pt2.setDuration(Duration.seconds(5));

            pt2.setOnFinished(E->{
            qst.getScene().getWindow().hide();       
            Load("qst.fxml");
         });
         pt2.play();         
        }
        else
            Sp.Recoff();

                        } );

        pt.play(); 
    }
        }

    public static int getNb() {
        return nb;
    }
      
    }
