package compte;
import java.io.Serializable;
import java.util.*;
import examination.*;
import evaluation.*;
import formation.*;
import compte.*;
public class CompteFormateur extends Compte
{
	private  Formation formation;
	private  ArrayList <Quiz> quizNonValide = new ArrayList <Quiz>();
    
	public CompteFormateur(String nom,String prenom,Date dateDeNaissance,String adress,String motPass)
	{
		super(nom,prenom,dateDeNaissance,adress);
		setMotDePasse(motPass);
		setLogin(prenom.charAt(0)+nom);
	}
	public void creeFormation(Formation formation)
	{
		this.formation=formation;
	}
	public void creerQuiz(Quiz quiz)
	{
		quizNonValide.add(quiz);
	}
	public void ajouterNotion(Notion notion)
	{
		formation.ajouterNotion(notion);
	}
	public void introduireQuestion(Question question,Notion notion)
	{
		notion.ajouterQuestion(question);
	}
	public void CreerCompte(CompteApprenant compte)
	{
		formation.ajouterApprennant(compte); 
	}
	public void suppremerCompte(int compte)
	{
		formation.suuprimerApprennant(compte);
	}
	public void validerQuiz(Quiz quiz)
	{
		quizNonValide.remove(quiz);
		formation.ajouterQuiz(quiz);
	}
	public void validerQuiz(int quiz)
	{
		quizNonValide.get(quiz).valider();
		formation.ajouterQuiz(quizNonValide.get(quiz));
		formation.affecterQuiz(quizNonValide.get(quiz));
		quizNonValide.remove(quiz);

	}
	public void consulterActivite(int indexApprennat)
	{
		formation.getApprenants().get(indexApprennat).afficherTab();
	}
	public void afficherReponseApprenant(int idexApprenant,int indexReponse) {
		formation.getApprenants().get(idexApprenant).afficherReponseQuiz(indexReponse);
	}
	public void classerApprennants()
	{
		formation.classement();
	}
	public Quiz getQuiz(int i)
	{
		return quizNonValide.get(i);
	}
	public ArrayList<Quiz> getQuizNonValide()
	{return quizNonValide;}
}
