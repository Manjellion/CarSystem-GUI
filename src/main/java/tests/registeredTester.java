package tests;

import src.registered;
import src.registeredList;

public class registeredTester {
    public static void main(String[] args) {
        // test create an object
        registeredList user1 = new registeredList(4);
        registered user1Test = new registered(true);
        registered user2Test = new registered(false);
        registered user3Test = new registered(false);
        registered user4Test = new registered(true);
        registered user5Test = new registered(false);
        registered user6Test = new registered(true);


        user1.addCarToPark(user1Test);
        user1.addCarToPark(user2Test);
        user1.addCarToPark(user3Test);
        user1.addCarToPark(user4Test);
        user1.addCarToPark(user5Test);
        user1.addCarToPark(user6Test);

        // test out different methods
        System.out.println("Total: " + user1.getTotal());
        user1.removeCarToPark(user1Test);
        System.out.println("Total: " + user1.getTotal());
        // test if method capacity() is returns false when not full
        if(user1.capacity() == true) {
            System.out.println("Car park is not full");
        } else if (user1.capacity() == false ) { 
            System.out.println("Car park is full");
        }
        // test out toString method overidden
        System.out.println(user1);
    }
}
