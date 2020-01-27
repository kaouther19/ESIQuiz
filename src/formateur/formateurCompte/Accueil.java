package formateur.formateurCompte;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import sample.GestionClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Accueil
{
    @FXML
    private Button btnNotion;
    @FXML
    private ImageView imgNotion ;
    @FXML
    private Rectangle notion;
    @FXML
    private Hyperlink notions;
    public void loadNotion(ActionEvent event) throws Exception
    {
        String path;
        if(GestionClasses.getFirst()==false)
            path="../gestionNotions/ajout/listeNotion.fxml";
        else
        {
            path="../gestionNotions/ajout/ajoutNotion.fxml";
        }

        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(path));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    public void loadQuiz(ActionEvent event) throws  Exception
    {

        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionQuiz/AccueilQuiz.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    public void loadCompte(ActionEvent event) throws Exception
    {

        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionApprenants/CompteApp.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    public void deconnextion (ActionEvent event) throws Exception
    {
        File fichier =  new File("serialization.ser") ;

        // ouverture d'un flux sur un fichier
        ObjectOutputStream oos = null;

            oos = new ObjectOutputStream(new FileOutputStream(fichier));


        // création d'un objet à sérializer

        // sérialization de l'objet
        oos.writeObject(GestionClasses.getFormateur()) ;
        oos.writeObject(GestionClasses.getFormation()) ;
        oos.close();
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../sample/sample.fxml"));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 1178, 688));
        primaryStage.show();
    }
    }



