package src;
import java.util.*;

public class registeredList {
    
    private Set<registered> pSet;
    public final int MAX;

    /** Constructor initialises the empty parkedCar set and sets the maximum set size, esentially the maximum capacity of the car park
     *  @param  maxIn: The maximum number of cars parked in the set
     */

     public registeredList(int maxIn) {
        pSet = new HashSet<>();
         MAX = maxIn;
     }

     // Checks if the parkedCar set is full, returns true if the set is full and false if not
     public boolean capacity() {
         return pSet.size() == MAX;
     }

     // Gets the total number of parkedCars in the set
     public int getTotal() {
         return pSet.size();
     }

     // Add a new Car object to the set
     public boolean addCarToPark(registered userIn) {
        if(!capacity()) {
            pSet.add(userIn);
            return true;
        } else {
            return false;
        }
     }
     
     // Remove the car user in the given user ID, userID is the ID given by the user and we will use as parameter to remove car user, if it returns true then it will remove succesfully or false otherwise.
     public boolean removeCarToPark(registered userID) {
         boolean findP = pSet.contains(userID);
         // check if car user is found at the given user ID
         if (findP == true) {
             // remove the given car user
             pSet.remove(userID);
             return true;
         } else {
             // no car user for the given user ID
             return false; 
         }
     }

     @Override 
     public String toString() {
         return pSet.toString();
     }
}
