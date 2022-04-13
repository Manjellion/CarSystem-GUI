package tests;
import src.parkedCar;

public class parkedCarTest {
    public static void main(String[] args) {
        // registered Car
        parkedCar user1 = new parkedCar("Manjil", 1, true);
        // not registered Car
        parkedCar user2 = new parkedCar("Nikita", 2, false);
        System.out.println(user1.getName());
        System.out.println(user1.getID());

        System.out.println(user2.getName());
        System.out.println(user2.getID());

        // Should print a boolean value of true as this user is registered
        System.out.println(user1.getName() + " registration: " + user1.checkCarRegistered());

        // This should print false as the car is not registered
        System.out.println(user2.getName() + " registration: " +user2.checkCarRegistered());
    }
}
