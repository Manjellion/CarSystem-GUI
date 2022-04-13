package src;

import java.util.ArrayList;

// Collection class to hold a set of parked Cars
public class parkedCarList {

    private ArrayList<parkedCar> parkedList;
    public final int MAX;

    // Constructor to initialise the empty parkedCar HashSet and the maximum list of size
    public parkedCarList(int maxIn) {
        parkedList = new ArrayList<>();
        MAX = maxIn;
    }

    // Add a mew parkedCar object to the HashSet
    public boolean addParkedCar(parkedCar parkedIn) {
        if(!isFull()) {
            parkedList.add(parkedIn);
            return true;
        } else return false;
    }

    // parkedCar object leaves the parkedCar object when given the correct ID to the object
    public boolean leaveCarParked(int removeUser) {
        parkedCar findSet = search(removeUser);
        if (findSet != null) {
            parkedList.remove(findSet); // parkedCar object has been removed
            return true;
        } else return false; // no parkedCar object is remvoed
    }

    public boolean checkCarRegistered(parkedCar checker) {
        return checker.checkCarRegistered();
    }

    // Search for the parkedCar object using the ID given
    public parkedCar search(int ID) {
        for(parkedCar currentParkedCar : parkedList) {
            // find parkedCar object with the given ID
            if(currentParkedCar.getID() == ID) {
                return currentParkedCar;
            }
        }
        return null; // no parkedCar object found with given ID
    }

    // Reads the parkedCar object at the given position in the array
    public parkedCar getParkedCar(int positionIn) {
        // check for valid position
        if (positionIn < 1 || positionIn > getTotal()) {
            return null; // No object ound in the given position
        } else {
            return parkedList.get(positionIn - 1);
        }
    }

    // Reports on whether or not the list from the collection is empty
    public boolean isEmpty() {
        return parkedList.isEmpty();
    }

    // Reports on whether or not the list is full
    public boolean isFull() {
        return parkedList.size() == MAX;
    }

    // Ge te total number of parkedCar objects
    public int getTotal() {
        return parkedList.size();
    }

    @Override
    public String toString() {
        return parkedList.toString();
    }
}
