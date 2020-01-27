package evaluation;
import examination.*;

public class Rqo  extends Reponse {
	private  String choix;

	public Rqo(Question question) 
	{
		super(question);
	}
	
	// *****************************affiche la question et la liste des choix *****************************************
	
	public void afficher( ) 
	{
	    getQuestion().afficher();
	     if(isValide())
	    	 System.out.println("La reponse choisie est "+choix);
	   
		
	 
    }
	
	//****************************Repondre a la question *****************************//	
	public void repondre(String choix)
	{
		this.choix=choix;
		setValide(true);
	}
	
	
		
	
   //*****************************pour avoir le score de cette Q/R ************************************************
   public float evaluer()
   {
	   if(((QO) getQuestion()).getListeReponses().contains(choix))  setResultat(1);
	   else setResultat(0);
	   return getResultat();
   }
	public String getChoix()
	{
		return choix;
	}
}
   