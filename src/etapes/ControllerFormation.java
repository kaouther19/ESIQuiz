package etapes;

import compte.CompteFormateur;
import formation.Formation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.GestionClasses;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ControllerFormation {
    @FXML
    private TextField nom;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private DatePicker dateFin;
    @FXML
    private TextField description;
    @FXML
    // suivant
    private Button suivant;
    @FXML
    public void pressSuivant(ActionEvent event) throws Exception
    {
        // Creation de la formation

        LocalDate localDate = dateDebut.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date debut = Date.from(instant);
        localDate = dateFin.getValue();
        instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date fin = Date.from(instant);
        Formation formation= new Formation(nom.getText(),description.getText(),debut,fin);
        GestionClasses.setFormation(formation);
        GestionClasses.getFormateur().creeFormation(formation);

        // aprés la création de la formation
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("etape2.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 1000, 612));
        primaryStage.show();
    }
}
