package formateur.gestionQuiz;

import examination.Quiz;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.GestionClasses;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GenererQuiz implements Initializable
{
    ArrayList<Notion> notionL = GestionClasses.getFormation().getNotion();
    ArrayList<Notion> notionC= new ArrayList<Notion>();
    ArrayList<Integer> nbQuest=new ArrayList<Integer>();
    int i=1;
    @FXML
    private Label notion;

    @FXML
    private Button ignorer;

    @FXML
    private Button generer;

    @FXML
    private Button choisir;

    @FXML
    private TextField nbQuestion;

    @FXML
    public void choisir(ActionEvent event) throws Exception
    {
        notionC.add(notionL.get(i-1));
        nbQuest.add(Integer.parseInt(nbQuestion.getText()));
        notion.setText(notionL.get(i-1).getNotion());
        if(notionL.size()-i==0)
        {
            choisir.setVisible(false);
            generer.setVisible(true);
        }
        i++;
    }

    @FXML
    public void generer(ActionEvent event) throws Exception
    {
        GestionClasses.quiz=new Quiz((String) GestionClasses.getO(),notionC,nbQuest,GestionClasses.d[0],GestionClasses.d[1]);
        GestionClasses.quiz.afficher();
        GestionClasses.getFormateur().creerQuiz(GestionClasses.quiz);
        System.out.println(GestionClasses.getFormateur().getQuizNonValide().size());
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        //affichage de quiz
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionQuiz/afficherQuiz.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 610, 540));
        primaryStage.show();

    }

    @FXML
    public void ignorer(ActionEvent event) throws Exception
    {
        notion.setText(notionL.get(i).getNotion());
        if(notionL.size()-i==1)
        {
              ignorer.setVisible(false);
        }
        i++;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        notion.setText(notionL.get(0).getNotion());
        if(notionL.size()==1)
        {

            ignorer.setVisible(false);
            generer.setVisible(false);
        }


    }
}
