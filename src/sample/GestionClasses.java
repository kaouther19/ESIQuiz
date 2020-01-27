package sample;

import compte.*;
import evaluation.ReponseQuiz;
import examination.Quiz;
import formation.Formation;
import formation.Notion;
import javafx.stage.Stage;

import java.util.*;
public class GestionClasses {

    public static ReponseQuiz reponse;
    public static  ArrayList<Quiz> listQuiz= new ArrayList<Quiz>();
    public static  CompteApprenant apprenant;
    private static CompteFormateur formateur=null;
    private static Formation formation=null;
    private static Object o=new Object();
    public static Date [] d= new Date[2];
    public static Quiz quiz;
    public static void setO(Object o)
    {
        GestionClasses.o=o;
    }
    public static Object getO()
    {
        return o;
    }
    //
    private static boolean inscri= false;
    private static boolean first= false;
    private static Stage stage;
    private static Notion notionCourante;
    private static int [] proposition= new int [3];
    //
    public static void setFormateur(CompteFormateur formateur)
    {
        GestionClasses.formateur=formateur;
    }
    public static CompteFormateur getFormateur()
    {
        return formateur;
    }
    //
    public static void setFormation(Formation formation) { GestionClasses.formation=formation;}
    public static Formation getFormation()
    {
        return formation;
    }
    //
    public static void setInscri(){ inscri=true;}
    public static  Boolean getInscri(){ return inscri;}
    //
    public static void setStage(Stage stage){ GestionClasses.stage=stage;}
    public static Stage getStage(){ return stage;}
    //
    public static void setFirst(Boolean b){first=b;}
    public static boolean getFirst(){return  first;}
    //
    public static void setNotionCourante(Notion notion)
    {
        GestionClasses.notionCourante=notion;
    }
    public static Notion getNotionCourante()
    {
        return  notionCourante;
    }
    //
    public static void setProposition(int[] tab )
    {
        GestionClasses.proposition=tab;
    }
    public static int [] getProposition()
    {
        return proposition;
    }


}
