package prjt.Objet;

public class Employe extends PersonneImplementee {
    
    public Employe()
    {
        
    }
    
    public Employe(Employe Em)
    {
        super(Em.getNumero(),Em.getNom(), Em.getPrenom(), Em.getAdresse(), Em.getTelephone());
    }
    
    
}
