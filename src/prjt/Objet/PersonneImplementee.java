package prjt.Objet;

public class PersonneImplementee implements Personne {

    private String Nom;

    private String Prenom;

    private int Numero;

    private String Telephone;

    private String Adresse;

    public PersonneImplementee()
    {
    }
        
    public PersonneImplementee(int Numero, String Nom, String Prenom, String Adresse, String Telephone)
    {
        this.Numero = Numero;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Telephone = Telephone;
    }
    
    
    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * @param Prenom the Prenom to set
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    /**
     * @return the Numero
     */
    public int getNumero() {
        return Numero;
    }

    /**
     * @param Numero the Numero to set
     */
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    /**
     * @return the Telephone
     */
    public String getTelephone() {
        return Telephone;
    }

    /**
     * @param Telephone the Telephone to set
     */
    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    /**
     * @return the Adresse
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * @param Adresse the Adresse to set
     */
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }
}
