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
       Plant.plants.add(createPlant(0));
    }

    public static void editPlant(){
        System.out.println("Pasirinkite augalo id kurį norite redaguoti: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if(plants.get(i).id == id){
                plants.set(i,createPlant(id));
                return;
            }
        }

    }
    public static Plant createPlant (int id){
        Plant p;
        if (id == 0){
            p = new Plant();
        }else{
            p = new Plant(id);
        }
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
}