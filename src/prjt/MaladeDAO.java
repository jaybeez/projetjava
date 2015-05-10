/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjt;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import prjt.Objet.Docteur;
import prjt.Objet.Malade;

/**
 *
 * @author Arthur
 *
public class MaladeDAO extends DAO<Malade> {
    
        @Override
    	public Malade find(int id) throws SQLException
        {
            Malade mal = new Malade();
            
            try {
                conn.setRset(conn.getStmt().executeQuery("select * from malade where numero=" + Integer.toString(id)));
            } catch (SQLException ex) {
                Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

                                
            try {
                if(!conn.getRset().first())
                {
                    System.out.println("Malade non trouvé");
                    throw new SQLException();
                }
                conn.setRsetMeta(conn.getRset().getMetaData());
            
                mal.setNumero(Integer.parseInt(conn.getRset().getString(1)));
                mal.setNom(conn.getRset().getString(2));
                mal.setPrenom(conn.getRset().getString(3));
                mal.setAdresse(conn.getRset().getString(4));
                mal.setTelephone(conn.getRset().getString((5)));
                mal.setMutuelle(conn.getRset().getString(6));
                
            } catch (SQLException e) {
                throw new  SQLException(e);
            }
            
            return (mal);
        }
        
        
        @Override
	public Malade create(Malade obj)
        {
            
            
            return (obj);
        }

        @Override
        public Malade update(Malade obj) throws SQLException
        {
            
            
            return (obj);
        }
        
        @Override
	public void delete(Malade obj)
        {
            
        }
}
*/