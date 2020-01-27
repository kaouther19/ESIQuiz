package formateur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import compte.CompteFormateur;
import sample.GestionClasses;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ControlleurInsc {
    @FXML
    // retour page connexion
    private Hyperlink seConnecter;
    @FXML
    public void pressSeConnecter(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignInUP.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 622, 392));
        primaryStage.show();
    }

    // recuperation des données et creation du compte
    @FXML
    private Button rejoindre;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private PasswordField passWord;
    @FXML
    private TextField adress;
    @FXML
    private DatePicker bDay;
    @FXML
    public void pressRejoindre (ActionEvent event) throws Exception
    {
        GestionClasses.setFirst(true);
        LocalDate localDate = bDay.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        CompteFormateur formateur= new CompteFormateur(nom.getText(),prenom.getText(),date,adress.getText(),passWord.getText());
        GestionClasses.setFormateur(formateur);
        // etapes de creation de la formation
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../etapes/Formation.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 1000, 612));
        primaryStage.show();

    }
}
