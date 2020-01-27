package compte;

import java.io.Serializable;
import java.util.*;

public abstract class Compte implements Serializable
{
	//private  static  final  long serialVersionUID =  1350092881346723535L;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String adress;
	private String login;
	private String motDePasse;
	public Compte(String nom,String prenom,Date dateDeNaissance,String adress)
	{
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setDateDeNaissance(dateDeNaissance);
		this.setAdress(adress);
		
	}
	
	public boolean seConnecter(String login, String motDePasse)
	{
		return (login.compareTo(this.login)==0 && motDePasse.compareTo(this.motDePasse)==0);
	}
	
	public void seDeconnecter()
	{
		// effacer screen et afficher la page d'authentification
	}
	public void modifMotDePass(String mot)
	{
		motDePasse=mot;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public boolean setMotDePasseEstVrai(String motDePasse)
	{
		return (motDePasse==this.motDePasse);
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getLogin() 
	{
		return login;
	}
	public void setLogin(String login) 
	{
		this.login =login ;
	}
	
}
