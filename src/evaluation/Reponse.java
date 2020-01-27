package evaluation;

import java.io.Serializable;
import java.util.*;
import examination.*;
abstract public class Reponse implements Serializable {
	private	Question	question ;
	private float	resultat=0;
	private boolean valide=false;
	public Reponse(Question question)  
	{
		this.question=question;
		
	}
	public abstract	void	 afficher() ;
	
	public abstract	float	evaluer();
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
    
	public float getResultat() {
		return resultat;
	}
	public void setResultat(float resultat) {
		this.resultat = resultat;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public int typeQuestion()
	{
		if(question instanceof QCM)
		{
			
			return 1;
			
		}
		else
		{
			if(question instanceof QCU)
			{
				
				return 0;
			}
			else
			{
				
				return -1;
			}
		}
	}
	
}
	