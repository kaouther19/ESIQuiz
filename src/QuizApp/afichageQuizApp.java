package QuizApp;

import java.net.URL;
import java.util.ResourceBundle;

import evaluation.*;
import examination.Proposition;
import examination.QCM;
import examination.QCU;
import examination.QO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sample.GestionClasses;

public class afichageQuizApp implements Initializable  {
@FXML
private Label question;
@FXML
private Label nom;
@FXML private Label ordre;//ordre question
@FXML private VBox propositions;
@FXML private HBox propo1;
@FXML private HBox propo2;
@FXML private HBox propo3;
@FXML private HBox propo4;
@FXML private HBox propo5;
private String propos [] = new String[10];
@FXML private Button valider;
@FXML private Button modifier;
 private int i=0;
private int j= GestionClasses.reponse.getQuiz().getQuestions().size();
@FXML private TextField qcu;


public void initialize(URL url, ResourceBundle resourceBundle) {

    propositions.setPadding(new Insets(20));
    propositions.setSpacing(10);
    nom.setText(GestionClasses.reponse.getQuiz().getNom());
    ordre.setText("0");
    if(GestionClasses.reponse.getQuiz().getQuestions().get(0) instanceof QCM )
    {
        question.setText("QCM "+GestionClasses.reponse.getQuiz().getQuestions().get(0).getQuestion());
        
    }
    if(GestionClasses.reponse.getQuiz().getQuestions().get(0) instanceof QCU )
    {
        question.setText("QCU "+GestionClasses.reponse.getQuiz().getQuestions().get(0).getQuestion());
    }
    if(GestionClasses.reponse.getQuiz().getQuestions().get(0) instanceof QO)
    {
        question.setText("QO "+GestionClasses.reponse.getQuiz().getQuestions().get(0).getQuestion());

    }
    if(GestionClasses.quiz.getQuestions().get(0) instanceof QCM ){

        for(Proposition p:((QCM) GestionClasses.reponse.getQuiz().getQuestions().get(0)).getPropositions() )
        {
            propositions.getChildren().add(new RadioButton(p.getProposition()));
            
        }}else{
    if( GestionClasses.reponse.getQuiz().getQuestions().get(0) instanceof QCU){
        for(Proposition p:((QCU) GestionClasses.reponse.getQuiz().getQuestions().get(0)).getPropositions() )
        {
            propositions.getChildren().add(new RadioButton(p.getProposition()));
        }
    }
    else
        {
            propositions.getChildren().addAll(new Text("Ensemble de choix possible :"));
            for(String s:((QO) GestionClasses.reponse.getQuiz().getQuestions().get(0)).getListeReponses())
            {
                propositions.getChildren().add(new Text("* "+s ));
            }
        }

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
    private RadioButton  rdb[];
    @FXML public void afficher()
    {   ToggleGroup group = new ToggleGroup();
        propositions.getChildren().clear();
        ordre.setText(""+i);
        if(GestionClasses.quiz.getQuestions().get(i) instanceof QCM )
        {
            question.setText("QCM "+GestionClasses.reponse.getQuiz().getQuestions().get(i).getQuestion());
        }
        if(GestionClasses.reponse.getQuiz().getQuestions().get(i) instanceof QCU )
        {
            question.setText("QCU "+GestionClasses.reponse.getQuiz().getQuestions().get(i).getQuestion());
        }
        if(GestionClasses.reponse.getQuiz().getQuestions().get(i) instanceof QO)
        {
            question.setText("QO "+GestionClasses.reponse.getQuiz().getQuestions().get(i).getQuestion());
        }
        if(GestionClasses.reponse.getQuiz().getQuestions().get(i) instanceof QCM ){

            for(Proposition p:((QCM) GestionClasses.reponse.getQuiz().getQuestions().get(i)).getPropositions() )
            {
               rdb[i]= new RadioButton(p.getProposition());
          	   propositions.getChildren().add( rdb[i]);
               if(((Rqcm)GestionClasses.reponse.getReponse(0)).getChoix().contains(i))
               {
            	   rdb[i].isSelected(); 
               }
               
            }}else{
            if( GestionClasses.reponse.getQuiz().getQuestions().get(i) instanceof QCU){
            	//creation de toogle groupe
            	
                for(Proposition p:((QCU) GestionClasses.reponse.getQuiz().getQuestions().get(i)).getPropositions() )
                {     
                    
                	rdb[i]= new RadioButton(p.getProposition());
                	rdb[i].setToggleGroup(group);
               	   propositions.getChildren().add( rdb[i]);
                    if(((Rqcu)GestionClasses.reponse.getReponse(0)).getChoix()==i)
                    {
                 	   rdb[i].isSelected(); 
                    }
                	  
                	  
                		  
                }
            }
            else
            {
            	  TextField b =new TextField();
                  b.setText(((Rqo)GestionClasses.reponse.getReponse(0)).getChoix());
            	  propositions.getChildren().addAll(new Text("Votre reponse :"),b);
              
               
            }

        }
    }



public void valider(ActionEvent event)throws Exception {
	
GestionClasses.reponse.setValide(true);
}}


