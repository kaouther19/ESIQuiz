package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;

public class Controller {
    @FXML
    ImageView test;
    @FXML
    // button formateur
    private Button formateur;
    @FXML
    // button apprenant
    private Button apprenant;
    @FXML
    public void pressFormateur(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../formateur/SignInUP.fxml"));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 622, 392));
        primaryStage.show();
    }
    @FXML
    public void pressApprenant(ActionEvent event) throws Exception
    {
        /*Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../apprenant/connection/seconnecter.fxml"));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 622, 392));
        primaryStage.show();*/
        Image ii= new  Image("file:/Users/macbookair/IdeaProjects/ESIQuiz/src/QuizApp/addQuiz.png");

        test.setImage(ii);
    }


}
