package evaluation;
import examination.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import examination.QCM;
import examination.Question;

public class Rqcu extends Reponse  {

	
	private  int choix;

	public Rqcu(Question question ) {
		
		super(question);
		
		
	}
	
	// *****************************affiche la question et la liste des choix *****************************************
	
	public void afficher( ) 
	{
	    getQuestion().afficher();
	    if(isValide())
	    	System.out.println("La reponse choisie est "+choix+1);
	   
		
	 
    }
	public int getChoix()
	{
		return choix;
	}

	//****************************Repondre a la question *****************************//	
	public void repondre(int choix)
	{
		this.choix=choix;
		setValide(true);
	}
	
	
		
	
   //*****************************pour avoir le score de cette Q/R ************************************************
   public float evaluer()
   {
	   
	    	if(((QCU) getQuestion()).getPropositions().get(choix).isCorrect())
	    	{
	    		setResultat(1);
	    		
	    	}
	    	else setResultat(0);
	    
	    return getResultat();
   }
	
   public int nbPropositions()
	{
		return ((QCU)getQuestion()).nbPropositions();
	}

	
	
    

}
