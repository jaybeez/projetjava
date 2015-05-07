package prjt.Objet;

public class Service {

    private String Code;

    private String Nom;

    private char Batiment;

    private int Directeur;

    /**
     * @return the Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * @param Code the Code to set
     */
    public void setCode(String Code) {
        this.Code = Code;
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
     * @return the Batiment
     */
    public char getBatiment() {
        return Batiment;
    }

    /**
     * @param Batiment the Batiment to set
     */
    public void setBatiment(char Batiment) {
        this.Batiment = Batiment;
    }

    /**
     * @return the Directeur
     */
    public int getDirecteur() {
        return Directeur;
    }

    /**
     * @param Directeur the Directeur to set
     */
    public void setDirecteur(int Directeur) {
        this.Directeur = Directeur;
    }
}
