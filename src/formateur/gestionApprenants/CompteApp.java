package formateur.gestionApprenants;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.GestionClasses;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class CompteApp implements Initializable {
    @FXML private  Label res;
    @FXML private Label nom;
    @FXML private Label prenom;
    @FXML private Label date;
    @FXML private Label adress;
    int j=GestionClasses.getFormation().getApprenants().size();
    int n=0;

    @FXML
    public void creerCompte(ActionEvent event) throws Exception
    {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gestionApprenants/creerCompte/creerCompte.fxml"));

        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 378, 352));
        primaryStage.show();
        GestionClasses.setStage((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
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
    public void loadAccueil(ActionEvent event) throws  Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../formateurCompte/Accueil.fxml"));
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
    public void consulterActivite(ActionEvent event) throws Exception
    {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        GestionClasses.apprenant= GestionClasses.getFormation().getApprenants().get(n);
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("apprenantCompte/Accueil.fxml"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 995, 708));
        primaryStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(j>=1)
        {
            nom.setText(GestionClasses.getFormation().getApprenants().get(0).getNom());
            prenom.setText(GestionClasses.getFormation().getApprenants().get(0).getPrenom());
            date.setText(new SimpleDateFormat("dd/MM/yyyy").format(GestionClasses.getFormation().getApprenants().get(0).getDateDeNaissance()));
            adress.setText(GestionClasses.getFormation().getApprenants().get(0).getAdress());
            String s=GestionClasses.getFormation().getApprenants().get(0).getResultat().toString();
            res.setText(s);



        }


    }
    @FXML
    public void suivant(ActionEvent event) throws Exception
    {
        if(n+1<=(j-1) )
        {
            n++;
            affichage();


        }
    }
    @FXML
    public void precedent(ActionEvent event) throws Exception
    {
        if(n>=1)
        {
            n--;
            affichage();
        }
    }
    public void affichage()
    {
        nom.setText(GestionClasses.getFormation().getApprenants().get(n).getNom());
        prenom.setText(GestionClasses.getFormation().getApprenants().get(n).getPrenom());
        date.setText(new SimpleDateFormat("dd/MM/yyyy").format(GestionClasses.getFormation().getApprenants().get(n).getDateDeNaissance()));
        adress.setText(GestionClasses.getFormation().getApprenants().get(n).getAdress());
        String s=GestionClasses.getFormation().getApprenants().get(n).getResultat().toString();
        res.setText(s);
    }
}
