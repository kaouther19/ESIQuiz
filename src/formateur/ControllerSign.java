package formateur;

import compte.CompteFormateur;
import formation.Formation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import sample.GestionClasses;

import java.io.*;

public class ControllerSign {
   @FXML
   private TextField login;
   @FXML
   private PasswordField passWord;
   @FXML
   private Label msgCnx;
    @FXML
    // inscription
    private Hyperlink inscription;
    @FXML
    public void pressInscription(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 622, 392));
        primaryStage.show();
    }
     // connexion
    @FXML
    private Button connecter;
    @FXML
    public void pressConnecter(ActionEvent event) throws Exception
    {
        File fichier =  new File("serialization.ser") ;
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier));
        CompteFormateur formateur= (CompteFormateur)ois.readObject();
        System.out.println(formateur.getNom());
        GestionClasses.setFormateur(formateur);
        GestionClasses.setFormation((Formation)ois.readObject());
        if (GestionClasses.getFormateur()==null){
            msgCnx.setText("vous n'êtes pas inscrits");
        }
        else{
            if(!GestionClasses.getFormateur().seConnecter(login.getText(),passWord.getText()))
            {
                msgCnx.setText("Mot de passe ou login ironné");
            }
            else
                {
                   // affichage de la premiere page
                    GestionClasses.setInscri();
                    Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("formateurCompte/Accueil.fxml"));
                    primaryStage.centerOnScreen();
                    primaryStage.setScene(new Scene(root, 995, 708));
                    primaryStage.show();
                }
        }
    }


}
