package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Panier")
@XmlAccessorType(XmlAccessType.FIELD)

public class Panier implements Serializable{
	
	@Override
	public String toString() {
		return "Panier [idp=" + idp + ", Livre=" + Livre + ", qte=" + qte + "]";
	}

	private int idp;
	private livre Livre;
	private int qte;
	
	public Panier(int idp, livre livre, int qte) {
		super();
		this.idp = idp;
		Livre = livre;
		this.qte = qte;
	}
	public Panier(livre livre, int qte) {
		
		Livre = livre;
		this.qte = qte;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Panier() {
		
	}
	
	public Panier(int idp, livre livre) {
		super();
		this.idp = idp;
		Livre = livre;
	}

	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public livre getLivre() {
		return Livre;
	}

	public void setLivre(livre livre) {
		Livre = livre;
	}
	
	
	
	
	
}
