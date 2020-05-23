package beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Client")
@XmlAccessorType(XmlAccessType.FIELD)
public class client implements Serializable{
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String pwd;
	private String adresse;
	private int codeBancaire;
	
	@Override
	public String toString() {
		return "client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pwd=" + pwd
				+ ", adresse=" + adresse + ", codeBancaire=" + codeBancaire + "]";
	}
	public client(int id,String nom, String prenom, String email, String pwd, String adresse, int codeBancaire) {
		super();
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pwd = pwd;
		this.adresse = adresse;
		this.codeBancaire = codeBancaire;
	}
	public client(String nom, String prenom, String email, String pwd, String adresse, int codeBancaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pwd = pwd;
		this.adresse = adresse;
		this.codeBancaire = codeBancaire;
	}
	public client() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodeBancaire() {
		return codeBancaire;
	}
	
	public void setCodeBancaire(int int1) {
	}
	
}
