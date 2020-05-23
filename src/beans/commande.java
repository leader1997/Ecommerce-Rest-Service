package beans;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Commande")
@XmlAccessorType(XmlAccessType.FIELD)

public class commande implements Serializable{
	private int id;
	private Date  date;
	private int quantite;
	
	public int getL() {
		return id;
	}
	public void setId(int l) {
		id = l;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "commande [id=" + id + ", quantite=" + quantite + "]";
	}
	
	
}
