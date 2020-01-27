package formateur.gestionNotions.ajout;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.GestionClasses;


public class AjoutNotion
{
    @FXML
    public  void ajouterNotion(ActionEvent event) throws Exception
    {

        GestionClasses.setStage((Stage) ((Node) event.getSource()).getScene().getWindow());
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../gestionNotions/ajout/creerNotion.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 548, 120));
        primaryStage.show();
    }
    @FXML
    public void loadAccueil(ActionEvent event) throws  Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../formateurCompte/Accueil.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }

}
