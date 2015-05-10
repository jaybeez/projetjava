package prjt.Objet;

public class Hospitalisation {

    private int no_malade;
    private String code_service;
    private int numero_chambre;
    private int Lit;
    
    public int getNoMalade() {
        return no_malade;
    }

    public void setNoMalade(int no_malade) {
        this.no_malade = no_malade;
    }

    public String getCodeService() {
        return code_service;
    }

    public void setCodeService(String code_service) {
        this.code_service = code_service;
    }

    public int getNumero_chambre() {
        return numero_chambre;
    }

    public void setNumero_chambre(int numero_chambre) {
        this.numero_chambre = numero_chambre;
    }



    /**
     * @return the Lit
     */
    public int getLit() {
        return Lit;
    }

    /**
     * @param Lit the Lit to set
     */
    public void setLit(int Lit) {
        this.Lit = Lit;
    }
}
