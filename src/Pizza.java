import java.util.ArrayList;

public class Pizza { // Definition af klassen "Pizza"
    // Instansvariabler til at gemme oplysninger om pizzaen
    private int nummer;  // Pizzaens nummer
    private String navn; // Pizzaens navn
    private double pris; // Pizzaens pris

    // En statisk ArrayList til at gemme hele menuen af pizzaer
    private static ArrayList<Pizza> menu = new ArrayList<>();

    // Konstruktør til at initialisere instansvariablerne, når en ny Pizza oprettes
    public Pizza(int nummer, String navn, double pris){
        this.nummer = nummer;
        this.navn = navn;
        this.pris = pris;
    }

    // Getter-metoder til at hente værdierne af instansvariablerne
    public int getNummer(){
        return nummer;
    }

    public String getNavn(){
        return navn;
    }

    public double getPris(){
        return pris;
    }

    // toString metode, som returnerer en beskrivelse af pizzaen i en læsbar tekststreng
    public String toString(){
        return "Nr. " + nummer + ": " + navn + " - " + pris + " kr.";
    }

    // Statisk metode til at oprette og tilføje et sæt standard-pizzaer til menuen
    public static void opretPizzaMenu(){
        // Tilføjer forskellige pizzaer med deres nummer, navn og pris til menuen
        menu.add(new Pizza(1, "Margherita", 50));
        menu.add(new Pizza(2, "Quattro Stagioni", 65));
        menu.add(new Pizza(3, "Diavola", 60));
        menu.add(new Pizza(4, "Capricciosa", 70));
        menu.add(new Pizza(5, "Funghi", 58));
        menu.add(new Pizza(6, "Pesto Genovese", 75));
        menu.add(new Pizza(7, "Napoletana", 80));
        menu.add(new Pizza(8, "Siciliana", 70));
        menu.add(new Pizza(9, "Romana", 65));
        menu.add(new Pizza(10, "Tortano", 75));
        menu.add(new Pizza(11, "Prosciutto e Funghi", 68));
        menu.add(new Pizza(12, "Marinara", 55));
        menu.add(new Pizza(13, "Quattro Formaggi", 78));
        menu.add(new Pizza(14, "Focaccia", 45));
        menu.add(new Pizza(15, "Pizza Bianca", 62));
        menu.add(new Pizza(16, "Pizza al Taglio", 85));
        menu.add(new Pizza(17, "Boscaiola", 72));
        menu.add(new Pizza(18, "Pizza Verde", 60));
        menu.add(new Pizza(19, "Calzone", 70));
        menu.add(new Pizza(20, "Pizza Romana", 75));
        menu.add(new Pizza(21, "Pizza al Salmone", 82));
        menu.add(new Pizza(22, "Pizza Salsiccia", 75));
        menu.add(new Pizza(23, "Pizza alla Panna", 68));
        menu.add(new Pizza(24, "Pizza ai Funghi Porcini", 80));
        menu.add(new Pizza(25, "Pizza con Melanzane", 70));
        menu.add(new Pizza(26, "Pizza al Vongole", 88));
        menu.add(new Pizza(27, "Pizza di Recco", 82));
        menu.add(new Pizza(28, "Pizza con Pesto", 75));
        menu.add(new Pizza(29, "Pizza al Prosciutto", 72));
        menu.add(new Pizza(30, "Pizza al Tartufo", 90));
        menu.add(new Pizza(31, "Pizza Fritta", 85));
        }

    // Statisk metode til at vise hele menuen af pizzaer på konsollen
    public static void visMenu(){
        // Itererer over alle pizzaer i menuen og udskriver dem ved hjælp af toString-metoden
        for (Pizza pizza : menu){
            System.out.println(pizza);
        }
    }
}
