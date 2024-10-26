import java.util.ArrayList;

/**
 * @author leenz
 */
public class Serie {
    
    //declaration 
    private ArrayList <Couleur> c;

    //creer une serie vide
    public Serie(){
        c = new ArrayList<>();
    }
    
    
    //retourne le couleur à la position 0 à n-1
    public Couleur getCouleur(int position){
        if (position < 0 || position >= c.size()) {
            throw new IllegalArgumentException("position ne correspond pas a une couleur de la serie");          
        }
        return c.get(position);
    }
    
    
    //ajoute le couleur à la serie
    public void ajouterCouleur(Couleur uneCouleur){
        c.add(uneCouleur);
    }
    
    
    //retourne vrai si la serie comporte les memes couleurs/ordres sinon false
    public boolean equals(Serie uneSerie){
        //if serie is not the same amount = false
        if (uneSerie == null || this.c.size() != uneSerie.c.size()) {
            return false;
        }
        //if serie is not same colors = false
        for (int i = 0; i < c.size(); i++) {
            if (!this.c.get(i).equals(uneSerie.getCouleur(i))) {
                return false;
            }
        }
        return true;
    }
    
    
    //retourne N||B selon le resultat apres la comparaison (N= fully correct, B=color only)
    public Serie comparer (Serie uneSerie){
        //si les deux ont le meme nombre d'element (*isnt important cuz i do one color at a time*)
        if (c.size() != uneSerie.c.size()) {
            throw new IllegalArgumentException("Erreur! Entrer 5 couleurs.");
        }
        
        //boolean for true/false (could use arrayList instead)
        Serie res = new Serie();
        boolean[] serie = new boolean[this.c.size()];

        //meme couleur + meme endroit = Noir
        for (int i = 0; i < this.c.size(); i++) {
            if (this.c.get(i).equals(uneSerie.getCouleur(i))) {
                res.ajouterCouleur(new Couleur("Noir", 'N')); 
                serie[i] = true; //turn those to true so black
            }
        }

        //meme couleur + diff endroit = Blanc
        for (int i = 0; i < this.c.size(); i++) {
            if (!serie[i]) { //previous serie 
                for (int k = 0; k < uneSerie.c.size(); k++) {
                    if (!serie[k] && this.c.get(i).equals(uneSerie.getCouleur(k))) {
                        res.ajouterCouleur(new Couleur("Blanc", 'B')); 
                        serie[k] = true;     //turns the rest true so white
                        break;
                    }
                }
            }
        }    
        return res; 
    }      
    
    //retourne la serie dans une chaine d'abreviations
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //make une chaîne de caractères

        for (int i = 0; i < c.size(); i++) {
            sb.append(c.get(i).getAbreviation()); //add 
            if (i < c.size() - 1) {
                sb.append(" "); //Ajoute un espace entre les char
            }
        } 
        return sb.toString();
    }   
}
