package prjt;


import java.sql.*;
import java.util.ArrayList;


public class Connexion {

   
    protected Connection conn;
    protected Statement stmt;
    protected ResultSet rset;
    protected ResultSetMetaData rsetMeta;

    private SSHTunnel ssh;
    private boolean autorisation = false;
    public static boolean locale = true;


    public Connexion(String NomBase, String Password) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/" + NomBase,"root", Password);
        System.out.println("Connexion reussie");
        stmt = conn.createStatement();
    }
    
    public Connexion(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");

 
        ssh = new SSHTunnel(usernameECE, passwordECE);

        if (ssh.connect()) {
            System.out.println("Connexion reussie");

            String urlDatabase = "jdbc:mysql://localhost:3305/" + usernameECE;

            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

            stmt = conn.createStatement();

         
        }
    }

    public ArrayList<String> remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("select * from " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            liste.add(rsetMeta.getColumnLabel(i + 1));
        }

        // Retourner l'ArrayList
        return liste;
    }
    
    public ArrayList<String> remplirChampsRequete(String requete, String separateur) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + separateur + rset.getString(i+1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }
    

    public void executeUpdate(String requeteMaj) throws SQLException {
        getStmt().executeUpdate(requeteMaj);
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * @return the stmt
     */
    public Statement getStmt() {
        return stmt;
    }

    /**
     * @param stmt the stmt to set
     */
    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    /**
     * @return the rset
     */
    public ResultSet getRset() {
        return rset;
    }

    /**
     * @param rset the rset to set
     */
    public void setRset(ResultSet rset) {
        this.rset = rset;
    }

    /**
     * @return the rsetMeta
     */
    public ResultSetMetaData getRsetMeta() {
        return rsetMeta;
    }

    /**
     * @param rsetMeta the rsetMeta to set
     */
    public void setRsetMeta(ResultSetMetaData rsetMeta) {
        this.rsetMeta = rsetMeta;
    }
    
    
    public SSHTunnel getssh() {
        return ssh;
    }
    
    
    public void setssh(SSHTunnel ssh) {
        this.ssh = ssh;
    }
    
}
