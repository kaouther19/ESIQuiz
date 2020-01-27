package examination;
import java.util.*;
import formation.*;
public class QO extends Question 
{
	HashSet<String> listeReponses=new HashSet<String>();
	public QO(Notion notion,String question,HashSet<String> listeReponses)
	{
		super(question,notion);
		this.listeReponses=new HashSet<String>(listeReponses);
	}
    public void afficher()
    {
    	System.out.println("QO :"+getQuestion());
    }
	public String afficherSansProp()
	{
		return "QO :"+getQuestion();
	}
    public void afficherAvecReponses()
    {
    	System.out.println(getQuestion());
    	System.out.println("Les réponses possibles:");
    	int i=1;
    	for(String s: listeReponses)
    	{
    		System.out.println("                    "+i+"."+s);
    		i++;
    	}
    }
    public HashSet<String> getListeReponses()
    {
    	return listeReponses;
    }

}

