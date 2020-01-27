package apprenant.compte;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import evaluation.ReponseQuiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.*;

import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;




public class Acceuil implements Initializable {
  private int i=GestionClasses.apprenant.getListeQuiz().size();
  private ArrayList<ReponseQuiz> quiz =GestionClasses.apprenant.getListeQuiz();
  @FXML private GridPane gridPane;
  @FXML private Label page;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		int j;
		System.out.println(i);
		if (i>10) j=10;
		else j=i;
		for(int k=0;k<j;k++)
		{
			((Button)gridPane.getChildren().get((k+1)*5)).setText(quiz.get(k).getQuiz().getNom());
			((Label)gridPane.getChildren().get((k+1)*5+1)).setText( new SimpleDateFormat("dd/MM/yyyy").format(quiz.get(k).getQuiz().getDateDebut()));
			((Label)gridPane.getChildren().get((k+1)*5+2)).setText( new SimpleDateFormat("dd/MM/yyyy").format(quiz.get(k).getQuiz().getDateFin()));
			((Label)gridPane.getChildren().get((k+1)*5+3)).setText(quiz.get(k).tauxAccompli()+"%");

			if(quiz.get(k).isValide())
			{

				((Label)gridPane.getChildren().get((k+1)*5+4)).setText(quiz.get(k).evaluer()+"%");

			}
			else
			{
				if(quiz.get(k).getQuiz().getDateFin().compareTo(new Date())>=0)
				{
					((Label)gridPane.getChildren().get((k+1)*5+4)).setText("-");

				}
				else ((Label)gridPane.getChildren().get((k+1)*5+4)).setText("0.0%");
			}
		}
		page.setText("1");

	}
	public void afficherQuiz(ActionEvent event) throws Exception
	{
		Button btn = (Button) event.getSource();
		String id= btn.getId();
		Boolean existe= false;
		int i=Integer.parseInt( ""+id.charAt(3));
		if(quiz.size()>i)
		{
			GestionClasses.quiz= GestionClasses.apprenant.reponseQuiz(i).getQuiz();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.close();
			// affichage de la reponseQuiz

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../../formateur/gestionQuiz/afficherQuiz.fxml"));
			primaryStage.centerOnScreen();
			primaryStage.setScene(new Scene(root, 610, 540));
			primaryStage.show();
		}
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
