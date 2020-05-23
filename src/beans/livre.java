package beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Livre")
@XmlAccessorType(XmlAccessType.FIELD)

public class livre implements Serializable{
	private int id;
	private String nom;
	private String auteur;
	private String description;
	private String categorie;
	private int prix;
	private String image;
	
	public livre() {
		
	}
	
	public livre(int id,String nom, String auteur, String description, int prix, String image) {
		this.id = id;
		this.nom = nom;
		this.auteur = auteur;
		this.description = description;
		this.prix = prix;
		this.image = image;
	}
	public livre(String nom, String auteur, String description, int prix, String image) {
		this.nom = nom;
		this.auteur = auteur;
		this.description = description;
		this.prix = prix;
		this.image = image;
	}
	public livre(livre l) {
		this.id = l.id;
		this.nom = l.nom;
		this.auteur = l.auteur;
		this.description = l.description;
		this.prix = l.prix;
		this.image = l.image;
	}
	
	@Override
	public String toString() {
		return "livre [id=" + id + ", nom=" + nom + ", auteur=" + auteur + ", description=" + description
				+ ", categorie=" + categorie + ", prix=" + prix + ", image=" + image + "]";
	}
	
	public void afficheR() {
		System.out.println(this.toString());
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
}
