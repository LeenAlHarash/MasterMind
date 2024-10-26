/**
 * @author leenz
 */

public class Couleur {
    private String nom;
    private char abreviation;
    
    //constructeur
    public Couleur(String unNom, char uneAbreviation){
        this.nom = unNom;
        this.abreviation = uneAbreviation;
    }
    
    
    //accesseurs
    public String getNom(){
        return nom;
    }
    
    public char getAbreviation(){
        return abreviation;
    }
    
    
    //methodes
    public boolean equals(Couleur uneCouleur) {
        //if both object in the memory is the same=true
        if (this == uneCouleur) {
            return true;
        }
        //if null
        if (uneCouleur == null) {
            return false;
        }
        
        // Comparer le nom et l'abréviation
        return this.nom.equals(uneCouleur.nom) && this.abreviation == uneCouleur.abreviation;
    }
   
    
    @Override
    public String toString(){
        return String.valueOf(abreviation);
    }
}
