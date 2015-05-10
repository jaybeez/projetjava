package prjt.Objet;

public class Infirmier extends Employe {

    private String Rotation;

    private Float Salaire;

    private String CodeService;

    public Infirmier()
    {
    }
    
    public Infirmier(Employe Em, String Rotation, Float Salaire, String CodeService)
    {
        super(Em);
        this.Rotation = Rotation;
        this.Salaire = Salaire;
        this.CodeService = CodeService;
    }
    
    
    public String getCodeService() {
        return CodeService;
    }

    public void setCodeService(String CodeService) {
        this.CodeService = CodeService;
    }
    
    /**
     * @return the Rotation
     */
    public String getRotation() {
        return Rotation;
    }

    /**
     * @param Rotation the Rotation to set
     */
    public void setRotation(String Rotation) {
        this.Rotation = Rotation;
    }

    /**
     * @return the Salaire
     */
    public Float getSalaire() {
        return Salaire;
    }

    /**
     * @param Salaire the Salaire to set
     */
    public void setSalaire(Float Salaire) {
        this.Salaire = Salaire;
    }
}
