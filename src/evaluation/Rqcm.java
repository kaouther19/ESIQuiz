package evaluation;
import java.util.*;
import examination.*;
public class Rqcm extends Reponse {
	private  ArrayList<Integer>choix =new ArrayList<Integer>();

	public Rqcm(Question question) {
		
		super(question);
		
		
	}
	
	// *****************************affiche la question et la liste des choix *****************************************
	
	public void afficher( ) {
	    getQuestion().afficher();
	    if (isValide()) {
	    System.out.print("                         Les reponses choisis sont: | ");
	    for(int i=0;i<choix.size();i++)
	    {
	       System.out.print((choix.get(i)+1)+" | ");	
	    }}
		
	 
    }
	public  ArrayList<Integer> getChoix()
	{
		return choix;
	}
	//****************************Repondre a la question *****************************//	
	public void repondre(ArrayList<Integer> choix)
	{
		this.choix=new ArrayList<Integer> (choix);
		setValide(true);
	}

	
		
	
   //*****************************pour avoir le score de cette Q/R ************************************************
   public float evaluer()
   {
	   ArrayList<Proposition> prop=new ArrayList<Proposition>(((QCM) getQuestion()).getPropositions());
	   int p=1/prop.size();
	   int res=0;
	   
	   for (int i=0;i<prop.size();i++) 
	   {
		   if((choix.contains(i+1) && prop.get(i).isCorrect())||(!choix.contains(i+1) && !prop.get(i).isCorrect())) res=res+p;
		   
		   else
		   {
			   if((choix.contains(i+1) && !prop.get(i).isCorrect())||(!choix.contains(i+1) && prop.get(i).isCorrect())) res=res-p;
			  
		   }
	   }
	   if (res<0) res=0;
	   setResultat(res);
	   return res;
   }
   
   public int nbPropositions()
  	{
  		return ((QCM)getQuestion()).nbPropositions();
  	}
	

	
	
    


}
