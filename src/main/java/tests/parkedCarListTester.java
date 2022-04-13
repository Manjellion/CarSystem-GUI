package tests;
import src.parkedCar;
import src.parkedCarList;

public class parkedCarListTester {
    public static void main(String[] args) {

        // registered Car
        parkedCar user1 = new parkedCar("Manjil", 1, true);
        // not registered Car
        parkedCar user2 = new parkedCar("Nikita", 2, false);
         // registered Car
         parkedCar user3 = new parkedCar("David", 3, true);
         // not registered Car
         parkedCar user4 = new parkedCar("Ceelo", 4, false);
        
        parkedCarList parkingSystem = new parkedCarList(4);

        {/* Tests for adding, removing, viewing and getting total methods from parkedCarList */}
        // If the terminal prints true then the object has been added to the array and stored in the collection
        System.out.println(parkingSystem.addParkedCar(user1)); 
        // Should increase by 1 since we added to the car park
        System.out.println(parkingSystem.getTotal());
        // Lets see the details of the parked cars inside the array
        System.out.println(parkingSystem.toString());
        // Let remove a car, if the terminal prints true then the object has successfully been removed
        System.out.println(parkingSystem.leaveCarParked(0001));
        // The total should be 0 now
        System.out.println(parkingSystem.getTotal());

        {/* Tests for searching car, get car*/}
        parkingSystem.addParkedCar(user1);
        parkingSystem.addParkedCar(user2);
        parkingSystem.addParkedCar(user3);
        parkingSystem.addParkedCar(user4);

        // Using Search method this will return the full details of the object from the array 
        System.out.println(parkingSystem.search(003));

        // Using the geParkedCar method user can input the number the object is listed in array to return that object
        System.out.println(parkingSystem.getParkedCar(2));
    
        {/* This method isFull will check if the system is full or not/ reach maximum capacity for array, isEmpty will check if empty */}
        // Since our array we made the object max to be held at 4 and we added 4 objects it should return to be full
        // Is empty should return false as it is not empty
        System.out.println(parkingSystem.isEmpty());
        // This should return true as the size of the array does = to the max capacity of 4
        System.out.println(parkingSystem.isFull());
        // Total should now be 4 as we added 4 objects to the collection
        System.out.println(parkingSystem.getTotal());
    }
}
