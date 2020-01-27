package formateur.gestionApprenants.creerCompte;

import compte.CompteApprenant;
import compte.CompteFormateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.GestionClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CreerCompte {
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
    public void pressCreer (ActionEvent event) throws Exception
    {

        LocalDate localDate = bDay.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        CompteApprenant apprenant= new CompteApprenant(nom.getText(),prenom.getText(),date,adress.getText());
        GestionClasses.getFormation().ajouterApprennant(apprenant);
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        GestionClasses.getStage().close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../gestionApprenants/CompteApp.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();


    }
}
