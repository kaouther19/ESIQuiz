package examination;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import formation.*;

public class Quiz implements Modifiable, Serializable
{
	private String nom;
	private ArrayList<Question> questions ;
	private ArrayList<Notion> notions;
	private ArrayList<Integer> nbQuestionNotion;
	private Date dateDebut;
	private Date dateFin;
	private Boolean valide= false;
	public Quiz(String nom,ArrayList<Notion> notions,ArrayList<Integer> nbQuestionNotion,Date dateDebut,Date dateFin)
	{
		this.nom=nom;
		this.notions=new ArrayList<Notion> (notions);
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.nbQuestionNotion= new ArrayList<Integer> (nbQuestionNotion);
		this.questions=this.genererQuestions();
	}
	public void valider()
	{
		valide=true;
	}
	public boolean isValide()
	{
		return  valide;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void afficher()
	{
		System.out.println("                          ----------------------------------------------------------------------------------------------------------------");
		System.out.print("                          Quiz: "+this.nom+"+                ");
		System.out.print(" | "+new SimpleDateFormat("dd/MM/yyyy").format(dateDebut));
		System.out.print(" | "+new SimpleDateFormat("dd/MM/yyyy").format(dateFin));
		System.out.println("                          ----------------------------------------------------------------------------------------------------------------"+"\n");
		System.out.println("                                Les questions                     ");
		System.out.println("                          ----------------------------------------------------------------------------------------------------------------"+"\n");
		for (int i=0;i<questions.size();i++) 
	    {
		System.out.println("                          ---------------------------------------------------------------------------------------------------------------------");
		System.out.print("                                 "+(i+1)+" .");	
		questions.get(i).afficher();	
		System.out.println("                          -------------------------------------------------------");
		}
		
	}
	public ArrayList<Question> genererQuestions()
	{
		ArrayList <Question> quizQuestionRandom = new ArrayList<Question>();
		ArrayList <Question> quizQuestion = new ArrayList<Question>();
		

		for(int j=0;j<nbQuestionNotion.size();j++)
		    {
		    	quizQuestionRandom=notions.get(j).listeQuestion(nbQuestionNotion.get(j));
		    	for(int k=0;k<quizQuestionRandom.size();k++)
		    	{
		    		quizQuestion.add(quizQuestionRandom.get(k));
		    	}
		    }
		return quizQuestion;

	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public int nbQuestion()
	{
		return questions.size();
	}
	/*public Question question(int id)
	{
		return questions.get(id);
	}*/
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public boolean ouvert()
	{
		return (this.dateDebut.compareTo(new Date())<0);
	}
	/////////////////////////////// Modification /////////////////////////////////////////
	
	
	public void modifierNom(String nom)
	{
		this.nom=nom;
	}
	public void modifierDateFin(Date date)
	{
		dateFin=date;
	}
	public void modifierDateDebut(Date date) 
	{
		dateDebut=date;
	}
	public void supprimerQuestion(int i)
	{
		int nbQuestion=this.nbQuestionNotion.get(notions.indexOf((questions.get(i).getNotion())));
		questions.remove(i);
		if (nbQuestion==1)
		{
			nbQuestionNotion.remove(notions.indexOf((questions.get(i).getNotion())));
			notions.remove(notions.indexOf((questions.get(i).getNotion())));
			
		}
		else
			this.nbQuestionNotion.set(notions.indexOf((questions.get(i).getNotion())),nbQuestion--);
		//si les notions 5lasso
	}
	public void ajouterQuestion(Notion notion)
	{
		if(!notions.contains(notion))
		{
			notions.add(notion);
			nbQuestionNotion.add(1);
		}
		else
		{
			int nbQuestion=nbQuestionNotion.get(notions.indexOf(notion))+1;
			this.nbQuestionNotion.set(notions.indexOf(notion),nbQuestion);
		}
		ArrayList <Question>RandomQuestion= new ArrayList <Question>(notion.listeQuestion(1));
		while(questions.contains(RandomQuestion.get(0)))
		{
			RandomQuestion=notion.listeQuestion(1);
		}
		questions.add(RandomQuestion.get(0));
		
	}
	
	public void changerQuestion(int idQuestion)
	{
		ArrayList <Question>RandomQuestion= new ArrayList <Question>(questions.get(idQuestion).getNotion().listeQuestion(1));
		while(questions.contains(RandomQuestion.get(0)))
		{
			RandomQuestion=questions.get(idQuestion).getNotion().listeQuestion(1);
		}
		
		questions.set(idQuestion,RandomQuestion.get(0));
	}
	public boolean isExpire(Date o) {
		if(dateFin.compareTo(o)<0)
			return true;
			else return false;
		
	}
	
}