package evaluation;
import examination.*;

import java.io.Serializable;
import java.util.*;


public class ReponseQuiz implements Serializable {
	private	 ArrayList<Reponse>	reponses= new  ArrayList<Reponse>();
	private	Quiz	quiz ;
	private	boolean 	valide=false ;
	private	float	tauxAccompli=0 ;
	private 	float	tauxReussite =0;
	public ReponseQuiz(Quiz quiz)
	{
		this.quiz=quiz;
		for (Question q: quiz.getQuestions()) 
	    {
			
			if(q instanceof QCM)
			{
				reponses.add(new Rqcm(q));
			}
			else
			{
				if(q instanceof QCU)
				{
					reponses.add(new Rqcu(q));
				}
				else
				{
					reponses.add(new Rqo(q));
				}
			}
			
		}
		
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void afficher()
	{	
		int i=0;
		System.out.println("                  -----------------------------------------------------------");
		for(Reponse r : reponses )
		{
			
			System.out.println("                     -- -- -- -- -- -- Question n°"+i+" -- -- -- -- -- -- ");
			r.afficher();
			i++;
		}
	}
	
	public void valider()
	{
		this.setValide(true);
	}
	
	public float tauxAccompli()
	{
		int cpt=0;
		for(Reponse r: reponses)
		{
			
			if(r.isValide())
			{
				cpt++;
			}
		}
		tauxAccompli=cpt/quiz.nbQuestion()*100;
		 return tauxAccompli; 
	}
	public float evaluer()
	{
		for(Reponse r: reponses)
		{
			tauxReussite=(r.evaluer())*(100/quiz.nbQuestion())+tauxReussite;
		}
		
		return tauxReussite;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public Reponse getReponse(int i)
	{
		 return reponses.get(i);
	}
}
