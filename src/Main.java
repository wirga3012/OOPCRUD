import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Plant plant1 = new Plant();
        plant1.setSpecies("Gooseberry");
        plant1.setSpeciesInLatin("Ribes uva-crispa");
        plant1.setAnnual(false);
        plant1.setContinent("Europe");
        plant1.setHeight(40);
        plant1.setIsEdible(true);

        Plant plant2 = new Plant();
        plant2.setSpecies("Lilac");
        plant2.setSpeciesInLatin("Syringa");
        plant2.setAnnual(false);
        plant2.setContinent("Europe");
        plant2.setHeight(200);
        plant2.setIsEdible(false);

        Plant plant3 = new Plant("Buttercup", "Ranunculaceae", false, "Europe", 100, true);
        Plant plant4 = new Plant("Grapevine", "Vitis", false, "Europe", 400, true);

       Plant.plants.add(plant1);
       Plant.plants.add(plant3);
       Plant.plants.add(plant4);
       Plant.plants.add(plant2);

//        for (int i = 0; i < plants.size(); i++) {
//            System.out.println(plants.get(i));
//        }

        while (true) {
            Plant.info();

            int input = sc.nextInt();

            sc.nextLine();
            switch (input) {
                case 1:
                    Plant.printPlants();
                    break;
                case 2:
                    Plant.addPlant();
                    break;
                case 3:
                    System.out.println("Redaguoti augalą");
                    break;
                case 4:
                    System.out.println("Ištrinti augalą");
                    break;
                case 5:
                    System.out.println("Išeiti iš programos");
                    break;
                default:
                    System.out.println("Atsiprašome tokio varianto nera");
            }

        }
    }


}