package formateur.gestionQuiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.GestionClasses;

import java.net.URL;
import java.util.ResourceBundle;

public class QuizNonValide implements Initializable
{
    int i=0;
    @FXML
    private Label nom;
    @FXML
    private Label first;
    @FXML
    private Label second;
    @FXML
    private Label third;
    int j=GestionClasses.listQuiz.size();
    int k;
    int n=0;
    public void loadCompte(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionApprenants/CompteApp.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }


    public void initialize(URL location, ResourceBundle resources) {

        nom.setText((String) GestionClasses.getO());
        if(j%3==0)
        {
            k=j/3;
        }
        else
        {
            k=(j-j%3)/3+1;
        }
        n=1;
        if(j>=3 )
            i=3;
        else
            i=j;
        if(i>=1 )
        {

            first.setText(GestionClasses.listQuiz.get(0).getNom());

        }

        if(i>=2)
        {

           second.setText(GestionClasses.listQuiz.get(1).getNom());

        }
        if(i==3)
        {
            third.setText(GestionClasses.listQuiz.get(2).getNom());


        }


    }

    @FXML  public void loadNotion(ActionEvent event) throws Exception
    {
        String path;
        if(GestionClasses.getFirst()==false)
            path="../gestionNotions/ajout/listeNotion.fxml";
        else
        {
            path="../gestionNotions/ajout/ajoutNotion.fxml";
        }
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(path));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    @FXML public void loadAccueil(ActionEvent event) throws  Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../formateurCompte/Accueil.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    @FXML
    public void suivant(ActionEvent event) throws Exception
    {
        if(n<k )
        {
            if(j-n*3>=1 )
            {
                first.setText(GestionClasses.listQuiz.get(n*3).getNom());


            }

            if(j-n*3>=2)
            {
                second.setText(GestionClasses.listQuiz.get(n*3+1).getNom());


            }
            else
            {
                second.setText("");


            }
            if(j-n*3>=3)
            {

                first.setText(GestionClasses.listQuiz.get(n*3+2).getNom());


            }
            else
            {
                third.setText("");

            }
            n++;

        }
    }
    @FXML
    public void precedent(ActionEvent event) throws Exception
    {
        if(n>1)
        {
            n--;
            first.setText(GestionClasses.listQuiz.get((n-1)*3).getNom());
            second.setText(GestionClasses.listQuiz.get((n-1)*3+1).getNom());
            third.setText(GestionClasses.listQuiz.get((n-1)*3+2).getNom());

        }
    }
    @FXML
    public void afficherQuiz(ActionEvent event ) throws Exception
    {
        Button btn = (Button) event.getSource();
        String id= btn.getId();
        Boolean existe= false;
        if(id.compareTo("btnF")==0)
        {
            GestionClasses.quiz=GestionClasses.listQuiz.get((n-1)*3);
            existe=true;
        }
        else
        {
            if (id.compareTo("btnS")==0 && (n-1)*3+2<=j)
            {
                GestionClasses.quiz=GestionClasses.listQuiz.get((n-1)*3+1);
                existe=true;
            }
            else
            {
                if (id.compareTo("btnT")==0 && (n-1)*3+3<=j)
                {
                    GestionClasses.quiz=GestionClasses.listQuiz.get((n-1)*3+2);
                    existe=true;
                }
            }
        }
        if(existe)
        {
            GestionClasses.setStage((Stage) ((Node) event.getSource()).getScene().getWindow());
            // affichage de la notion choisie
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../gestionQuiz/afficherQuiz.fxml"));
            primaryStage.centerOnScreen();
            primaryStage.setScene(new Scene(root, 610, 540));
            primaryStage.show();
        }
    }
    public void retour(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccueilQuiz.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
}
