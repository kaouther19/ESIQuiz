package formateur.gestionNotions.ajout;

import formation.Notion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.GestionClasses;



public class CreerNotion {
    @FXML
    private TextField nomNotion;
    @FXML
    public void creerNotion(ActionEvent event) throws Exception
    {
        GestionClasses.getFormation().ajouterNotion(new Notion(nomNotion.getText()));
        GestionClasses.setFirst(false);
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        GestionClasses.getStage().close();
        // affichage de la notion cree
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../gestionNotions/ajout/listeNotion.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();



    }
}
