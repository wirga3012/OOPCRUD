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
                + "Is" + edibleOrNot + "\n");
    }

    public static void info() {
        System.out.println("1. Pamatyti sąrašą");
        System.out.println("2. Pridėti augalą");
        System.out.println("3. Redaguoti augalą");
        System.out.println("4. Ištrinti augalą");
        System.out.println("5. Išeiti iš programos");
    }

    public static void printPlants() {
        for (int i = 0; i < plants.size(); i++) {
            System.out.println(plants.get(i));
        }
    }

    public static void addPlant() {
        Plant plant = new Plant();

        System.out.println("1. Įveskite augalo pavadinimą: ");
        plant.setSpecies(sc.nextLine());

        System.out.println("2. Įveskite augalo pavadinimą Lotyniškai: ");
        plant.setSpeciesInLatin(sc.nextLine());

        System.out.println("3. Kokiame žemyne auga?: ");
        plant.setContinent(sc.nextLine());

        System.out.println("4. Ar augalas vienmetis?(true/false): ");
        plant.setAnnual(sc.nextBoolean());

        System.out.println("5. Ar augalas valgomas?(true/false): ");
        plant.setIsEdible(sc.nextBoolean());

        plants.add(plant);
    }

//    public static void updatePlant(int id) {
////        for(Account account : accountsList) {
////            if(account.getId().equals(someId) {
////                //found it!
////            }
////        }
//
//    }


}