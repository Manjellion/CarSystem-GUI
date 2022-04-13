package src;

public class parkedCar {

    private String userName;
    private int userID;
    private boolean registered; 

    // Constructor initialises the CarUser which is using the class registered to get the userName and userID

    public parkedCar(String nameIn, int idIn, boolean regis) {
        userName = nameIn;
        userID = idIn;
        regis = registered;
    }

    // Records the details the user made to see if the car is registered
    public Boolean checkCarRegistered() {
        if(registered != true) {
            return true;
        } else {
            return false;
        } // return boolean so the method can be called in registeredList
    }

    // Reads the name of the car user
    public String getName() {
        return userName;
    }

    // Reads the ID of the car user 
    public int getID() {
        return userID;
    }

    public boolean getRegister() {
        return registered;
    }

    // Get a print of the user 
    @Override
    public String toString() {
        return userName + ", " + userID + ", " + registered; 
    }
}
