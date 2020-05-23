package wsRest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.jdt.internal.compiler.batch.Main;

import beans.Panier;
import beans.client;
import beans.livre;
import jdk.nashorn.internal.objects.annotations.Getter;
import wsDao.functions;

@Path("demandes")

public class demandes {
	
@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("somme/{a}/{b}")

public int add(@PathParam("a")int a,@PathParam("b")int b) {
	return a+b;
}
	
//============================ afficher tous les livres ===================== verifié
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("afficheAll")
	public livre[] afficheAll(){
		functions f=new functions();
		return f.afficheAll();
	}
//*********************************************rechercher livre nom ******************************************
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("getRec/{M}")
	public livre[] getRec(@PathParam("M")String M){
		functions f=new functions();
		return f.getRec(M);
		}
	
//****************************************************** select livre id ************************************** verifié
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("selectLivreId/{id}")

	public livre selectLivreId(@PathParam("id")int id){
		functions f=new functions();
		return f.selectLivreId(id);
	}
//============================ add livre to database ========================== vérifié 
	/*
	 EXEMPLE vérifié en main:
	  ======================
		  livre l=new livre("mossabhello","Auteur","ozeifhzoeifhzeofhi",120,"merzfhzerfzf");
			demandes d=new demandes();
			
			int i=d.ajouterLivre(l);
			if(i!=0) {
				System.out.println("bien ajouté");
			}else {
				System.out.println("erreur");
			} 
	 */
@POST
@Produces(MediaType.TEXT_PLAIN)
@Path("ajouterLivre/{l}")
	public int ajouterLivre(@PathParam("l")livre l) {
		functions f=new functions();
		return f.ajouterLivre(l);
	}
	//============================ Edit livre ===================================== verifié
@PUT
@Produces(MediaType.TEXT_PLAIN)
@Path("editLivre/{l}")
	public int editLivre(@PathParam("l")livre l) {
		functions f=new functions();
		return f.editLivre(l);
	}
	//=========================== delete livre from database ======================= verifié
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("supprimerLivre/{id}")
	public void supprimerLivre(@PathParam("id")int id) {
		functions f=new functions();
		f.supprimerLivre(id);
	}
	//********************************************** rechercher client Email/password ***********************************************
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("recClient/{email}/{password}")
	public client recClient(@PathParam("email")String email,@PathParam("password")String password){
		functions f=new functions();
		return f.recClient(email, password);
	}
//========================== verifier existance d'un email ================================
@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("verifEmail/{Email}")

	public int verifEmail(@PathParam("Email")String Email) {
		functions f=new functions();
		return f.verifEmail(Email);
		 }
//======================= verifier existance d'un code bancaire ============================
@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("verifCB/{cb}")

	public boolean verifCB(@PathParam("cb")int cb) {
		functions f=new functions();
		return f.verifCB(cb);
	}
//================================= créer client compte =====================================
@PUT
@Produces(MediaType.TEXT_PLAIN)
@Path("ClientNewCompte/{c}")
	public boolean ClientNewCompte(@PathParam("c")client c) {
		functions f=new functions();
		return f.ClientNewCompte(c);
	}
//=================================== Ajouter panier ====================================
@PUT
@Produces(MediaType.TEXT_PLAIN)
@Path("ajouterP/{idc}/{idl}/{qte}")
	public int ajouterP(@PathParam("idc")int idc,@PathParam("idl")int idl,@PathParam("qte")int qte) {
		functions f=new functions();
		return f.ajouterP(idc, idl, qte);
	}
//------------------------------------------------------------------
@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("selectDernierPanier")
public int selectDernierPanier() {
		functions f=new functions();
		return f.selectDernierPanier();
	}
//=================================== les livres et l'id panier et qte de tout livre d'un clients qui sont en panier =====================
@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("selectLivreC/{idc}")
public Panier[] selectLivreC(@PathParam("idc")int idc){
		functions f=new functions();
		return f.selectLivreC(idc);
}
}
