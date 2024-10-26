package TP_1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author leenz
 */
public class Mastermind {
    //declaration
    private Serie solution;
    private int NbEssais;
    private ArrayList <Serie> tries;
    
    
    //cree un jeur avec la solution
    public Mastermind(Serie uneSolution) {
        this.solution = uneSolution;
        this.NbEssais = 0;
        this.tries = new ArrayList<>();
    }
    
    
    //cree solution aleatoire
    public Mastermind(){
        this.solution = SRand();
        this.NbEssais = 0;
        this.tries = new ArrayList<>();
    }
   
    
    public Serie SRand(){
        String[] choixCouleurs = {"Rouge", "Jaune", "Bleu", "Orange", "Vert", "Gris", "Noir", "Turquoise"};
        char[] abreviations = {'R', 'J', 'B', 'O', 'V', 'G', 'N', 'T'};
        Serie se = new Serie();
        Random meow = new Random();
        
        for (int i = 0; i < 5; i++) {
            int index = meow.nextInt(choixCouleurs.length); //random color from the []
            Couleur couleur = new Couleur(choixCouleurs[index], abreviations[index]);
            se.ajouterCouleur(couleur);
            System.out.println(se); //to show random answer for testing
        }
        return se; 
    }
    
        
    //solution
    public Serie getSolution(){
        return solution;
    }
    
    
    //nombre d'essais
    public int getNbEssais(){
        return NbEssais;
    }
    
    
    //tentatives de solutions
    public Serie essayer(Serie essai){
        NbEssais++;
        tries.add(essai);
        return solution.comparer(essai);
    }
    
    
    //retourne en une seule chaîne les essais tentés et leur résultat
    @Override
    public String toString() {
        StringBuilder mo = new StringBuilder();
        for (Serie essai : tries) {
            mo.append(essai.toString());
            mo.append(" : ");

            // Compare the essai with the solution
            Serie result = solution.comparer(essai);
            mo.append(result.toString());

            mo.append("\n"); //new line
        }
        return mo.toString();
    }
}