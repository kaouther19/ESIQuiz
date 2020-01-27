package formateur.gestionQuiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.GestionClasses;


public class AccueilQuiz
{
    @FXML private Button quizValide;
    @FXML  private Button quizNonValide;
    @FXML
    public void genererQuiz(ActionEvent event) throws Exception
    {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionQuiz/nbNotion.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 400, 292));
        primaryStage.show();
    }
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

    public void loadNotion(ActionEvent event) throws Exception
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
    public void loadAccueil(ActionEvent event) throws  Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../formateurCompte/Accueil.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    public void listequiz(ActionEvent event) throws  Exception
    {
        Button btn = (Button) event.getSource();
        String id= btn.getId();
        if(id.compareTo("quiz1")==0)
        {GestionClasses.listQuiz=GestionClasses.getFormateur().getQuizNonValide();
        GestionClasses.setO("Liste des Quiz Non Valide");}
        else
        {GestionClasses.listQuiz=GestionClasses.getFormation().getQuizValide();
        GestionClasses.setO("Liste des Quiz Valide");}

        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionQuiz/QuiznonValide.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }

}
