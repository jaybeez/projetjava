package prjt.Objet;

public class Infirmier extends Employe {

    private String Rotation;

    private Float Salaire;

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
