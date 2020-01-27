package formateur.gestionQuestion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.GestionClasses;


public class CreerQuestion
{
    int type[]= new int[3];
    @FXML
    private TextField text;
    @FXML
    private TextField nbPropJ;
    @FXML
    private TextField nbProp;
    @FXML
    public void choisir(ActionEvent event) throws Exception
    {
        RadioButton btn= (RadioButton) event.getSource();
        String id =btn.getId();
        if(id.compareTo("QCM")==0)
        {
            type[0]=0;
            nbPropJ.setEditable(true);

        }
        else
        {
            if(id.compareTo("QCU")==0)
            {
                type[0]=1;
                nbPropJ.setEditable(false);

            }
            else
                if(id.compareTo("QO")==0){
                type[0]=2;
                nbPropJ.setEditable(false);
               }
        }

    }
    @FXML
    public void creerQuestion(ActionEvent event ) throws Exception
        {
            GestionClasses.setO(text.getText());
            GestionClasses.setProposition(type);
            type[1]=Integer.parseInt(nbProp.getText());
            if(type[0]==0)
            {

                type[2]=Integer.parseInt(nbPropJ.getText());
            }
            if(type[0]==1)
            {

                type[2]=type[1]-1;
            }


            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../gestionQuestion/ajouPropo.fxml"));
            primaryStage.centerOnScreen();
            primaryStage.setScene(new Scene(root, 406, 178));
            primaryStage.show();
            GestionClasses.setStage((Stage) ((Node) event.getSource()).getScene().getWindow());

        }

}
