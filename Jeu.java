import java.util.Scanner;
import java.util.Random;

public class Jeu {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // On génère une lettre au hasard entre A et Z
        char lettreSecrete = (char) (random.nextInt(26) + 'A');

        int essaisMax = 10;
        int compteur = 0;
        char choixUtilisateur = ' ';
        boolean victoire = false;

        System.out.println("--- JEU : DEVINE LA LETTRE (A-Z) ---");
        System.out.println("Indices : l'alphabet suit l'ordre A, B, C...");

        // Boucle principale du jeu
        while (compteur < essaisMax) {
            System.out.print("\nEssai " + (compteur + 1) + "/" + essaisMax + " - Votre lettre : ");

            // On récupère juste le premier caractère et on le force en majuscule
            String input = scanner.next().toUpperCase();
            choixUtilisateur = input.charAt(0);
            compteur++;

            // Vérification de la réponse
            if (choixUtilisateur < lettreSecrete) {
                System.out.println("C'est plus loin dans l'alphabet !");
            } else if (choixUtilisateur > lettreSecrete) {
                System.out.println("C'est plus tôt dans l'alphabet !");
            } else {
                System.out.println("Gagné ! La lettre était bien " + lettreSecrete);
                victoire = true;
                break; // On arrête tout si c'est trouvé
            }
        }

        // Si on sort de la boucle sans avoir trouvé
        if (!victoire) {
            System.out.println("\nPerdu... Le secret était : " + lettreSecrete);
        }

        scanner.close();
    }
}