package formateur.gestionNotions.ajout;

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

public class AfficherNotion implements Initializable
{

    int i=0;
    @FXML
    private Label first;
    @FXML
    private Label second;
    @FXML
    private Label third;
    @FXML
    private Label notion;

    int j= GestionClasses.getNotionCourante().getQuestion().size();
    int k;
    int n=0;

    @Override

    public void initialize(URL location, ResourceBundle resources)
    {
        notion.setText(GestionClasses.getNotionCourante().getNotion());
        if(j>0)
        {
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
                first.setText(GestionClasses.getNotionCourante().getQuestion().get(0).afficherSansProp());


            }

            if(i>=2)
            {
                second.setText(GestionClasses.getNotionCourante().getQuestion().get(1).afficherSansProp());


            }
            if(i==3)
            {
                third.setText(GestionClasses.getNotionCourante().getQuestion().get(2).afficherSansProp());


            }

        }

    }

    @FXML
    public void suivant(ActionEvent event) throws Exception
    {
        if(n<k )
        {
            if(j-n*3>=1 )
            {
                first.setText((GestionClasses.getNotionCourante().getQuestion().get((n*3)).afficherSansProp()));


            }

            if(j-n*3>=2)
            {
                second.setText((GestionClasses.getNotionCourante().getQuestion().get((n*3+1)).afficherSansProp()));


            }
            else
            {
                second.setText("");


            }
            if(j-n*3>=3)
            {
                third.setText((GestionClasses.getNotionCourante().getQuestion().get((n*3+2)).afficherSansProp()));


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
            first.setText((GestionClasses.getNotionCourante().getQuestion().get((n-1)*3).afficherSansProp()));
            second.setText((GestionClasses.getNotionCourante().getQuestion().get((n-1)*3+1).afficherSansProp()));
            third.setText((GestionClasses.getNotionCourante().getQuestion().get((n-1)*3+2).afficherSansProp()));

        }
    }
    @FXML
    public void ajouterQuestion(ActionEvent event) throws Exception
    {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../gestionQuestion/creerQuestion.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 554, 464));
        primaryStage.show();
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

    }
    public void loadCompte(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../gestionApprenants/CompteApp.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }

    public void loadQuiz(ActionEvent event) throws  Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../gestionQuiz/AccueilQuiz.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    public void loadAccueil(ActionEvent event) throws  Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../formateurCompte/Accueil.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    public void retour(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../ajout/listeNotion.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }

}
