package com.comapany;

import com.comapany.controller.NecklaceController;
import com.comapany.controller.StoneController;
import com.comapany.entities.Stone;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final NecklaceController controller;
    private final StoneController controller1;
    private final Scanner scanner;

    public MyApplication(NecklaceController controller, StoneController controller1) {
        this.controller = controller;
        this.controller1 = controller1;
        scanner = new Scanner(System.in);
    }
    public void start() {//options of my applications
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1.Calculate cost");
            System.out.println("2.Calculate weight");
            System.out.println("3.Create Necklace");
            System.out.println("4.Create Stone");
            System.out.println("5.Get all necklaces");
            System.out.println("6.Get all stones");
            System.out.println("7.Get necklace by id");
            System.out.println("8.Get stone by id");
            System.out.println();
            try {//it is how works my options
                System.out.print("Enter option (1-8): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    calculateCost();
                } else if (option==2){
                    calculateWeight();
                }else if (option==3){
                    createNecklaceMenu();
                }else if(option==4){
                    createStoneMenu();
                }else if(option==5){
                    getAllNecklaceMenu();
                } else if(option==6){
                    getAllStoneMenu();
                }else if(option==7){
                    getNecklacesByIdMenu();
                } else if(option==8){
                    getStoneByIdMenu();
                }else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void calculateCost() {
        System.out.println("Please enter id stone ");
        int id = scanner.nextInt();
        System.out.println("Please enter id necklace");
        int id1 = scanner.nextInt();

        int response = controller.CalculateCost(id,id1);
        System.out.println(response);
    }
    public void calculateWeight(){
        System.out.println("Please enter id stone for getting weight ");
        int weight = scanner.nextInt();
        System.out.println("Please enter necklace id for getting weight ");
        int weight1 = scanner.nextInt();

        int response = controller.CalculateCost(weight,weight1);
        System.out.println("Weight in carats "+response);
    }
    public void createNecklaceMenu() {
        System.out.println("Please enter id");
        int necklace_id = scanner.nextInt();

        System.out.println("Please enter name");
        String name = scanner.next();

        System.out.println("Please enter price");
        int cost1 = scanner.nextInt();

        System.out.println("Please enter weight");
        int weight = scanner.nextInt();

        System.out.println("Please enter number of stones");
        int stones = scanner.nextInt();
        String response = controller.createNecklace(necklace_id, name, cost1, weight,stones);
        System.out.println(response);
    }
    public void createStoneMenu() {
        System.out.println("Please enter id");
        int stone_id = scanner.nextInt();

        System.out.println("Please enter name");
        String name = scanner.next();

        System.out.println("Please enter price");
        int cost = scanner.nextInt();

        System.out.println("Please enter weight");
        int weight = scanner.nextInt();


        String response = controller1.createStone(stone_id, name, cost, weight);
        System.out.println(response);
    }
    public void getAllNecklaceMenu() {
        String response = controller.getAllNecklaces();
        System.out.println(response);
    }
    public void getAllStoneMenu() {
        String response = controller1.getAllStones();
        System.out.println(response);
    }
    public void getNecklacesByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        int response = controller.getNecklaceById(id);
        System.out.println(response);
    }
    public void getStoneByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        int response = controller1.getStoneById(id);
        System.out.println(response);
    }

}
