package formation;

import java.io.Serializable;
import java.util.*;
import examination.*;
import compte.*;

public class Formation implements Serializable
{	
	private String nom;
	private String description;
	private ArrayList<Notion> notions= new ArrayList<Notion>();
	private Date dateDebut;
	private Date dateFin;
	private ArrayList<CompteApprenant> apprenants= new ArrayList<CompteApprenant>();
	//private ArrayList<Quiz> quizOuverts= new ArrayList<Quiz>();
	private ArrayList<Quiz> quizValide= new ArrayList<Quiz>();
	private Boolean expire;
	public Formation(String nom, String description, Date dateDebut,Date dateFin )
	{
		this.nom=nom;
		this.description=description;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
	}
	public void ajouterNotion(Notion notion)
	{
		//catch
		notions.add(notion);
	}
	public ArrayList<Notion> getNotion(){return notions;}
	public void ajouterApp(CompteApprenant c){apprenants.add(c);}
	public CompteApprenant seConnecter(String login,String motPasse)
	{
		boolean trouve=false;
		int i=0;
		while (!trouve && i<apprenants.size())
		{
			
			trouve=apprenants.get(i).seConnecter(login, motPasse);
			i++;
			
		}
		if (!trouve)
		{
			System.out.println("                               mot de passe ou login éronné");
			return null;
		}
		else
		{
			affecterQuizs(i-1);
			apprenants.get(i-1).afficher();
			apprenants.get(i-1).afficherTab();
			return apprenants.get(i-1);
		}
		
	}
	public void affecterQuizs(int indexAppr)
	{
		for(Quiz z:this.quizValide)
		{
			if( z.ouvert())
			{
				apprenants.get(indexAppr).affecterQuiz(z);
			}
				
		}
	}
	public ArrayList<CompteApprenant> getApprenants() {
		return apprenants;
	}
	public void setApprenants( ArrayList<CompteApprenant> apprenants) {
		this.apprenants = new ArrayList <CompteApprenant>(apprenants);
	}
	public ArrayList<Quiz> getQuizValide() 
	{
		return quizValide;
	}
	public void setQuizValide(ArrayList<Quiz> quizValide) 
	{
		this.quizValide = new ArrayList<Quiz>(quizValide);
	}
	public void ajouterApprennant(CompteApprenant apprennant )
	{
		//catch
		for (Quiz q: quizValide) {
			apprennant.affecterQuiz(q);
		}

		apprenants.add(apprennant);

	}
	public void suuprimerApprennant(int apprennant )
	{
		apprenants.remove(apprennant);
	}
	public void classement()
	{
		Collections.sort(apprenants);
		System.out.println("                         -------------------- Classement des apprennants ---------------------- \n");
		afficherApprenants();
	}
	public void afficherApprenants()
	{
		for( CompteApprenant a: apprenants) {
			a.afficher();
		}
			
	}
	public void ajouterQuiz(Quiz quiz)
	{
		quizValide.add(quiz);
	}
	public void affecterQuiz(Quiz quiz)
	{
		for( CompteApprenant a: apprenants) {
			a.affecterQuiz(quiz);
		}
	}
	
}
