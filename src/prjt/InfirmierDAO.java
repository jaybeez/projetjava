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
import prjt.Objet.Infirmier;

/**
 *
 * @author Arthur
 *
public class InfirmierDAO extends DAO<Infirmier> {
    
        @Override
    	public Infirmier find(int id) throws SQLException
        {
            Infirmier inf = new Infirmier();
            
            try {
                conn.setRset(conn.getStmt().executeQuery("SELECT employe.* ,infirmier.salaire ,infirmier.code_service ,infirmier.rotation FROM employe,infirmier WHERE employe.numero=infirmier.numero && employe.numero="+Integer.toString(id)));
            } catch (SQLException ex) {
                Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

                                
            try {
                if(!conn.getRset().first())
                {
                    System.out.println("Infirmier non trouvé");
                    throw new SQLException();
                }
                conn.setRsetMeta(conn.getRset().getMetaData());
            
                inf.setNumero(Integer.parseInt(conn.getRset().getString(1)));
                inf.setNom(conn.getRset().getString(2));
                inf.setPrenom(conn.getRset().getString(3));
                inf.setAdresse(conn.getRset().getString(4));
                inf.setTelephone(conn.getRset().getString((5)));
                inf.setCodeService(conn.getRset().getString(6));
                inf.setRotation(conn.getRset().getString(7));
                inf.setSalaire(Float.parseFloat(conn.getRset().getString(8)));
                
            } catch (SQLException e) {
                throw new  SQLException(e);
            }
            
            return (inf);
        }
        
        @Override
	public Infirmier create(Infirmier obj)
        {
            
            
            return (obj);
        }

        @Override
        public Infirmier update(Infirmier obj) throws SQLException
        {
            
            
            return (obj);
        }
        
        @Override
	public void delete(Infirmier obj)
        {
            
        }
}
*/