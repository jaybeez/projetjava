package prjt;

import java.sql.Connection;
import java.sql.SQLException;
import prjt.Connexion;

public abstract class DAO<T> {

        public Connexion conn = Controleur.getConn();
    
	public abstract T find(int id) throws SQLException;
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract T update(T obj) throws SQLException;
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
}
