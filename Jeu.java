import java.util.Scanner;
import java.util.Random;

public class Jeu {
    public static void main(String[] args) {
        // Préparation du jeu
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        // Tirage du nombre entre 1 et 100
        int nombreMystere = rand.nextInt(100) + 1;
        int maxEssais = 10;
        int tentatives = 0;
        boolean gagne = false;

        System.out.println("--- JEU DU NOMBRE MYSTÈRE (1-100) ---");
        System.out.println("Tu as 10 essais pour trouver le bon chiffre.");

        // Boucle principale
        while (tentatives < maxEssais) {
            System.out.print("Essai " + (tentatives + 1) + "/" + maxEssais + " : ");

            // Vérifie si l'utilisateur entre bien un nombre
            if (sc.hasNextInt()) {
                int choix = sc.nextInt();
                tentatives++;

                // Comparaison avec le nombre mystère
                if (choix < nombreMystere) {
                    System.out.println("C'est plus grand !");
                } else if (choix > nombreMystere) {
                    System.out.println("C'est plus petit !");
                } else {
                    System.out.println("Bravo, trouvé en " + tentatives + " essais.");
                    gagne = true;
                    break; // On arrête la boucle si c'est gagné
                }
            } else {
                System.out.println("Entrée invalide, tape un nombre entier.");
                sc.next(); // On vide le buffer pour éviter les bugs
            }
        }

        // Message de fin si la boucle est terminée
        if (!gagne) {
            System.out.println("Perdu... Le nombre était : " + nombreMystere);
        }

        sc.close();
    }
}
