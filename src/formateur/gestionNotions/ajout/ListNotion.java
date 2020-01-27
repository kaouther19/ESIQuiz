package formateur.gestionNotions.ajout;

import formation.Notion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.GestionClasses;


import java.net.URL;
import java.util.ResourceBundle;

public class ListNotion implements Initializable
{
    int i=0;
    String s[]=new String[9];
    @FXML
    private Label first;
    @FXML
    private Label second;
    @FXML
    private Label third;
    @FXML
    private Label un;
    @FXML
    private Label deux;
    @FXML
    private Label trois;
    int j=GestionClasses.getFormation().getNotion().size();
    int k;
    int n=0;

    @Override

    public void initialize(URL location, ResourceBundle resources) {
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
            first.setText("Notion 1");
            un.setText(GestionClasses.getFormation().getNotion().get(0).getNotion());

        }

        if(i>=2)
        {
            second.setText("Notion 2");
            deux.setText(GestionClasses.getFormation().getNotion().get(1).getNotion());

        }
        if(i==3)
        {
            third.setText("Notion 3");
            trois.setText(GestionClasses.getFormation().getNotion().get(2).getNotion());

        }


    }
    @FXML
    public void ajouterNotion(ActionEvent event) throws Exception
    {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../gestionNotions/ajout/creerNotion.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 548, 120));
        primaryStage.show();
        GestionClasses.setStage((Stage) ((Node) event.getSource()).getScene().getWindow());

    }
    @FXML
    public void suivant(ActionEvent event) throws Exception
    {
        if(n<k )
        {
            if(j-n*3>=1 )
            {
                first.setText("Notion "+(n*3+1));
                un.setText(GestionClasses.getFormation().getNotion().get(n*3).getNotion());

            }

            if(j-n*3>=2)
            {
                second.setText("Notion "+(n*3+2));
                deux.setText(GestionClasses.getFormation().getNotion().get(n*3+1).getNotion());

            }
            else
            {
                second.setText("");
                deux.setText("");

            }
            if(j-n*3>=3)
            {
                third.setText("Notion "+(n*3+3));
                trois.setText(GestionClasses.getFormation().getNotion().get(n*3+2).getNotion());

            }
            else
            {
                third.setText("");
                trois.setText("");
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
            first.setText("Notion "+((n-1)*3+1));
            un.setText(GestionClasses.getFormation().getNotion().get((n-1)*3).getNotion());
            second.setText("Notion "+((n-1)*3+2));
            deux.setText(GestionClasses.getFormation().getNotion().get((n-1)*3+1).getNotion());
            third.setText("Notion "+((n-1)*3+3));
            trois.setText(GestionClasses.getFormation().getNotion().get((n-1)*3+2).getNotion());
        }
    }
    @FXML
    public void afficherNotion(ActionEvent event ) throws Exception
    {
        Button btn = (Button) event.getSource();
        String id= btn.getId();
        Boolean existe= false;
        if(id.compareTo("btnF")==0)
        {
            GestionClasses.setNotionCourante(GestionClasses.getFormation().getNotion().get((n-1)*3));
            existe=true;
        }
        else
            {
                if (id.compareTo("btnS")==0 && (n-1)*3+2<=j)
                {
                    GestionClasses.setNotionCourante(GestionClasses.getFormation().getNotion().get((n-1)*3+1));
                    existe=true;
                }
                else
                {
                    if (id.compareTo("btnT")==0 && (n-1)*3+3<=j)
                    {
                        GestionClasses.setNotionCourante(GestionClasses.getFormation().getNotion().get((n-1)*3+2));
                        existe=true;
                    }
                }
            }
        if(existe)
        {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            // affichage de la notion choisie

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../../gestionNotions/ajout/afficherNotion.fxml"));
            primaryStage.centerOnScreen();
            primaryStage.setScene(new Scene(root, 995, 708));
            primaryStage.show();
        }
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



}
