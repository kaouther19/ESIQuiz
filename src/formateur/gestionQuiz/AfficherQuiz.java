package formateur.gestionQuiz;

import examination.Proposition;
import examination.QCM;
import examination.QCU;
import examination.QO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.GestionClasses;

import java.net.URL;
import java.util.ResourceBundle;

public class AfficherQuiz implements Initializable
{
@FXML
    private Label question;
    @FXML
    private Label nom;
    @FXML private Label ordre;
    @FXML private VBox propositions;
    @FXML private HBox propo1;
    @FXML private HBox propo2;
    @FXML private HBox propo3;
    @FXML private HBox propo4;
    @FXML private HBox propo5;
    private String propos [] = new String[10];
    @FXML private Button valider;
    @FXML private Button modifier;
    @FXML private int i=0;
    @FXML private int j= GestionClasses.quiz.getQuestions().size();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        propositions.setPadding(new Insets(20));
        propositions.setSpacing(10);
        nom.setText(GestionClasses.quiz.getNom());
        ordre.setText("1");
        if(GestionClasses.quiz.getQuestions().get(0) instanceof QCM )
        {
            question.setText("QCM "+GestionClasses.quiz.getQuestions().get(0).getQuestion());
        }
        if(GestionClasses.quiz.getQuestions().get(0) instanceof QCU )
        {
            question.setText("QCU "+GestionClasses.quiz.getQuestions().get(0).getQuestion());
        }
        if(GestionClasses.quiz.getQuestions().get(0) instanceof QO)
        {
            question.setText("QO "+GestionClasses.quiz.getQuestions().get(0).getQuestion());
        }
        if(GestionClasses.quiz.getQuestions().get(0) instanceof QCM ){

            for(Proposition p:((QCM) GestionClasses.quiz.getQuestions().get(0)).getPropositions() )
            {
                propositions.getChildren().add(new RadioButton(p.getProposition() +" ("+p.isCorrect()+")"));
            }}else{
        if( GestionClasses.quiz.getQuestions().get(0) instanceof QCU){
            for(Proposition p:((QCU) GestionClasses.quiz.getQuestions().get(0)).getPropositions() )
            {
                propositions.getChildren().add(new RadioButton(p.getProposition() +" ("+p.isCorrect()+")"));
            }
        }
        else
            {
                propositions.getChildren().addAll(new Text("Ensemble de choix possible :"));
                for(String s:((QO) GestionClasses.quiz.getQuestions().get(0)).getListeReponses())
                {
                    propositions.getChildren().add(new Text("* "+s ));
                }
            }

        }
        if(GestionClasses.quiz.isValide())
        {
            valider.setVisible(false);
        }

    }
        @FXML public void suivant(ActionEvent event) throws Exception
        {
            if(i+1<=(j-1))
            {
                i++;
                afficher();

            }
        }
        @FXML public void precedent(ActionEvent event) throws Exception
        {
            if(i>=1)
            {
                i--;
                afficher();

            }
         }
        @FXML public void afficher()
        {
            propositions.getChildren().clear();
            ordre.setText(""+(i+1));
            if(GestionClasses.quiz.getQuestions().get(i) instanceof QCM )
            {
                question.setText("QCM "+GestionClasses.quiz.getQuestions().get(i).getQuestion());
            }
            if(GestionClasses.quiz.getQuestions().get(i) instanceof QCU )
            {
                question.setText("QCU "+GestionClasses.quiz.getQuestions().get(i).getQuestion());
            }
            if(GestionClasses.quiz.getQuestions().get(i) instanceof QO)
            {
                question.setText("QO "+GestionClasses.quiz.getQuestions().get(i).getQuestion());
            }
            if(GestionClasses.quiz.getQuestions().get(i) instanceof QCM ){

                for(Proposition p:((QCM) GestionClasses.quiz.getQuestions().get(i)).getPropositions() )
                {
                    propositions.getChildren().add(new RadioButton(p.getProposition() +" ("+p.isCorrect()+")"));
                }}else{
                if( GestionClasses.quiz.getQuestions().get(i) instanceof QCU){
                    for(Proposition p:((QCU) GestionClasses.quiz.getQuestions().get(i)).getPropositions() )
                    {
                        propositions.getChildren().add(new RadioButton(p.getProposition() +" ("+p.isCorrect()+")"));
                    }
                }
                else
                {
                    propositions.getChildren().addAll(new Text("Ensemble de choix possible :"));
                    for(String s:((QO) GestionClasses.quiz.getQuestions().get(i)).getListeReponses())
                    {
                        propositions.getChildren().add(new Text("* "+s ));
                    }
                }

            }
        }
        public void valider(ActionEvent event) throws Exception
        {
            GestionClasses.getFormateur().validerQuiz(GestionClasses.getFormateur().getQuizNonValide().indexOf(GestionClasses.quiz));
            valider.setVisible(false);
            GestionClasses.getStage().close();
            Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../gestionQuiz/QuiznonValide.fxml"));
            primaryStage.centerOnScreen();
            primaryStage.setScene(new Scene(root, 995, 708));
            primaryStage.show();
        }







    }

