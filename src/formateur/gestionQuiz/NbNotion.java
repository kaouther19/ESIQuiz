package formateur.gestionQuiz;

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

public class NbNotion
{
    @FXML
    private TextField nom;
    @FXML
    private DatePicker debut;
    @FXML
    private DatePicker fin;
    @FXML
    private Button suivant;
    @FXML
    public void suivant(ActionEvent event)throws Exception
    {
        GestionClasses.setO(nom.getText());
        LocalDate localDate = debut.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        GestionClasses.d[0]=Date.from(instant);
        localDate = fin.getValue();
        instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        GestionClasses.d[1]=Date.from(instant);
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionQuiz/genererQuiz.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 632, 356));
        primaryStage.show();
    }
}
