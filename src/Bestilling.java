import java.time.LocalDateTime;
import java.util.Scanner;

public class Bestilling {
    // Instansvariabler til at gemme oplysninger om ordren
    private int pizzaNummer;                // Nummer på den valgte pizza i ordren
    private String kundesNavn;               // Kundens navn
    private String afhentningsTidspunkt;     // Tidspunkt for afhentning
    private LocalDateTime bestillingsTidspunkt; // Tidspunkt for, hvornår ordren blev oprettet
    private int ordrenummer;                 // Ordrenummer til at identificere ordren

    // Konstruktør til at initialisere instansvariablerne
    public Bestilling(int pizzaNummer, String kundesNavn, String afhentningsTidspunkt, LocalDateTime bestillingsTidspunkt) {
        this.pizzaNummer = pizzaNummer;
        this.kundesNavn = kundesNavn;
        this.afhentningsTidspunkt = afhentningsTidspunkt;
        this.bestillingsTidspunkt = bestillingsTidspunkt;
    }

    // Sætter ordrenummeret for ordren
    public void setOrdrenummer(int ordrenummer) {
        this.ordrenummer = ordrenummer;
    }

    // Henter ordrenummeret
    public int getOrdrenummer() {
        return ordrenummer;
    }

    // Henter afhentningstidspunktet
    public String getAfhentningsTidspunkt() {
        return afhentningsTidspunkt;
    }

    // Statisk metode til at oprette en ny ordre og tilføje den til ordrelisten
    public static void opretNyOrdre(OrdreListe ordreListe) {
        Scanner scanner = new Scanner(System.in);
        int pizzaNummer = 0;                // Variabel til at holde det valgte pizza nummer
        String kundesNavn = "";              // Kundens navn
        String afhentningsTidspunkt = "";    // Afhentningstidspunkt (HH:mm)
        LocalDateTime timestamp = LocalDateTime.now(); // Bestillingstidspunkt (nuværende tidspunkt)

        // Menu til at oprette en ny ordre
        while (true) {
            System.out.println("""
                    -------------------------------
                    OPRET NY BESTILLING MENU
                    1. Pizza nummer (1 - 31)
                    2. Kundes navn
                    3. Afhentningstidspunkt (HH:mm)
                    4. Se indtastet bestilling
                    5. Bekræft bestilling
                    6. Annuller
                    -------------------------------""");
            System.out.print("Indtast dit valg: ");
            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1:
                    // Indtastning af pizza nummer (kun tal mellem 1 og 31 accepteres)
                    while (true) {
                        System.out.print("Indtast pizza nummer: ");
                        pizzaNummer = scanner.nextInt();
                        if (pizzaNummer >= 1 && pizzaNummer <= 31) {
                            break;
                        } else {
                            System.out.println("Ugyldigt pizza nummer, prøv igen.");
                        }
                    }
                    break;
                case 2:
                    // Indtastning af kundens navn
                    System.out.print("Indtast kundens navn: ");
                    kundesNavn = scanner.nextLine();
                    break;
                case 3:
                    // Indtastning af afhentningstidspunkt
                    System.out.print("Afhentningstidspunkt (HH:mm): ");
                    afhentningsTidspunkt = scanner.nextLine();
                    break;
                case 4:
                    // Viser den foreløbige bestilling
                    System.out.println("Se indtastet bestilling: ");
                    System.out.println("Pizza #" + pizzaNummer);
                    System.out.println("Kundes navn: " + kundesNavn);
                    System.out.println("Afhentningstidspunkt: " + afhentningsTidspunkt);
                    System.out.println("Bestillingstidspunkt: " + timestamp.getHour() + ":" + timestamp.getMinute());
                    break;
                case 5:
                    // Bekræfter ordren ved at overføre den til ordrelisten
                    Bestilling nyBestilling = new Bestilling(pizzaNummer, kundesNavn, afhentningsTidspunkt, timestamp);
                    ordreListe.tilføjOrdre(nyBestilling);  // Tilføjer ordren til ordrelisten
                    System.out.println("Bestilling bekræftet: " + nyBestilling);
                    return;
                case 6:
                    // Annullerer oprettelsen af ordren
                    System.out.println("Bestilling annulleret.");
                    return;
                default:
                    System.out.println("Ugyldigt valg, prøv igen.");
            }
        }
    }

    // Overrider toString-metoden til at returnere en læsbar beskrivelse af ordren
    @Override
    public String toString() {
        return "Ordrenummer: " + ordrenummer + " || " + "Pizza #" + pizzaNummer +
                " || " + "Afhentning kl: " + afhentningsTidspunkt + " || " + "Kunde: " + kundesNavn;
    }
}