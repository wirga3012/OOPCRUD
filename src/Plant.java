import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Plant {
    public static ArrayList<Plant> plants = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    private static int idCount = 0;

    private final int id;
    private String species;
    private String speciesInLatin;
    private boolean isAnnual;
    private String continent;
    private int height;
    private boolean isEdible;

    public Plant() {
        this.id = ++idCount;
    }
    public Plant(int id) {
        this.id = id;
    }
    public Plant(String species, String speciesInLatin, boolean isAnnual, String continent, int height, boolean isEdible) {
        this.id = ++idCount;
        this.species = species;
        this.speciesInLatin = speciesInLatin;
        this.isAnnual = isAnnual;
        this.continent = continent;
        this.height = height;
        this.isEdible = isEdible;
    }

    public int getId() {
        return this.id;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpeciesInLatin() {
        return this.speciesInLatin;
    }

    public void setSpeciesInLatin(String speciesInLatin) {
        this.speciesInLatin = speciesInLatin;
    }

    public boolean getIsAnnual() {
        return this.isAnnual;
    }

    public void setAnnual(boolean isAnnual) {
        this.isAnnual = isAnnual;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getIsEdible() {
        return this.isEdible;
    }

    public void setIsEdible(boolean isEdible) {
        this.isEdible = isEdible;
    }


    @Override
    public String toString() {
        String annual = isAnnual ? "annual" : "not annual";
        String edibleOrNot = isEdible ? "edible" : "not edible";
        return ("ID- " + id + "\n"+
                "Species- " + species + ",\n"
                + "Species in Latin- " + speciesInLatin + ",\n"
                + "Is " + annual + ",\n"
                + "Continent- " + continent + ",\n"
                + "Height (cm)- " + height + ",\n"
                + "Is " + edibleOrNot + "\n");
    }

    public static void info() {
        System.out.println("1. Pamatyti sąrašą");
        System.out.println("2. Pridėti augalą");
        System.out.println("3. Filtruoti augalą");
        System.out.println("4. Redaguoti augalą");
        System.out.println("5. Ištrinti augalą");
        System.out.println("6. Išeiti iš programos");
    }

    public static void printPlants() {
        for (int i = 0; i < plants.size(); i++) {
            System.out.println(plants.get(i));
        }
    }

    public static void addPlant() {
       Plant.plants.add(fillPlant(new Plant()));
    }

    public static void editPlant(){
        System.out.println("Pasirinkite augalo id kurį norite redaguoti: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).id == id){
                plants.set(i, fillPlant(new Plant(id)));
                return;
            }
        }

    }
    public static Plant fillPlant (Plant p){
        System.out.println("1. Įveskite augalo pavadinimą: ");
        p.setSpecies(sc.nextLine());

        System.out.println("2. Įveskite augalo pavadinimą Lotyniškai: ");
        p.setSpeciesInLatin(sc.nextLine());

        System.out.println("3. Kokiame žemyne auga?: ");
        p.setContinent(sc.nextLine());

        System.out.println("4. Nurodykite augalo aukštį (cm)?: ");
        p.setContinent(sc.nextLine());

        System.out.println("5. Ar augalas vienmetis?(true/false): ");
        p.setAnnual(sc.nextBoolean());

        System.out.println("6. Ar augalas valgomas?(true/false): ");
        p.setIsEdible(sc.nextBoolean());
        sc.nextLine();
        return p;
    }
    public static void deletePlant(){
        System.out.println("Pasirinkite augalo id kurį norite ištrinti:");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).id == id){
               plants.remove(i);
               return;
            }
        }
    }
    public static void filterPlant(){
        System.out.println("Pasirinkite pagal kurį lauką norėsite filrtuoti");
        System.out.println("1.Pagal augalo pavadinimą");
        System.out.println("2.Pagal augalo pavadinimą Lotyniškai");
        System.out.println("3.Pagal žemyną");
        System.out.println("4.Pagal augalo aukštį");
        System.out.println("5.Vienmetis ar daugiametis (true/false");
        System.out.println("6.Valgomas ar nevalgomas (true/false");
        int input = sc.nextInt();
        sc.nextLine();
        switch (input){
            case 1:
                filterBySpecies();
                break;
            case 2:
                filterBySpeciesInLatin();
                break;
            case  3:
                filterByContinet();
                break;
            case 4:
                filterByHeight();
                break;
            case 5:
                filterByIsAnnual();
                break;
            case 6:
                filterByIsEdible();
                break;
        }
    }
    public static void filterBySpecies(){
        System.out.println("Įveskite rūšį arba rūšies fragmentą:");
        String input = sc.nextLine().toLowerCase();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).species.toLowerCase().contains(input)){
                System.out.println(plants.get(i));
            }
        }
    }
    public static void filterBySpeciesInLatin(){
        System.out.println("Įveskite rūšį arba rūšies fragmentą Lotyniškai:");
        String input = sc.nextLine().toLowerCase();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).speciesInLatin.toLowerCase().contains(input)){
                System.out.println(plants.get(i));
            }
        }
    }
    public static void filterByContinet(){
        System.out.println("Įveskite žemyną:");
        String input = sc.nextLine().toLowerCase();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).continent.toLowerCase().contains(input)){
                System.out.println(plants.get(i));
            }
        }
    }
    public static void filterByHeight(){
        System.out.println("Įveskite augalo aukštį:");
        int input = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).height == input){
                System.out.println(plants.get(i));
            }
        }
    }
    public static void filterByIsAnnual(){
        System.out.println("Ar augalas daugiametis (true/false):");
        boolean input = sc.nextBoolean();
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).isAnnual == input){
                System.out.println(plants.get(i));
            }
        }
    }
    public static void filterByIsEdible(){
        System.out.println("Ar augalas valgomas:");
        boolean input = sc.nextBoolean();
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).isEdible == input){
                System.out.println(plants.get(i));
            }
        }
    }

}

