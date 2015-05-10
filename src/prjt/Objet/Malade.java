package prjt.Objet;

public class Malade extends PersonneImplementee {

    private String Mutuelle;

    public Malade(Malade Mal)
    {
        super(Mal.getNumero(),Mal.getNom(), Mal.getPrenom(), Mal.getAdresse(), Mal.getTelephone()); 
    }

    public Malade()
    {
        
    }
    
    /**
     * @return the Mutuelle
     */
    public String getMutuelle() {
        return Mutuelle;
    }

    /**
     * @param Mutuelle the Mutuelle to set
     */
    public void setMutuelle(String Mutuelle) {
        this.Mutuelle = Mutuelle;
    }
}
