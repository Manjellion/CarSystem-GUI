package src;
// Class used to identify the records of the car registered 
public class registered {
    private boolean carRegistered;
    
    // Constructor created for the class to create object 
    public registered(boolean carRegtistertration) {
        carRegistered = carRegtistertration;
    }

    public boolean getRegistered() {
        return carRegistered;
    }

    // get the car users registration and clarify if its in the system or not
    public boolean registeredCar() {
        if(carRegistered == true) {
            return true;
        } else {
            return false;
        } 
    }   

    // overriden method to print out the following String when called
    @Override
     public String toString() {
         String toStringTemp ="";

         if(registeredCar() == true) {
             toStringTemp = "Car is registered";
         } else if (registeredCar() == false) {
             toStringTemp = "Car is not registered";
         }

         return toStringTemp;
     }

    public static boolean addCarToPark(registered addCarIn) {
        return false;
    }
}