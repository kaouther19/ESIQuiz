package examination;
import java.util.*;
import evaluation.*;
import formation.*;
public class QCM extends Question 
{
	
	private ArrayList<Proposition>propositions;
	public QCM(Notion notion,String textQuestion,ArrayList<Proposition>propositions)
	{
		super(textQuestion,notion);
		Collections.shuffle(propositions);
		this.propositions=new ArrayList<Proposition>(propositions);
	}
	public void afficher()
	{
		System.out.println(getQuestion());
		for (int i=0;i<propositions.size();i++) 
		    {
			   System.out.println("                             "+(i+1)+"."+propositions.get(i).getProposition());
			}	
	}
	public void afficherAvecReponses()
	{
		System.out.println(getQuestion());
		for (int i=0;i<propositions.size();i++) 
	    {
		   System.out.println("                                "+(i+1)+"."+propositions.get(i).getProposition()+" : "+"| "+propositions.get(i).isCorrect()+" |");
		}	
	}
	
	public ArrayList<Proposition>getPropositions()
	{
		return propositions;
	}
	public int nbPropositions()
	{
		return propositions.size();
	}
	public String afficherSansProp()
	{
		return "QCM :"+getQuestion();
	}
}
