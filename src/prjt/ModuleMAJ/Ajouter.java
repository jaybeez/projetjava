/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjt.ModuleMAJ;

import java.sql.SQLException;
import java.util.ArrayList;
import prjt.Connexion;
import prjt.Objet.Chambre;
import prjt.Objet.Docteur;
import prjt.Objet.Hospitalisation;
import prjt.Objet.Infirmier;
import prjt.Objet.Malade;
import prjt.Objet.Service;
import prjt.Objet.Soigne;

/**
 *
 * @author Arthur
 */
public class Ajouter {
    
    public Ajouter(Chambre chambre, Connexion Co) throws SQLException, AlreadyInTableException
    {
        ArrayList<String> Check = Co.remplirChampsRequete("SELEC(*) FROM chambre WHERE code_service = " 
                + chambre.getCodeService() + " AND no_chambre = "
                + String.valueOf(chambre.getNumero()), "/");
        if (Check.get(0) != null)
            throw new AlreadyInTableException();
        
        Co.getStmt().executeQuery("insert into chambre values ('"
                + chambre.getCodeService() + "'," + String.valueOf(chambre.getNumero()) + "," 
                + String.valueOf(chambre.getSurveillant()) + "," + String.valueOf(chambre.getNb_lits()) + ")");
    }   
    
    public Ajouter(Docteur docteur, Connexion Co) throws SQLException, AlreadyInTableException
    {
        ArrayList<String> Check = Co.remplirChampsRequete("SELEC(*) FROM docteur WHERE numero = " 
                + String.valueOf(docteur.getNumero()), "/");
        if (Check.get(0) != null)
            throw new AlreadyInTableException();
        
        Co.getStmt().executeQuery("insert into employe values ("
                + docteur.getNumero() + ","
                + "'" + docteur.getNom() + "'" 
                + "'" + docteur.getPrenom() + "'" 
                + "'" + docteur.getAdresse()+ "'" 
                + "'" + docteur.getTelephone()+ "')");
        
        Co.getStmt().executeQuery("insert into docteur values ("
                + docteur.getNumero() + ","
                + "'" + docteur.getSpecialite() + "')");
    }  
    
    public Ajouter(Infirmier infirmier, Connexion Co) throws SQLException, AlreadyInTableException
    {
        ArrayList<String> Check = Co.remplirChampsRequete("SELEC(*) FROM infirmier WHERE numero = " 
                + String.valueOf(infirmier.getNumero()), "/");
        if (Check.get(0) != null)
            throw new AlreadyInTableException();
        
        Co.getStmt().executeQuery("insert into employe values ("
                + infirmier.getNumero() + ","
                + "'" + infirmier.getNom() + "'" 
                + "'" + infirmier.getPrenom() + "'" 
                + "'" + infirmier.getAdresse()+ "'" 
                + "'" + infirmier.getTelephone()+ "')");
        
        Co.getStmt().executeQuery("insert into infirmier values ("
                + infirmier.getNumero() + ","
                + "'" + infirmier.getCodeService() + "'" 
                + "'" + infirmier.getRotation()+ "'" 
                + "'" + infirmier.getSalaire()+ "')");
    }   
    
    public Ajouter(Hospitalisation hos, Connexion Co) throws SQLException, AlreadyInTableException
    {
        ArrayList<String> Check = Co.remplirChampsRequete("SELEC(*) FROM hospitalisation WHERE no_malade = " 
                + String.valueOf(hos.getNoMalade()) + " AND code_service = "
                + hos.getCodeService(), "/");
        if (Check.get(0) != null)
            throw new AlreadyInTableException();
        
        Co.getStmt().executeQuery("insert into hospitalisation values ("
                + hos.getNoMalade()+ ","
                + "'" + hos.getCodeService()+ "'" 
                + "'" + hos.getNumero_chambre()+ "'" 
                + "'" + hos.getLit()+ "')");
    }   
    
    public Ajouter(Service serv, Connexion Co) throws SQLException, AlreadyInTableException
    {
        ArrayList<String> Check = Co.remplirChampsRequete("SELEC(*) FROM service WHERE code = " 
                + serv.getCode(), "/");
        if (Check.get(0) != null)
            throw new AlreadyInTableException();
        
        Co.getStmt().executeQuery("insert into service values ("
                + serv.getCode()+ ","
                + "'" + serv.getNom() + "'" 
                + "'" + serv.getBatiment() + "'" 
                + "'" + serv.getDirecteur() + "')");
    }
       
    public Ajouter(Soigne soigne, Connexion Co) throws SQLException, AlreadyInTableException
    {
        ArrayList<String> Check = Co.remplirChampsRequete("SELEC(*) FROM soigne WHERE no_docteur = " 
                + String.valueOf(soigne.getNoDocteur()) + " AND no_malade = "
                + soigne.getNoMalade(), "/");
        if (Check.get(0) != null)
            throw new AlreadyInTableException();
        
        Co.getStmt().executeQuery("insert into soigne values ("
                + soigne.getNoDocteur()+ ","
                + "'" + soigne.getNoMalade() + "')");
    }
}
