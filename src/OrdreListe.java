import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class OrdreListe {
    private static ArrayList<Bestilling> ordreListe; // Liste over alle aktive ordrer
    private int ordrenummer; // Holder styr på næste ordrenummer, som tildeles automatisk

    // Konstruktør, der initialiserer ordrelisten og sætter start-ordrenummer til 1
    public OrdreListe() {
        ordreListe = new ArrayList<>();
        ordrenummer = 1;
    }

    // Getter til at hente det nuværende ordrenummer
    public int getOrdrenummer(){
        return ordrenummer;
    }

    // Metode til at færdiggøre en ordre baseret på ordrenummer
    public boolean færdigørOrdre(int ordrenummer){
        for(int f = 0; f < ordreListe.size(); f++){
            Bestilling ordre = ordreListe.get(f); // Henter hver ordre i listen
            if (ordre.getOrdrenummer() == ordrenummer){ // Tjekker om ordrenummeret matcher
                ordreListe.remove(f); // Fjerner ordren fra listen
                System.out.println("Ordre " + ordrenummer + " er blevet færdiggjort.");
                return true; // Returnerer true, hvis ordren blev færdiggjort
            }
        }
        System.out.println("Ordre " + ordrenummer + " blev ikke fundet.");
        return false; // Returnerer false, hvis ordren ikke blev fundet
    }

    // Metode til at tilføje en ny ordre til listen
    public void tilføjOrdre(Bestilling ordre) {
        ordre.setOrdrenummer(ordrenummer); // Tildeler det aktuelle ordrenummer til ordren
        ordreListe.add(ordre); // Tilføjer ordren til ordrelisten
        ordrenummer++; // Øger ordrenummer til næste ordre
    }

    // Metode til at vise alle aktive ordrer i listen
    public void visOrdreListe() {
        System.out.println("\nAktuelle ordrer:");
        for (Bestilling ordre : ordreListe) { // Itererer gennem hver ordre i listen
            System.out.println(ordre); // Udskriver ordredetaljerne
        }
    }

    // Metode til at lave en txt fil (Kan find pudses så formateringen i txt filen er overskuelig)
    public static void visStatus(){
        try {
            PrintStream status = new PrintStream(new File("status.txt"));
            status.println(ordreListe);
        } catch (FileNotFoundException e){
            System.out.println("Filen blev ikke fundet");
        }
    }

}