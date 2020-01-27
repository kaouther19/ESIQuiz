package formation;

import examination.*;

import java.io.Serializable;
import java.util.*;
public class Notion implements Serializable
{	
	private String notion;
	private ArrayList<Question> questions= new ArrayList<Question> ();
	
	public Notion(String notion)
	{
		this.notion=notion;
		
	}
	public void introListQuestion(ArrayList<Question> question)
	{
		questions=new ArrayList<Question>(question);
	}
	public ArrayList<Question> getQuestion(){return questions;}
	public ArrayList<Question>  listeQuestion(int n)
	{
		int nb=0;
		int pos;
		
		
		ArrayList<Question> listeQuestion= new ArrayList<Question> ();
		Random rand= new Random();
		if(questions.size()==1)
			return questions;
		else{
		while(nb<n)
		{
			pos=rand.nextInt(questions.size());
			if(! (listeQuestion.contains(questions.get(pos))))
			{
				listeQuestion.add(questions.get(pos));
				nb++;
			}
		}
		return listeQuestion;}
	}
	public void afficher()
	{
		System.out.println("                    -------------------------------------------------------");
		System.out.println("                                   Notion: "+this.notion+"                      ");
		System.out.println("                    -------------------------------------------------------"+"\n");
		System.out.println("                                         Les questions                     ");
		System.out.println("                    -------------------------------------------------------"+"\n");
		for (int key=0; key<questions.size();key++) 
	    {
			System.out.println("                -------------------------------------------------------");
			questions.get(key).afficher();
			
		}	
	}
	
	public String getNotion()
	{
		return notion;
	}
	public void ajouterQuestion(Question question)
	{
		questions.add(question);
	}
	
}
