package apprenant.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import compte.CompteFormateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.GestionClasses;
import formation.Formation;
import sample.GestionClasses;

public class seConnecter {
	 @FXML
	   private TextField login;
	   @FXML
	   private PasswordField passWord;
	   @FXML
	   private Label msgCnx;
	   @FXML
	    private Button seconnecter;
	    @FXML Button btn0;
	@FXML Button btn1;
	@FXML Button btn2;
	@FXML Button btn3;
	@FXML Button btn4;
	@FXML Button btn5;
	@FXML Button btn6;
	@FXML Button btn7;
	@FXML Button btn8;
	@FXML Button btn9;
	  @FXML
	    public void pressConnecter(ActionEvent event) throws Exception
	    {
			File fichier =  new File("serialization.ser") ;
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier));
			CompteFormateur formateur= (CompteFormateur)ois.readObject();
			System.out.println(formateur.getNom());
			GestionClasses.setFormateur(formateur);
			GestionClasses.setFormation((Formation)ois.readObject());
	    	if (GestionClasses.getFormation().seConnecter(login.getText(),passWord.getText()) != null )
	    	{
				GestionClasses.apprenant=GestionClasses.getFormation().seConnecter(login.getText(),passWord.getText());
	    		Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
	            stage.close();
	            Stage primaryStage = new Stage();
	            Parent root = FXMLLoader.load(getClass().getResource("../compte/Accueil.fxml"));
	            primaryStage.centerOnScreen();
	            primaryStage.setScene(new Scene(root, 995, 708));
	            primaryStage.show();
	    	}else {
	    
	    			msgCnx.setText("login ou mot e passe erroné");}
	    
}}
