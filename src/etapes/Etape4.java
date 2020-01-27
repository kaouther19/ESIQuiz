package etapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Etape4 {
    @FXML
    // suivant
    private Button suivant;
    @FXML
    public void pressSuivant(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("etape5.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 1000, 612));
        primaryStage.show();
    }
}
