/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphique;

import graphique.PlaceLabel;
/*
 * 
 * Librairies importées
 */

import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import prjt.Connexion;
import prjt.Connexion;
/**
 *
 * Affiche dans la fenetre graphique les champs de tables et les requetes de la BDD
 *
 * @author segado
 */
public class Fenetre extends JFrame implements ActionListener {
    /*
     * Attribut privés : objets de Connexion, AWT et Swing
     * 
     */
    private static Connexion conn;
    public static Connexion getConn() {return conn;}
    private Connexion maconnexion;
    public static void setConn(Connexion conn) {Fenetre.conn = conn;}

    private JLabel nameECE, passwdECE, loginBDD, passwdBDD;
    private PlaceLabel nameECETexte, loginBDDTexte;
    private JPasswordField passwdECETexte, passwdBDDTexte;
    private JButton connect, bouton1, bouton_Fer, bouton_Afc;

    /**
     * Constructeur qui initialise tous les objets graphiques de la fenetre
     */
    public Fenetre() {
    
        // creation par heritage de la fenetre
        super("Projet d'utilisation de JDBC dans MySQL");
  
        // mise en page (layout) de la fenetre visible
        JPanel j0 = new JPanel(new FlowLayout());
        setBounds(500, 300, 400, 400);
        setResizable(true);
        setVisible(true);

        // creation des boutons
        connect = new JButton("Connexion");
        bouton1 = new JButton("AfficheChamps");
        bouton_Fer = new JButton("AfficheRequetes");
        bouton_Afc = new JButton("Fermer");

      
        // creation des textes
        nameECETexte = new PlaceLabel(50,200,100,50,"gesnel");
        passwdECETexte = new JPasswordField(8);
        loginBDDTexte = new PlaceLabel(200,200,100,50,"gesnel");
        passwdBDDTexte = new JPasswordField(8);
        

       
        nameECE = new JLabel("nom ECE :", JLabel.CENTER);
        passwdECE = new JLabel("mot de passe ECE :", JLabel.CENTER);
        loginBDD = new JLabel("login de la base :", JLabel.CENTER);
        passwdBDD = new JLabel("password de la base :", JLabel.CENTER);

        

        // ajout des listeners
        connect.addActionListener(this);
        nameECETexte.addActionListener(this);
        passwdECETexte.addActionListener(this);
        loginBDDTexte.addActionListener(this);
        passwdBDDTexte.addActionListener(this);
        bouton1.addActionListener(this);
        bouton_Fer.addActionListener(this);
        bouton_Afc.addActionListener(this);

        // couleurs des objets graphiques
        bouton1.setBackground(Color.green);
        bouton_Fer.setBackground(Color.yellow);
        bouton_Afc.setBackground(Color.red);
        
        j0.add(nameECETexte.gettxtField());
        
        this.add(j0);
        /*nameECETexte=new JTextField("gesnel");
        passwdECETexte=new JPasswordField("");
        loginBDDTexte=new JTextField("gesnel-rw");
        passwdBDDTexte=new JPasswordField("t3qna58a");*/
        // pour fermer la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    }

    /**
     *


    /**
     *
     * Pour gerer les actions sur les boutons on utilise la fonction
     * actionPerformed
     */
    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void actionPerformed(ActionEvent evt) {
        // tester cas de la commande evenementielle
        if (evt.getActionCommand().equals("Fermer")) {

            this.dispose();
            System.exit(0);
        } 
        
        else if (evt.getActionCommand().equals("Connexion")) {
            String passwdECEString = new String(getPasswdECETexte().getPassword());
            String passwdBDDString = new String(getPasswdBDDTexte().getPassword());

            try {
                try {
                    // tentative de connexion si les 4 attributs sont remplis
                    setMaconnexion(new Connexion(getNameECETexte().getText(), passwdECEString, getLoginBDDTexte().getText(), passwdBDDString));
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Connexion echouee : probleme SQL");
                e.printStackTrace();
            }

        } 
        
        
    }

    /**
     * @return the maconnexion
     */
    public Connexion getMaconnexion() {
        return maconnexion;
    }

    /**
     * @param maconnexion the maconnexion to set
     */
    public void setMaconnexion(Connexion maconnexion) {
        this.maconnexion = maconnexion;
    }

    /**
     * @return the nameECE
     */
    public JLabel getNameECE() {
        return nameECE;
    }

    /**
     * @param nameECE the nameECE to set
     */
    public void setNameECE(JLabel nameECE) {
        this.nameECE = nameECE;
    }

    /**
     * @return the passwdECE
     */
    public JLabel getPasswdECE() {
        return passwdECE;
    }

    /**
     * @param passwdECE the passwdECE to set
     */
    public void setPasswdECE(JLabel passwdECE) {
        this.passwdECE = passwdECE;
    }

    /**
     * @return the nameECETexte
     */
    public PlaceLabel getNameECETexte() {
        return nameECETexte;
    }

    /**
     * @param nameECETexte the nameECETexte to set
     */
    public void setNameECETexte(PlaceLabel nameECETexte) {
        this.nameECETexte = nameECETexte;
    }

    /**
     * @return the loginBDDTexte
     */
    public PlaceLabel getLoginBDDTexte() {
        return loginBDDTexte;
    }

    /**
     * @param loginBDDTexte the loginBDDTexte to set
     */
    public void setLoginBDDTexte(PlaceLabel loginBDDTexte) {
        this.loginBDDTexte = loginBDDTexte;
    }

    /**
     * @return the passwdECETexte
     */
    public JPasswordField getPasswdECETexte() {
        return passwdECETexte;
    }

    /**
     * @param passwdECETexte the passwdECETexte to set
     */
    public void setPasswdECETexte(JPasswordField passwdECETexte) {
        this.passwdECETexte = passwdECETexte;
    }

    /**
     * @return the passwdBDDTexte
     */
    public JPasswordField getPasswdBDDTexte() {
        return passwdBDDTexte;
    }

    /**
     * @param passwdBDDTexte the passwdBDDTexte to set
     */
    public void setPasswdBDDTexte(JPasswordField passwdBDDTexte) {
        this.passwdBDDTexte = passwdBDDTexte;
    }
    
    /**
    *
    * Pour gerer les actions sur items d'une liste on utilise la methode
    * itemStateChanged
    */
    
}

