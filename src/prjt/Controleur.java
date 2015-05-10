package prjt;

import graphique.Fenetre;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import prjt.Objet.Chambre;
import prjt.Objet.Docteur;
import prjt.Objet.Employe;
import prjt.Objet.Hospitalisation;
import prjt.Objet.Infirmier;
import prjt.Objet.Malade;
import prjt.Objet.Service;
import prjt.Objet.Soigne;


public class Controleur {


    private static Connexion conn;
    private static ArrayList<Chambre> chambre;
    private static ArrayList<Docteur> docteur;
    private static ArrayList<Infirmier> infirmier;
    private static ArrayList<Hospitalisation> hospitalisation;
    private static ArrayList<Malade> malade;
    private static ArrayList<Service> service;
    private static ArrayList<Soigne> soigne;
    
    public static Connexion getConn() 
    {
        return conn;
    }
    
    public static void setConn(Connexion conn)
    {
        Controleur.conn = conn;
    }
    
    
    public static void InitialisationObjets() throws SQLException
    {
        Scanner sc;
        ArrayList<String> listeMalade, listeDocteur, listeInfirmier;
        Malade MalTemp;
        Docteur DocTemp;
        Infirmier InfTemp;
        
        malade = new ArrayList<Malade>();
        docteur = new ArrayList<Docteur>();
        infirmier = new ArrayList<Infirmier>();
        listeDocteur = conn.remplirChampsRequete("SELECT * FROM employe, docteur WHERE employe.numero=docteur.numero", "/"); 
        listeInfirmier = conn.remplirChampsRequete("SELECT * FROM employe, infirmier WHERE employe.numero=infirmier.numero", "/");
        listeMalade = conn.remplirChampsRequete("SELECT * FROM malade", "/");
        

        for (int i = 0; i < listeDocteur.size(); i++)
        {
            DocTemp = new Docteur();
            sc = new Scanner(listeDocteur.get(i));
            sc.useDelimiter("/");
            DocTemp.setNumero(sc.nextInt());
            DocTemp.setNom(sc.next());
            DocTemp.setPrenom(sc.next());
            DocTemp.setAdresse(sc.next());
            DocTemp.setTelephone(sc.next());
            sc.next();
            DocTemp.setSpecialite(sc.next());
            docteur.add(DocTemp);
        }

        for (int i = 0; i < listeInfirmier.size(); i++)
        {
            InfTemp = new Infirmier();
            sc = new Scanner(listeInfirmier.get(i));
            sc.useDelimiter("/");
            InfTemp.setNumero(sc.nextInt());
            InfTemp.setNom(sc.next());
            InfTemp.setPrenom(sc.next());
            InfTemp.setAdresse(sc.next());
            InfTemp.setTelephone(sc.next());
            sc.next();
            InfTemp.setCodeService(sc.next());
            InfTemp.setRotation(sc.next());
            InfTemp.setSalaire(Float.parseFloat(sc.next()));
            infirmier.add(InfTemp);
        }
        
        for (int i = 0; i < listeMalade.size(); i++)
        {
            MalTemp = new Malade();
            sc = new Scanner(listeMalade.get(i));
            sc.useDelimiter("/");
            MalTemp.setNumero(sc.nextInt());
            MalTemp.setNom(sc.next());
            MalTemp.setPrenom(sc.next());
            MalTemp.setAdresse(sc.next());
            MalTemp.setTelephone(sc.next());
            MalTemp.setMutuelle(sc.next());
            malade.add(MalTemp);
        }
        
    }
    
    
    public static void main(String[] s) {
        
        Scanner sc;
        String usernameECE, passwordECE, loginDatabase, passwordDatabase;
        Reporting rep;
        
        System.out.println("usernameECE : ");
        //usernameECE = sc.next();
        System.out.println("passwordECE : ");
        //passwordECE = sc.next();
        System.out.println("loginDatabase : ");
        //loginDatabase = sc.next();
        System.out.println("passwordDatabase : ");
        //passwordDatabase = sc.next();
        
        usernameECE = "caix";
        passwordECE = "U9hd.42X";
        loginDatabase = "caix-rw";
        passwordDatabase = "qlMmrkAM";  
        
        
        try
        {
            conn = new Connexion(usernameECE, passwordECE, loginDatabase, passwordDatabase);
            //conn = new Connexion("test", " ");            
            InitialisationObjets();
            rep = new Reporting(conn);
            rep.RepartitionMedecinsSpecialites();
            System.out.println(" ");
            rep.RepartitionInfirmierService();
            System.out.println(" ");
            rep.RepartitionInfirmierRotation();
            System.out.println(" ");
            rep.RepartitionMaladeMutuelle();
            System.out.println(" ");
            rep.RepartitionEmplyes();
            
                     
            conn.getConn().close();

            
        } catch (ClassNotFoundException cnfe)
        {
            System.out.println("Connexion echouee : probleme de classe");
            cnfe.printStackTrace();
        }        
        catch (SQLException e) 
        {
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
        }

   

        
    }
}
