package service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement   
public class Etudiant implements Serializable{
	private double code;
	private String nom;
	public Etudiant(double code, String nom, String prenom) {
		
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	private String prenom;
	public double getCode() {
		return code;
	}
	public void setCode(double code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	
	

}
