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
import prjt.Objet.Hospitalisation;

/**
 *
 * @author Arthur
 */
public class HospitalisationDAO extends DAO<Hospitalisation> {
  
    @Override
    public Hospitalisation find(int id) throws SQLException
    {

        return (null);
    }
               
    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    @Override
    public Hospitalisation create(Hospitalisation obj)
    {
        return (obj);
    }

    /**
     * Permet de mettre à jour les données d'une entrée dans la base 
     * @param obj
     */
    @Override
    public Hospitalisation update(Hospitalisation obj) throws SQLException
    {
        return (obj);
    }

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    @Override
    public void delete(Hospitalisation obj)
    {

    }
}

    
