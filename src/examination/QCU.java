package examination;
import java.util.*;

import formation.Notion;
public class QCU extends Question 
{
	
	private ArrayList<Proposition>propositions;
	public QCU(Notion notion,String question,ArrayList<Proposition>propositions)
	{
		super(question,notion);
		Collections.shuffle(propositions);
		this.propositions=new ArrayList<Proposition>(propositions);
	}
	
	public void afficher()
	{
		System.out.println(getQuestion());
		for (int i=0;i<propositions.size();i++) 
		    {
			   System.out.println("                              "+(i+1)+"."+propositions.get(i).getProposition());
			}	
	}
	public void afficherAvecReponses()
	{
		System.out.println(getQuestion());
		for (int i=0;i<propositions.size();i++) 
	    {
		   System.out.println("                                 "+(i+1)+"."+propositions.get(i).getProposition()+" : "+"| "+propositions.get(i).isCorrect()+" |");
		}	
	}
	public ArrayList<Proposition> getPropositions()
	{
		return propositions;
	}
	public int nbPropositions()
	{
		return propositions.size();
	}
	public String  afficherSansProp()
		{
			return "QCU :"+getQuestion();
		}
}


