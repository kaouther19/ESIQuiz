package formateur.gestionApprenants.apprenantCompte;

import evaluation.ReponseQuiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.GestionClasses;



import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Accueil implements Initializable {
    private int i= GestionClasses.apprenant.getListeQuiz().size();
    private ArrayList<ReponseQuiz> quiz=GestionClasses.apprenant.getListeQuiz();
   @FXML
   private GridPane gridPane;
   @FXML private Label page;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(GestionClasses.apprenant.getListQuiz().size());
        System.out.println(GestionClasses.getFormation().getApprenants().get(0).getListQuiz().size());
        int j;
        if (i>10) j=10;
        else j=i;
        for(int k=0;k<j;k++)
        {
            ((Button)gridPane.getChildren().get((k+1)*5)).setText(quiz.get(k).getQuiz().getNom());
            ((Label)gridPane.getChildren().get((k+1)*5+1)).setText( new SimpleDateFormat("dd/MM/yyyy").format(quiz.get(k).getQuiz().getDateDebut()));
            ((Label)gridPane.getChildren().get((k+1)*5+2)).setText( new SimpleDateFormat("dd/MM/yyyy").format(quiz.get(k).getQuiz().getDateFin()));
            ((Label)gridPane.getChildren().get((k+1)*5+3)).setText(quiz.get(k).tauxAccompli()+"%");

            if(quiz.get(k).isValide())
            {

                ((Label)gridPane.getChildren().get((k+1)*5+4)).setText(quiz.get(k).evaluer()+"%");

            }
            else
            {
                if(quiz.get(k).getQuiz().getDateFin().compareTo(new Date())>=0)
                {
                    ((Label)gridPane.getChildren().get((k+1)*5+4)).setText("-");

                }
                else ((Label)gridPane.getChildren().get((k+1)*5+4)).setText("0.0%");
            }
        }
        page.setText("1");

    }
    public void loadNotion(ActionEvent event) throws Exception
    {
        String path;
        if(GestionClasses.getFirst()==false)
            path="../../gestionNotions/ajout/listeNotion.fxml";
        else
        {
            path="../../gestionNotions/ajout/ajoutNotion.fxml";
        }

        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(path));
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

}
