package examination;
import java.io.Serializable;
import java.util.*;
import formation.*;
public abstract class Question implements Serializable
{
	private String question;
	private Notion notion;
	public Question(String question,Notion notion)
	{
		this.question=question;
		this.notion=notion;
		
	}
	abstract public void afficher();
	abstract public String afficherSansProp();
	abstract public void afficherAvecReponses();
	public String getQuestion() {
		return question;
	}
	public Notion getNotion() {
		return notion;
	}
	public boolean equals(Object o)
	{
		
		if (question.compareTo(((Question )o).getQuestion())==0) return true;
		else return false;
	}
	
}
