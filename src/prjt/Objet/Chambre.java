package prjt.Objet;

public class Chambre {

    private int Numero;

    private int Surveillant;

    private int nb_lits;

    private String code_service;

    public String getCodeService() {
        return code_service;
    }

    public void setCodeService(String code_service) {
        this.code_service = code_service;
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
     * @return the Surveillant
     */
    public int getSurveillant() {
        return Surveillant;
    }

    /**
     * @param Surveillant the Surveillant to set
     */
    public void setSurveillant(int Surveillant) {
        this.Surveillant = Surveillant;
    }

    /**
     * @return the nb_lits
     */
    public int getNb_lits() {
        return nb_lits;
    }

    /**
     * @param nb_lits the nb_lits to set
     */
    public void setNb_lits(int nb_lits) {
        this.nb_lits = nb_lits;
    }
}
