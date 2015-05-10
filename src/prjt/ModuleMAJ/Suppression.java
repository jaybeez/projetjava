/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjt.ModuleMAJ;

import java.sql.Connection;
import java.sql.SQLException;
import prjt.Connexion;

/**
 *
 * @author Arthur
 */
public class Suppression{
        
    public Suppression(int cle, String table, Connexion Co) throws SQLException
    {
        String nomCle;
        if (table.compareToIgnoreCase("service") == 0) // code : service
            nomCle = "code";
        else if (table.compareToIgnoreCase("hospitalisation") == 0) // no_malade : hospitalisation
            nomCle = "no_malade";
        else // numero : employé docteur infirmier malade
            nomCle = "numero";
        
        Co.getStmt().executeQuery("DELETE * FROM " + table + " WHERE " + nomCle + " = " + String.valueOf(cle));

    }
    
    /* ATTENTION
       Si vous envoyez une chambre : no_chambre CLE1      code_service CLE2
       Si vous envoyez un soigne   : no_docteur CLE1      no_malade    CLE2
    */
    public Suppression(int cle1, int cle2, String table, Connexion Co) throws SQLException
    {
        String nomCle1, nomCle2;
        if (table.compareToIgnoreCase("chambre") == 0)
        {
            nomCle1 = "no_chambre";
            nomCle2 = "code_service";
        }
        else 
        {
            nomCle1 = "no_docteur";
            nomCle2 = "no_malade";
        }
        
        Co.getStmt().executeQuery("DELETE * "
                + "FROM " + table + " WHERE "
                + nomCle1 + " = " + String.valueOf(cle1)
                + " AND " + nomCle2 + " = " + String.valueOf(cle2));
        
    }
    
    
    
    
}
