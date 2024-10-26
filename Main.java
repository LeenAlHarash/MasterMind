import java.util.Scanner;

/** 
 * @author leenz
 */

public class Main {
    public static void main(String[] args){
        Mastermind jeu = new Mastermind();
        Scanner sc = new Scanner(System.in);
        // intro
        System.out.println("=========== \nBienvenue a MasterMind! \nTrouvez la serie de 5 colors parmi les colors suivants: \n" +
                "   Rouge, Jaune, Bleu, Orange, Vert, Gris, Noir, Turquoise");
        System.out.println("*** Vous avez 12 essais. Bonne chance *** \n===========");

       
        // start
        boolean w = false;
        //une couleur à la fois pour avoir 5 couleurs.
        for (int i = 0; i < 12; i++) {
            System.out.println("Essai #" + (i + 1) + " :"); //until 12
            Serie essai = new Serie();

            //pour s'assurer que l'utilisateur donne 5couleurs
            for (int j = 0; j < 5; j++) {
                System.out.print("Choisissez la couleur #" + (j + 1) + " (R, J, B, O, V, G, N, T): ");
                char abréviation = sc.next().toUpperCase().charAt(0);

                Couleur color = null;
                switch (abréviation) {
                    case 'R': color = new Couleur("Rouge", 'R'); break;
                    case 'J': color = new Couleur("Jaune", 'J'); break;
                    case 'B': color = new Couleur("Bleu", 'B'); break;
                    case 'O': color = new Couleur("Orange", 'O'); break;
                    case 'V': color = new Couleur("Vert", 'V'); break;
                    case 'G': color = new Couleur("Gris", 'G'); break;
                    case 'N': color = new Couleur("Noir", 'N'); break;
                    case 'T': color = new Couleur("Turquoise", 'T'); break;
                    
                    default:   
                    System.out.println("**Couleur invalide, veuillez choisir parmi la liste donnee**\n");
                    j--; //to not count ^
                    continue;
                }
                
                essai.ajouterCouleur(color);
            }

            //show users answers
            Serie res = jeu.essayer(essai);
            System.out.println(jeu.toString());

            if (jeu.getSolution().equals(essai)) {
                w = true;
                break;
            }
        }

        if (w = true) {
            System.out.println("YIPPIEEEEEEE!! vous avez gagne");
        } else {
            System.out.println("GAME OVER");
        }  //end     
    }
}
