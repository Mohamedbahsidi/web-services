package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;



@WebService
public class EtudiantService {
	
	Connection con;
	Statement etat;
	PreparedStatement pre;
	

	public EtudiantService() throws SQLException {
		
		
        // this.con.forName("com.mysql.jdbc.Driver");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecole", "root", "root");
		
		this.etat = con.createStatement();
	}
	
	@WebMethod(operationName="newetudiant")
	public boolean addEtudiant(@WebParam(name="nom")String nom,@WebParam(name="prenom")String prenom) throws SQLException {
		
		
		this.pre = this.con.prepareStatement("INSERT INTO etudiant (prenom, nom) VALUES (?, ?)");
		this.pre.setString(1, prenom);
		this.pre.setString(2, nom);
		
		 
		boolean ok = this.pre.executeUpdate() > 0 ? true : false;
		return ok;
	}
	@WebMethod(operationName="update")
	public boolean updateEtudiant(@WebParam(name="code")double code,@WebParam(name="nom")String nom,@WebParam(name="prenom")String prenom) throws SQLException {
		this.pre = this.con.prepareStatement("UPDATE etudiant SET prenom=?, nom=?  WHERE code=?");
		
			
		this.pre.setString(2, nom);
		this.pre.setString(1,prenom);
		this.pre.setDouble(3, code);
		
		
		boolean ok = this.pre.executeUpdate() > 0 ? true : false;
		
		return ok;
	}
	@WebMethod(operationName="delete")
	public boolean deleteEtudiant(@WebParam(name="code")double code) throws SQLException {
		PreparedStatement pres = this.con.prepareStatement("DELETE FROM etudiant WHERE code = ?");
		pres.setDouble(1, code);
		 
		boolean ok = pres.executeUpdate() > 0 ? true : false;
		
		return ok;
	}
	
	@WebMethod(operationName="getall")
	public List<Etudiant> getAllEtudiant() throws SQLException {
		Etudiant etudiant;
		List<Etudiant> etudiants = new ArrayList<>();
		ResultSet resultats = this.etat.executeQuery("SELECT * FROM etudiant");
		while(resultats.next()) {
			etudiant = new Etudiant();
			if(resultats.getString("nom") != null) {
				etudiant.setNom(resultats.getString("nom"));
			}
			if(resultats.getString("prenom") != null) {
				etudiant.setPrenom(resultats.getString("prenom"));
			}
			if(resultats.getString("code") != null) {
				etudiant.setCode(resultats.getDouble("code"));
			}
			
			etudiants.add(etudiant);
		}
		return etudiants;
	}
	@WebMethod(operationName="getOne")
	public  Etudiant getOne(@WebParam(name="code")double code) throws SQLException {
	
	
	  ResultSet  resultat = this.etat.executeQuery("SELECT  * FROM  etudiant   WHERE code="+code);
	  Etudiant etudiant = new Etudiant();
	  while(resultat.next()) {
			
			if(resultat.getString("nom") != null) {
				etudiant.setNom(resultat.getString("nom"));
			}
			if(resultat.getString("prenom") != null) {
				etudiant.setPrenom(resultat.getString("prenom"));
			}
			if(resultat.getString("code") != null) {
				etudiant.setCode(resultat.getDouble("code"));
			}
			
			
		}
	
		return etudiant;
	}

}
