package prjt.Objet;

public class Docteur extends Employe {

    public Docteur()
    {
    }
    
    public Docteur(Employe Em, String Specialite)
    {
        super(Em);
        this.Specialite = Specialite;
    }
    
    private String Specialite;

    /**
     * @return the Specialite
     */
    public String getSpecialite() {
        return Specialite;
    }

    /**
     * @param Specialite the Specialite to set
     */
    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }
}
