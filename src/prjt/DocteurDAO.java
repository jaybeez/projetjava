package prjt;

import prjt.Connexion;
import prjt.Objet.Docteur;
import graphique.Fenetre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DocteurDAO extends DAO<Docteur> {
    
        @Override
	public Docteur create(Docteur obj) {
            boolean ok;
            Docteur aux;
            Connexion conn=Fenetre.getConn();
		try {
			 conn.setRset(conn.getStmt().executeQuery("select * from employe"));
			

		    } catch (SQLException ex) {
		            ex.printStackTrace();
                            Logger.getLogger(Docteur.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Le calcul du nombre d'élément s'est mal passé", "Message d'erreur", JOptionPane.ERROR_MESSAGE);

		    }
		   int Lignes=0;
         try {
             Lignes = conn.getRset().getRow();
         } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Pb lignes", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
         }
	
	/*//Verification de l'existence du docteur
       for(int i=1;i<=Lignes;i++){
        aux=find(i,false);
        if(docteur.getNom().compareTo(aux.getNom())==0 &&
           docteur.getPrenom().compareTo(aux.getPrenom())==0 &&
           docteur.getTel().compareTo(aux.getTel())==0) 
            autorisation=false;
       }*/Docteur x=null;
        return x;
        }
        
        public Docteur findDocteur(int id,boolean popup){
        //Selection si ca se passe mal : retourner null
        Connexion conn=Fenetre.getConn();
            try {
         
                conn.setRset(conn.getStmt().executeQuery("SELECT * from employe where employe.numero="+Integer.toString(id)));
            } catch (SQLException ex) {
                Logger.getLogger(DocteurDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "probleme de connexion avec la bdd", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            //Construction de l'enregistrement trouvé
             Docteur docteur=new Docteur();

             try {
                   //Si pas de resultat on retourne null
            
            if(!conn.getRset().first()) {
               if(popup) JOptionPane.showMessageDialog(null, "Cet identifiant n'existe pas", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
                return null;
            }
      
           
       
        } catch (SQLException ex) {
            Logger.getLogger(DocteurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
             
        return docteur; }
        
        
        
        
        
        
        
        
        
        
        
        
	@Override
	public Docteur update(Docteur obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE langage SET lan_nom = '" + obj.getNom() + "'"+
                    	" WHERE lan_id = " + obj.getId()
                     );
			
			obj = this.find(obj.getId());
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    
	    return obj;
	}

@Override
	public void delete(Docteur obj) {
		try {
			
                this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM langage WHERE lan_id = " + obj.getId()
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
	
	
}