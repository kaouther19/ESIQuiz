package compte;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import examination.*;
import evaluation.*;


public class CompteApprenant extends Compte implements Comparable<CompteApprenant>
{
	
	private Float resultat=(float) 0;
	private	 ArrayList<ReponseQuiz>	reponsesQuiz= new  ArrayList<ReponseQuiz>();
	private	 ArrayList<Quiz>quizAffecte= new  ArrayList< Quiz>();
	public CompteApprenant(String nom,String prenom,Date dateDeNaissance,String adress)
	{
		super(nom,prenom,dateDeNaissance,adress);
		setLogin(prenom.charAt(0)+nom); //
		setMotDePasse(nom+ new SimpleDateFormat("ddMMyyyy").format(dateDeNaissance));//
	}
	public ArrayList<ReponseQuiz> getListeQuiz()
	{
		return reponsesQuiz;
	}
	public void affecterQuiz(Quiz quiz)
	{
		quizAffecte.add(quiz);
		reponsesQuiz.add(new ReponseQuiz(quiz));
	}
	public void afficherReponseQuiz(int i)
	{
		reponsesQuiz.get(i).afficher();
	}
	public ReponseQuiz reponseQuiz(int i)
	{
		return reponsesQuiz.get(i);
	}
	public void afficherTab()
	{
		// remplissage de la table 
		System.out.println(" ------------------------------------------------------------------------------------------------------------------");
		System.out.println("|         Quiz        |   Date d'ouverture   |  Date d'expiration  |  Taux d'accomplissement  | Taux de reussit    |");
		System.out.println(" ------------------------------------------------------------------------------------------------------------------");
		for (ReponseQuiz r :reponsesQuiz) 
	    {
			System.out.print("|        "+r.getQuiz().getNom()+"        ");
			System.out.print("|       "+new SimpleDateFormat("dd/MM/yyyy").format(r.getQuiz().getDateDebut())+"     ");
			System.out.print("|       "+new SimpleDateFormat("dd/MM/yyyy").format(r.getQuiz().getDateFin())+"    " );
			System.out.print("|              "+Float.toString(r.tauxAccompli())+"%       ");
			if(r.isValide())
			{
				
				System.out.println(" | "+Float.toString(r.evaluer())+"% | ");
			}
			else
			{
				if(r.getQuiz().getDateFin().compareTo(new Date())>=0)
				{
					System.out.println("|           -         | ");
				}
				else System.out.println("|           0.O%      | "); 
			}
				
		}
		System.out.println(" ------------------------------------------------------------------------------------------------------------------");	
	}
	
	@Override
	public int compareTo(CompteApprenant o) {
		
		return o.getResultat().compareTo(resultat);
	}
	public Float getResultat() {
		return resultat;
	}
	public void setResultat(Float resultat) {
		this.resultat = resultat;
	}
	public void afficher()
	{
		System.out.println("                          -------------------------------------------------------------");
		System.out.println("                          	Nom: "+getNom().toUpperCase());
		System.out.println("                          	Prénom: "+getPrenom());
		System.out.println("                          	Login: "+getLogin());
		System.out.println("                            Date naissance :"+new SimpleDateFormat("dd/MM/yyyy").format(this.getDateDeNaissance()));
		System.out.println("                          	Adresse: "+getAdress());
		System.out.println("                          	Résultat: "+getResultat());
		System.out.println("                          -------------------------------------------------------------");
		
	}
	public ArrayList<ReponseQuiz> getListQuiz(){
		return reponsesQuiz;
	}
	
}
