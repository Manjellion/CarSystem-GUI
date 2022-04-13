package tests;
import java.util.Scanner;

import src.EasyScanner;
import src.registered;
import src.registeredList;

public class registeredListTester {
    public static void main(String[] args) {
        char choice;
        int size;
        registeredList parkingList; // declare parkedCar object to test

        // get the size of the set
        System.out.println("Size of the parking list: ");
        size = EasyScanner.nextInt();
        parkingList = new registeredList(size);
        

        // menu

        do {
            // display the options
            System.out.println();
            System.out.println("[1] ADD");
            System.out.println("[2] DISPLAY");
            System.out.println("[3] REMOVE");
            System.out.println("[4] GET TOTAL");
            System.out.println("[5] IS FULL");
            System.out.println("[6] IS CAR REGISTERED");
            System.out.println("[7] Quit");
            System.out.println("Enter a choice [1-7]: ");
            // get choice
            choice = EasyScanner.nextChar();
            System.out.println();
            // process choice
            switch(choice) {
                case '1': option1(parkingList); break;
                case '2': option2(parkingList); break;
                case '3': option3(parkingList); break;
                case '4': option4(parkingList); break;
                case '5': option5(parkingList); break;
                case '6': option6(parkingList); break;
                case '7': System.out.println("TESTING COMPLETE");; break;
                
                default: System.out.println("1-7 only");
            }
        } while (choice != '7');
    }

    // Add 
    static void option1(registeredList listIn) {
        // make a prompt for car user details
        System.out.println("Do you have registration (True or False): ");
        Scanner sc = new Scanner(System.in);
        boolean regis = sc.nextBoolean();
        // create a car objectto set
        registered user = new registered(regis);
        // attempt to add the car to the set, if the park isnt full then it will go through as true, if false then the statement will reutrn below. 
        boolean info_correct = listIn.addCarToPark(user);
        if(!info_correct) System.out.println("ERROR: the parking spaces are full");
    }
    
    // DISPLAY
    static void option2(registeredList listIn) {
        System.out.println("CARS CURRENTLY PARKED");
        System.out.println(listIn);
    }

    // REMOVE (Function not working come back to later)
    static void option3(registeredList listIn) {
        System.out.println("ENTER DETAILS OF THE CAR YOU WANT TO REMOVE");
        System.out.println("Enter the name of the car you want to remove: ");
        System.out.println("Enter 4 digit ID of the car you want to remove: ");
        System.out.println("Does the car you want to move have registration (True or False): ");
        Scanner sc = new Scanner(System.in);
        boolean regis = sc.nextBoolean();
        // create a car objectto set
        registered user = new registered(regis);

        boolean info = listIn.removeCarToPark(user);
        if(!info) System.out.println("ERROR: incorrect info placed, car will not be removed");
    }
    // GET TOTAL
    static void option4(registeredList listIn) {
        System.out.println("TOTAL NUMBER ENTERED: ");
        System.out.println(listIn.getTotal());
    }
    // IS FULL
    static void option5(registeredList listIn) {
        if (listIn.capacity()) {
            System.out.println("List is full");
        } else System.out.println("List is not full");
    }
    // CAR REGISTRATION (Is your car currently parking and registered in the system)
    static void option6(registeredList listIn) {

    }
}
