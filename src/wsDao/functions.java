package wsDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


import beans.Panier;
import beans.client;
import beans.livre;

public class functions {
//============================ afficher tous les livres ===================== verifié

	public livre[] afficheAll(){
		
		dbInteraction.connect();
		ResultSet res=dbInteraction.Select("select * from livres" );
		
		ResultSet res1=res;
		int rsCount=0;
		
		try {
			while(res1.next()) {
				rsCount++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		res=dbInteraction.Select("select * from livres" );
		livre[] A=new livre[rsCount];
		
		try {
			int i=0;
			
		while (res.next()) {
			livre L=new livre();
			L.setId(res.getInt(1));
			L.setNom(res.getString(2));
			L.setAuteur(res.getString(3));
			L.setDescription(res.getString(4));
			L.setPrix(res.getInt(5));
			L.setImage(res.getString(6));
			
			A[i]=L;
			i++;
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		
		dbInteraction.disconnect();
		return A;
	}
//*********************************************rechercher livre nom ******************************************
	public livre[] getRec(String M){
			
			dbInteraction.connect();
			ResultSet res=dbInteraction.Select("select * from livres where upper(nom) like upper('%"+M+"%')" );
			
			ResultSet res1=res;
			
			int rsCount=0,i=0;
			System.out.println(rsCount);
			try {
				while(res1.next()) {
					rsCount++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			res=dbInteraction.Select("select * from livres where upper(nom) like upper('%"+M+"%')" );
			livre[] A=new livre[rsCount];
			System.out.println(rsCount+" |  size of table :"+A.length);
			try {
			while (res.next()) {
				livre L=new livre();
				System.out.println(i);
				L.setId(res.getInt(1));
				L.setNom(res.getString(2));
				L.setAuteur(res.getString(3));
				L.setDescription(res.getString(4));
				L.setPrix(res.getInt(5));
				L.setImage(res.getString(6));
				A[i]=L;
				
				System.out.println("step"+i+" | "+A[i].toString());
				
				i++;
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			dbInteraction.disconnect();
			return A;
		}
	
//****************************************************** select livre id ************************************** verifié
	public livre selectLivreId(int id){
		dbInteraction.connect();
		ResultSet res=dbInteraction.Select("select * from livres where id="+id);
		livre L=new livre();
		try {
			while(res.next()) {
				L.setId(res.getInt(1));
				L.setNom(res.getString(2));
				L.setAuteur(res.getString(3));
				L.setDescription(res.getString(4));
				L.setPrix(res.getInt(5));
				L.setImage(res.getString(6));
				}
			}
			catch(Exception e) {
			System.out.println("a fuck u rah matle3ch ");
		}
		dbInteraction.disconnect();
		return L;
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

	public int ajouterLivre(livre l) {
		dbInteraction.connect();
		
		String nom=l.getNom();
		String auteur=l.getAuteur();
		String desc=l.getDescription();
		int prix=l.getPrix();
		String image=l.getImage();
		
		String sql="insert into livres(nom,auteur,description,prix,image) values('"+nom+"','"+auteur+"','"+desc+"',"+prix+",'"+image+"')";
		int i=dbInteraction.Maj(sql);
		
		dbInteraction.disconnect();
		return i;
	}
	//============================ Edit livre ===================================== verifié

	public int editLivre(livre l) {
		dbInteraction.connect();
		String sql="update  livres set nom='"+l.getNom()+"',auteur='"+l.getAuteur()+"',description='"+l.getDescription()+"',prix="+l.getPrix()+",image='"+l.getImage()+"' where id="+l.getId()+"";
		int i=dbInteraction.Maj(sql);
		dbInteraction.disconnect();
		return i;
	}
	//=========================== delete livre from database ======================= verifié

	public void supprimerLivre(int id) {
		dbInteraction.connect();
		String sql="delete from livres where id="+id;
		dbInteraction.Maj(sql);
		dbInteraction.disconnect();
	}
	//********************************************** rechercher client Email/password ***********************************************
	public client recClient(String email,String password){
		dbInteraction.connect();
		ResultSet res=dbInteraction.Select("select * from clients where email='"+email+"' and pwd='"+password+"'");
		client c=new client();
		if(res!=null) {
			
		try {
			while(res.next()) {
				c.setId(res.getInt(1));
				c.setAdresse(res.getString(5));
				c.setEmail(res.getString(4));
				c.setPwd(res.getString("pwd"));
				c.setNom(res.getString(2));
				c.setPrenom(res.getString(3));
				c.setCodeBancaire(res.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		dbInteraction.disconnect();	
		return c;
	}
//========================== verifier existance d'un email ================================

	public int verifEmail(String Email) {
		dbInteraction.connect();
		String sql="select id from clients where email='"+Email+"'";
		System.out.println(sql);
		ResultSet res=dbInteraction.Select(sql);
		dbInteraction.disconnect();
		int id=-1;
		
			try {
				while(res.next()) {
					id=res.getInt(1);
				}
			} catch (SQLException e) {
				return id;
			}
		return id;
		 }
//======================= verifier existance d'un code bancaire ============================

	public boolean verifCB(int cb) {
		dbInteraction.connect();
		String sql="select * from clients where cbanque="+cb+"";
		ResultSet res=dbInteraction.Select(sql);
		dbInteraction.disconnect();
		try {
			if(res.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
//================================= créer client compte =====================================

	public boolean ClientNewCompte(client c) {
		dbInteraction.connect();
		String sql="insert into clients(nom,prenom,email,pwd,adresse,cbanque) values('"+c.getNom()+"','"+c.getPrenom()+"','"+c.getEmail()+"','"+c.getPwd()+"','"+c.getAdresse()+"','"+c.getCodeBancaire()+"')";
		int i=dbInteraction.Maj(sql);
		dbInteraction.disconnect();
		if(i==0) {
			return false;
		}
		return true;
		
	}
//=================================== Ajouter panier ====================================

	public int ajouterP(int idc,int idl,int qte) {
		dbInteraction.connect();
		String sql="insert into panier(idC,idL,qte) values("+idc+","+idl+","+qte+")";
		int i=dbInteraction.Maj(sql);
		dbInteraction.disconnect();
		if(i==0) {
			return 0;
		}
		else {
		int k=selectDernierPanier();
		return k;
		}
	}
//------------------------------------------------------------------

public int selectDernierPanier() {
		dbInteraction.connect();
		
		String sql="select idP from panier";
		ResultSet res=dbInteraction.Select(sql);
		
		int idd=0;
		try {
			while(res.next()) {
				idd=res.getInt(1);
			}
			dbInteraction.disconnect();
			return idd;
		} catch (SQLException e) {
			return 0;
		}
	}
//=================================== les livres et l'id panier et qte de tout livre d'un clients qui sont en panier =====================

public Panier[] selectLivreC(int idc){
	dbInteraction.connect();
	ResultSet res=dbInteraction.Select("select * from panier where idC="+idc);
	
	ResultSet res1=res;
	int rsCount=0,i=0;
	
	try {
		while(res1.next()) {
			rsCount++;
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	res=dbInteraction.Select("select * from panier where idC="+idc);
	
	livre l=new livre();
	Panier[] A=new Panier[rsCount];
	try {
		while(res.next()) {
			int idL=res.getInt("idL");
			
			l=selectLivreId(idL);
			System.out.println(l.toString()+" | idL= "+idL);
			int qte=res.getInt("qte");
			int idP=res.getInt("idP");
			Panier p=new Panier(idP,l,qte);
			
			A[i]=p;
			i++;
			}
		}
		catch(Exception e) {
		System.out.println("a rah matle3ch ");
	}
	dbInteraction.disconnect();
	return A;
}}