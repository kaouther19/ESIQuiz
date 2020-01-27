import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import compte.*;
import formation.*;
import examination.*;
import evaluation.*;

public class EsiQuiz {

	public static void main(String[] args) {
		/* Déclaration des variable */
		Scanner sc = new Scanner(System.in);
		Scanner sci = new Scanner(System.in);
		//--------------------------------------//
		System.out.println("									       -----------------------------------------------");
		System.out.println("									       |                                             |");
		System.out.println("										   |         TP POO N° 1 : ESIQuiz               |");
		System.out.println("										   |                                             |");
		System.out.println("									       |        Réalisé par: BOULAOUINAT kaouther    |");
		System.out.println("									       |                   : REBAHI Nour-El-Intissar |");
		System.out.println("									       -----------------------------------------------");
	    System.out.println("\n");
		
		System.out.println("									----------------------------------------------------------------------------------");
		System.out.println("									|                                                                                 |");
		System.out.println("									|        Remarque: aprés avoir lire le cours d'interface graphique                |");
		System.out.println("									|        Ona constaté que gérer les exceptions va se changer selon l'interface    |");
		System.out.println("									|        d'ou on a décidé de ne pas les gérer jusqu'à la partie graphique         |");
		System.out.println("									|                   On s'éxcuse de l'affichage                                    |");
		System.out.println("									----------------------------------------------------------------------------------");
		
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------");    
	    System.out.println("		 			|                  Creation de la formation,formateur,Les apprenants les notionset les questions                     |");
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------"); 
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------");    
	    System.out.println("		 			|                                                                                                                   |");
	    System.out.println("		 			|    *Dans cette partie les informations sont données dans le code source (Pas de sésie d'information)              |");                               
	    System.out.println("		 			|                                                                                                                   |");
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------");
	    /*------- Creation du compte de formateur ---------*/
	    System.out.println("\n");
	    System.out.println("                            1.creation du compte de formateur.");
	    String nom="BOUSBIA";
	    String prenom="NABILA";
	    String adress="aaaaaaaaaa";
	    Calendar cal =Calendar.getInstance();
		cal.set(1990, 5, 20);
		Date date=cal.getTime();
	    CompteFormateur formateur= new CompteFormateur(nom,prenom,date,adress,"hooooo");
		//------------------------------------------------//
		/*-------- Creation de la formation --------------*/
	    System.out.println("                             2.creation de la formation.");
	    Formation formation;
	    String nomF="POO";
	    String desc ="Programmation oriontée objet";
		cal.set(2019, 5, 20);
		Date dateD=cal.getTime(); 
		cal.set(2020,6, 20);
		Date dateF=cal.getTime(); 
	    formation= new Formation(nomF,desc,dateD,dateF);
	    formateur.creeFormation(formation);
	   //------------------------------------------------//
	   /*-------- Creation de la liste des apprenants --------------*/
	    System.out.println("                             3.creation des comptes des apprenant. \n");
	   
	    ArrayList<CompteApprenant> apprenants= new ArrayList<CompteApprenant>();
	    nom="Benguessoum";
	    prenom="Kaouther";
		adress="bbbbbbbbbb";
		cal.set(1999, 9,15);
		date=cal.getTime(); 
	    apprenants.add(new CompteApprenant(nom,prenom,date,adress));
	    apprenants.get(0).afficher();
	    
	    nom="Boulaouinat";
	    prenom="Kaouther";
		adress="cccccccccc";
		cal.set(1999, 8, 20);
		date=cal.getTime(); 
		apprenants.add(new CompteApprenant(nom,prenom,date,adress));
		apprenants.get(1).afficher();
	 
	    nom="Rebahi";
	    prenom="Nour_El_Intissar";
		adress="dddddddddd";
		cal.set(2000, 10, 11);
		date=cal.getTime(); 
		apprenants.add(new CompteApprenant(nom,prenom,date,adress));
		apprenants.get(2).afficher();
		
	    formation.setApprenants(apprenants);
	   //-----------------------------------------------------------//
	   /*-------- Creation des notions de la formations --------------*/
	    System.out.println("                    4.creation des notions.");
	    ArrayList<Notion> notions= new ArrayList<Notion>();
	    notions.add(new Notion("notion1"));
	    notions.add(new Notion("notion2"));
	    notions.add(new Notion("notion3"));
	    ArrayList<Question> questions= new ArrayList<Question> ();
	    ArrayList<Proposition> propositions= new ArrayList<Proposition> ();	
	    propositions.add(new Proposition("Polymorphisme",true));
	    propositions.add(new Proposition("héritage",true));
	    propositions.add(new Proposition("encapsulation",true));
	    propositions.add(new Proposition("procédurale",false));
	    questions.add(new QCM(notions.get(0),"Quelle sont les concept de poo",propositions));
	    propositions.clear();
	    propositions.add(new Proposition("vrai",false));
	    propositions.add(new Proposition("faux",true));
	    questions.add(new QCU(notions.get(0),"Set accepte les doublons",propositions));
	    HashSet<String> prop= new HashSet<String> ();
	    prop.add("Set");
	    prop.add("List");
	    prop.add("Queue");
	    questions.add(new QO(notions.get(0),"citer une collection en java.",prop));
	    notions.get(0).introListQuestion(questions);
	    notions.get(0).afficher();
	    ///
	    questions.clear();
	    propositions.clear();
	    propositions.add(new Proposition("procédural",true));
	    propositions.add(new Proposition("orionté objet",true));
	    propositions.add(new Proposition("logique",true));
	    propositions.add(new Proposition("fonctionnelle",true));
	    propositions.add(new Proposition("Mathémathique",false));
	    questions.add(new QCM(notions.get(1),"Quelle sont les prédigme de programmation?",propositions));
	    propositions.clear();
	    propositions.add(new Proposition("est une classe abstraite",true));
	    propositions.add(new Proposition("est classe utilitaire",false));
	    propositions.add(new Proposition("est une classe static",false));
	    questions.add(new QCU(notions.get(1),"Une classe qui contient une méthode abstraite",propositions));
	    prop.clear();
	    prop.add("Java Vertual Machine ");
	    questions.add(new QO(notions.get(1),"c'est quoi la JVM",prop));
	    notions.get(1).introListQuestion(questions);
	    notions.get(1).afficher();
	    ///
	    questions.clear();
	    propositions.clear();
	    propositions.add(new Proposition("public",true));
	    propositions.add(new Proposition("private",true));
	    propositions.add(new Proposition("protected",true));
	    propositions.add(new Proposition("néant",true));
	    propositions.add(new Proposition("final",false));
	    questions.add(new QCM(notions.get(2),"Quelle sont les mode d'accée à un attribut",propositions));
	    propositions.clear();
	    propositions.add(new Proposition(" les interfaces",true));
	    propositions.add(new Proposition(" les énumération",false));
	    propositions.add(new Proposition(" les classes",false));
	    questions.add(new QCU(notions.get(2),"L'héritage hybride est toléré dans:",propositions));
	    propositions.clear();
	    propositions.add(new Proposition(" des différentes classes de la meme héarchie",true));
	    propositions.add(new Proposition(" dans la meme classe ",false));
	    propositions.add(new Proposition(" des différentes classes de la meme héarchie et dans la meme classe ",false));
	    questions.add(new QCU(notions.get(2),"La redéfinition  est toléré dans:",propositions));
	    propositions.clear();
	    propositions.add(new Proposition(" les classes de meme héarchie et dans la meme classe",true));
	    propositions.add(new Proposition(" la meme classe seulement",false));
	    propositions.add(new Proposition(" la meme classe seulmement  ",false));
	    questions.add(new QCU(notions.get(2),"La surdéfinition est tolérée dans:",propositions));
	    prop.clear();
	    prop.add("l'interface de la classe");
	    prop.add("l'interface");
	    questions.add(new QO(notions.get(2),"Que représente les membres public d'une classe: ",prop));
	    notions.get(2).introListQuestion(questions);
	    notions.get(2).afficher();
        /*------------------------------Creation  d'un quiz -----------*/
	    System.out.println("                    5.creation des quiz.");
	    ArrayList <Quiz>quizs= new ArrayList<Quiz>();
	    ArrayList <Integer>nbQuestion=new ArrayList<Integer>();
		nbQuestion.add(1);
		nbQuestion.add(2);
		nbQuestion.add(1);
		cal.set(2019, 5, 20);
		dateD=cal.getTime(); 
		cal.set(2019,7, 12);
		dateF=cal.getTime(); 
		quizs.add(new Quiz("Quiz1",notions,nbQuestion,dateD,dateF));
		quizs.get(0).afficher();
		nbQuestion.clear();
		//
		nbQuestion.add(2);
		nbQuestion.add(2);
		nbQuestion.add(1);
		cal.set(2019, 6, 20);
		dateD=cal.getTime(); 
		cal.set(2019,7, 28);
		dateF=cal.getTime();
		quizs.add(new Quiz("Quiz2",notions,nbQuestion,dateD,dateF));
		quizs.get(1).afficher();
		nbQuestion.clear();
		//
		nbQuestion.add(2);
		nbQuestion.add(1);
		nbQuestion.add(1);
		cal.set(2020, 5, 1);
		dateD=cal.getTime(); 
	    cal.set(2020,6, 28);
		dateF=cal.getTime();		    
		quizs.add(new Quiz("Quiz3",notions,nbQuestion,dateD,dateF));
		quizs.get(2).afficher();
		//  
		cal.set(2019, 5, 20);
		dateD=cal.getTime(); 
		cal.set(2019,6, 28);
		dateF=cal.getTime();
		System.out.println("                              * Modification d'un quiz");	
	    System.out.println("				                 1.Modification de titre.");
	    quizs.get(2).modifierNom("QuizM");
		System.out.println("                                 2.Modification de date d'ouverture.");
		quizs.get(2).modifierDateDebut(dateD);
		System.out.println("                                 3.Modification de date d'expiration.");
	    quizs.get(2).modifierDateFin(dateF);
	    System.out.println("                                 4.Suppression d'une question: Question 3");
	    quizs.get(2).supprimerQuestion(2);
	    System.out.println("                                 5.Ajout d'une question.");
	    quizs.get(2).ajouterQuestion(notions.get(1));
	    System.out.println("                                 6.Changement d'une question: question 1");
	    quizs.get(2).changerQuestion(0);
	    System.out.println("                               * Quiz aprés changement.");
	    quizs.get(2).afficher();
	    //	
	    formateur.creerQuiz(quizs.get(0));
	    formateur.creerQuiz(quizs.get(1));
	    formateur.creerQuiz(quizs.get(2));
	    System.out.println("                               * Validation des quiz par le formateur pour qu'ils seront accessible par l'apprenant dans la formation.");
	    formateur.validerQuiz(0);
	    formateur.validerQuiz(0);
	    formateur.validerQuiz(0);
	    
	    //------------------------------------------------------------//
	    //	
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------");    
	    System.out.println("		 		   |                                            Accées d'apprenant au quiz                                               |");
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------"); 
	    System.out.println("                                   * Accée d'un apprenant aux Quiz");
	    CompteApprenant compte=formation.seConnecter("KBoulaouinat", "Boulaouinat20091999");
	    System.out.println("                                   * L'apprenant va repondre au quiz");
	    System.out.println("                                    1. Reponse de quiz1, ce quiz est accomplità 100% et il'est validé par l'apprenant 1");
	    compte.afficherReponseQuiz(0);
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------");    
	    System.out.println("		 			|                                                    Reponse de ce quiz                                              |");
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------"); 
	    
	    for(int i=0;i<compte.reponseQuiz(0).getQuiz().nbQuestion();i++) 
	    {
	    	compte.reponseQuiz(0).getReponse(i).afficher();
	    	switch(compte.reponseQuiz(0).getReponse(i).typeQuestion()){    
	    		case 1:    
	    		  {System.out.println("                                    Choisir les bonnes réponses:vous devez introduire un seule choix à la fois");
	    		  boolean stop=false;
	    		  int j=0;
	    		  ArrayList<Integer> choix=new  ArrayList<Integer>();
	    		  int c;
	    		  while(!stop && j<((Rqcm)compte.reponseQuiz(0).getReponse(i)).nbPropositions())
	    		  {
	    			 c=sc.nextInt()-1;
	    			 if(choix.contains(c))
	    			 {
	    				 System.out.println("                                   Réponse déja choisie");
	    			 }
	    			 else
	    			 {
	    				 choix.add(c);
	    				 j++;
	    				 if(j<((Rqcm)compte.reponseQuiz(0).getReponse(i)).nbPropositions())
	    				 {System.out.println("                                   Vous voulez choisir une autre réponses? 1.OUI 0.NON");
	    				 c=sc.nextInt();
	    				 if(c==0)
	    				 {
	    					 stop=true;
	    					 
	    				 }
	    				 }
	    			 }
	    		  }
	    		  ((Rqcm)compte.reponseQuiz(0).getReponse(i)).repondre(choix);}
	    		break;    
	    		case 0:    
	    			{System.out.println("                                    Choisir la bonne réponse.");
	    			 int choix =sc.nextInt()-1;
	    			((Rqcu)compte.reponseQuiz(0).getReponse(i)).repondre(choix);}
	    		break;   
	       
	    		case -1:    
	    			{String r=sci.nextLine();
	    			((Rqo)compte.reponseQuiz(0).getReponse(i)).repondre(r);}
		        break;  
	        
	       
	    } 
	    }
	    
	    System.out.println("                                    On valide les repones");
	    compte.reponseQuiz(0).valider();
	    System.out.println("                               * Accée d'un autre apprenant aux Quiz");
	     compte=formation.seConnecter("NRebahi", "Rebahi11112000");
	    System.out.println("                               * Cet apprenant va repondre au quiz");
	    System.out.println("                               1. Reponse de quiz2, ce quiz est accomplité 50% et il'est validé par l'apprenant 2");
	    compte.afficherReponseQuiz(1);
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------");    
	    System.out.println("		 			|                                                    Reponse de ce quiz                                              |");
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------"); 
	    for(int i=0;i<compte.reponseQuiz(1).getQuiz().nbQuestion()/2;i++) 
	    {
	    	compte.reponseQuiz(1).getReponse(i).afficher();
	    	switch(compte.reponseQuiz(1).getReponse(i).typeQuestion()){    
	    		case 1:    
	    		  {System.out.println("                                    Choisir les bonnes réponses: vous devez introduire un seule choix à la fois ");
	    		  boolean stop=false;
	    		  int j=0;
	    		  ArrayList<Integer> choix=new  ArrayList<Integer>();
	    		  int c;
	    		  while(!stop && j<((Rqcm)compte.reponseQuiz(1).getReponse(i)).nbPropositions())
	    		  {
	    			 c=sc.nextInt()-1;
	    			 if(choix.contains(c))
	    			 {
	    				 System.out.println("                                   Réponse déja choisie");
	    			 }
	    			 else
	    			 {
	    				 choix.add(c);
	    				 j++;
	    				 if(j<((Rqcm)compte.reponseQuiz(1).getReponse(i)).nbPropositions())
	    				 {System.out.println("                                   Vous voulez choisir une autre réponses? 1.OUI 0.NON");
	    				 c=sc.nextInt();
	    				 if(c==0)
	    				 {
	    					 stop=true;
	    					 
	    				 }
	    				 }
	    			 }
	    		  }
	    		  ((Rqcm)compte.reponseQuiz(1).getReponse(i)).repondre(choix);}
	    		break;    
	    		case 0:    
	    			{System.out.println("                                    Choisir la bonne réponse.");
	    			 int choix =sc.nextInt()-1;
	    			((Rqcu)compte.reponseQuiz(1).getReponse(i)).repondre(choix);}
	    		break;   
	       
	    		case -1:    
	    			{String r=sci.nextLine();
	    			((Rqo)compte.reponseQuiz(1).getReponse(i)).repondre(r);}
		        break;  
	        
	       
	    } 
	    }
	    
	    System.out.println("                                    On valide les repones");
	    compte.reponseQuiz(1).valider();
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------");    
	    System.out.println("		 			|                                             Consultation de l'activité                                             |");
	    System.out.println("		 			---------------------------------------------------------------------------------------------------------------------"); 
	    
	    
	    formateur.consulterActivite(1);
	    formateur.afficherReponseApprenant(1,0);
}}

