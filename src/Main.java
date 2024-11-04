import java.util.Scanner;

public class Main {
    // En statisk instans af OrdreListe-klassen, der gemmer og håndterer ordrer
    private static OrdreListe ordreListe = new OrdreListe();

    public static void main(String[] args) {
        // Initialiserer pizza-menuen ved at kalde opretPizzaMenu() fra Pizza-klassen
        Pizza.opretPizzaMenu();
        start();  // Starter programmet ved at kalde start-metoden
    }

    // Metode til at vise hovedmenuen og håndtere brugerens valg
    public static void start() {
        String spacing = ("-------------------------------");  // Adskillelse mellem menuvalg
        int valg;  // Brugerens menuvalg
        Scanner scanner = new Scanner(System.in);  // Scanner til at læse brugerens input

        // Do-while loop, der fortsætter, indtil brugeren vælger at afslutte
        do {
            // Udskriver menuen til brugeren
            System.out.println("""
                    -------------------------------
                    SYSTEM MENU
                    1. Ny ordre
                    2. Færdiggør ordre
                    3. Vis menuen
                    4. Se ordreliste
                    5. Lav dags-rapport
                    6. Afslut
                    ------------------------------""");
            System.out.print("Indtast dit valg: ");
            valg = scanner.nextInt();  // Læser brugerens valg som et heltal
            scanner.nextLine();  // Rydder input-bufferen


            // Switch-sætning til at håndtere forskellige menuvalg
            switch (valg) {
                case 1:
                    // Kald af metode til at oprette en ny ordre og sender ordrelisten som parameter
                    Bestilling.opretNyOrdre(ordreListe);
                    break;
                case 2:
                    // Færdiggør ordre
                    ordreListe.visOrdreListe(); // Viser den aktuelle liste af ordrer, så brugeren kan vælge en ordre at færdiggøre
                    System.out.print("Indtast ordrenummer for at færdiggøre: ");

                    int ordrenummer = scanner.nextInt(); // Læser ordrenummeret, som brugeren vil færdiggøre
                    ordreListe.færdigørOrdre(ordrenummer); // Kalder metode i OrdreListe for at færdiggøre den valgte ordre
                    break;
                case 3:
                    // Viser pizza-menuen ved at kalde visMenu() fra Pizza-klassen
                    System.out.println("\nMENU KORT");
                    Pizza.visMenu();
                    System.out.println("\n");
                    break;
                case 4:
                    // Viser den aktuelle ordreliste ved at kalde visOrdreListe() fra ordreListe
                    ordreListe.visOrdreListe();
                    break;
                case 5:
                    // Generering af dags-rapport (kode mangler her)
                    System.out.println("Dine ordrer bliver gemt i status.txt");
                    OrdreListe.visStatus();
                    break;
                case 6:
                    // Afslutter programmet
                    System.out.println("Afslutter programmet.");
                    break;
                default:
                    // Hvis brugeren indtaster et ugyldigt valg
                    System.out.println("Ugyldigt valg, prøv igen.");
            }
        } while (valg != 6);  // Løkken fortsætter, indtil brugeren vælger at afslutte med valg 6
        scanner.close();  // Lukker scanner for at frigøre ressourcer
    }
}