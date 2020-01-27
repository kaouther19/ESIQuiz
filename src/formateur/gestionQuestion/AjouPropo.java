package formateur.gestionQuestion;

import examination.Proposition;
import examination.QCM;
import examination.QCU;
import examination.QO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.GestionClasses;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;


public class AjouPropo
{
    int type = GestionClasses.getProposition() [0];
    int nbPropo = GestionClasses.getProposition() [1];
    int nbPropoJ= GestionClasses.getProposition() [2];
    int i=1;
    ArrayList<Proposition> propositions=new ArrayList<Proposition>();
    HashSet<String> propo=new HashSet<String>();
    @FXML private TextField proposition;
    @FXML private Label affichage;
    @FXML private ImageView check;
    @FXML private Button creer;
    @FXML private ImageView suivant;

    @FXML
    public void suivant(ActionEvent event) throws FileNotFoundException {
         if(type==0|| type==1)
         {

             if(nbPropoJ-i>=0)
             {
                 propositions.add(new Proposition(proposition.getText(),true));
                 proposition.setText("");
             }
             else
             {
                 propositions.add(new Proposition(proposition.getText(),false));
                 proposition.setText("");
             }
             if(nbPropoJ-i==0)
             {
                 affichage.setText("Proposition fausse");
                 affichage.setTextFill(Color.RED);
                 check.setImage(new Image(getClass().getResourceAsStream("close.png")));

             }
         }
         else
         {
             propo.add(proposition.getText());
             proposition.setText("");
         }
         i++;
         if(nbPropo-i==0)
         {
             creer.setVisible(true);
             suivant.setVisible(false);
         }
    }
    @FXML
    public void creer(ActionEvent event) throws Exception
    {
        if(type==0|| type==1)
        {
                propositions.add(new Proposition(proposition.getText(),false));
        }
        else
        {
            propo.add(proposition.getText());

        }
        if(type==0)
        {
            QCM q =new QCM(GestionClasses.getNotionCourante(),(String) GestionClasses.getO(),propositions);
            q.afficherAvecReponses();
        GestionClasses.getNotionCourante().ajouterQuestion(q);
        }
        else
        {
            if(type==1)
            {
                GestionClasses.getNotionCourante().ajouterQuestion(new QCU(GestionClasses.getNotionCourante(),(String) GestionClasses.getO(),propositions));

            }
            else
            {
                GestionClasses.getNotionCourante().ajouterQuestion(new QO(GestionClasses.getNotionCourante(),(String) GestionClasses.getO(),propo));

            }
        }
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        GestionClasses.getStage().close();
        //
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionNotions/ajout/afficherNotion.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
}
