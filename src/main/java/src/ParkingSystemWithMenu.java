package src;

public class ParkingSystemWithMenu {
        public static void main(String[] args) {
            
            int parkingSpace;
            parkedCarList list;
    
            System.out.println("Enter maximum number of parking space: ");
            // call the private method to initiate user value to its variable
            parkingSpace = EasyScanner.nextInt();
            // make the private variable list be the constructor of parkedCarList to set max space in collection class
            list = new parkedCarList(parkingSpace);
            // Call readRecord method from parkedCarFileHandler class
            parkedCarFileHandler.readRecord(list);
    
            // The list of choice's the user can choose
            char choice;
            do {
                System.out.println();
                System.out.println("1. Enter car park");
                System.out.println("2. Leave car park");
                System.out.println("3. Check if car park is full");
                System.out.println("4. Get total number of cars");
                System.out.println("5. Check if car is registered");
                System.out.println("6. List cars currently parked");
                System.out.println("7. List registered cars");
                System.out.println("8. Save and Quit");
                System.out.println();
                System.out.print("Enter choice (1-8): ");
                choice = EasyScanner.nextChar();
                System.out.println();
    
                switch(choice) {
                    case '1': addHandler(parkingSpace, list);
                        break;
                    case '2': leaveHandler(parkingSpace, list);
                        break;
                    case '3': isFullHandler(parkingSpace, list);
                        break;
                    case '4': getTotalHandler(list);
                        break;
                    case '5': checkRegisteredHandler(list);
                        break;
                    case '6': listParkedCarHandler(parkingSpace, list);
                        break;
                    case '7': listRegisteredHandler(parkingSpace, list);
                        break;
                    case '8': saveAndQuitHandler(parkingSpace, list);
                        break;
                    default: System.out.println("Enter choice from (1-8): ");
                }
            } while(choice != '8');
        }
    
        // Here we will implement the methods used in our parkedCar & registered classes into the handler methods in the case
        static void addHandler(int noOfSpaceIn, parkedCarList listIn) {
            System.out.println("Enter name: ");
            String name = EasyScanner.nextString();
            System.out.println("Enter Car number plate: ");
            int userID = EasyScanner.nextInt();
            System.out.println("Car Register, select [1-2]: ");
            System.out.println("[1] - Yes");
            System.out.println("[2] - No");
            int userSC = EasyScanner.nextInt();
            boolean tempRegis = true;
            boolean regis;
    
            if(userSC == 1){
                tempRegis = true;
            } else if (userSC == 2){
                System.out.println("Please register here");
                System.out.println("Would you like to register, please input [1] or [2]: ");
                System.out.println("[1] - Yes");
                System.out.println("[2] - No");
                int userInput = EasyScanner.nextInt();
                if(userInput == 1) {
                    tempRegis = true;
                    System.out.println("Car has successfully registered");
                    System.out.println();
                } else if (userInput == 2) {
                    System.out.println("Only registered cars can park here");
                }
            } else {
                System.out.println("Please enter number 1 or 2");
            }
    
            regis = tempRegis;
            parkedCar carObj = new parkedCar(name, userID, regis);
    
            if(listIn.isFull()) {
                System.out.println("There are no space in Car park left");
            } else if (carObj.checkCarRegistered() == true){ // Car can park
                listIn.addParkedCar(carObj);
                System.out.println("Car successfully parked for " + name);
            } else if (carObj.checkCarRegistered() == false){
                System.out.println(carObj.checkCarRegistered());
                System.out.println("Car is not registered, please register to park car");
            }
        }
    
        static void leaveHandler(int noOfSpaceIn, parkedCarList listIn) {
            System.out.println("Enter you ID: ");
            int enteredID = EasyScanner.nextInt();
            parkedCar checkID = listIn.search(enteredID);
            // Check if the ID exists
            if(checkID.getID() != enteredID) {
                System.out.println("The ID belonging to the user does not exist in the car park");
            } else if(checkID.getID() == enteredID) {
                // ID exists and can be removed
                listIn.leaveCarParked(enteredID);
                System.out.println("User with ID " + enteredID + " successfully left the car park");
            }
        }
    
        static void isFullHandler(int noOfSpaceIn, parkedCarList listIn) {
            int parkSpaceLeft = noOfSpaceIn - listIn.getTotal();
            if(listIn.getTotal() <= noOfSpaceIn) { // Check if there is any space
                System.out.println("There are no parking space as it has reached max of " + noOfSpaceIn);
            } else {
                System.out.println("Car park is not full, there are " + parkSpaceLeft + " left in the car park." );
            }
        }
    
        static void getTotalHandler(parkedCarList listIn) {
            System.out.println("There are " + listIn.getTotal() + " cars in total in the car park."); 
        }
        
        static void checkRegisteredHandler(parkedCarList listIn) {
            System.out.println("Enter the given ID for car: ");
            int userID = EasyScanner.nextInt();
            parkedCar checkID = listIn.search(userID);
    
            if(checkID.getID() != userID) { // Check if ID exists
                System.out.println("Car ID doesnt exist");
            } else if(checkID.getID() == userID){
                if(checkID.checkCarRegistered() == true) {
                    System.out.println("The given Car ID ("+ userID + ") is currently registered");
                } else {
                    System.out.println("The given Car ID " + userID + " is not registered in our system.");
                }
            }
        }
    
        static void listParkedCarHandler(int noOfSpaceIn ,parkedCarList listIn) {
            int i;
            if(listIn.isEmpty()) { // Check if there is any car objects in the list
                System.out.println("There are no cars in the car park");
            } else {
                System.out.println("List of cars currently parked: ");
                for(i = 1; i <= listIn.getTotal(); i++) {
                    System.out.println(listIn.getParkedCar(i).getName()
                                                            + "\t\t"
                                                            + listIn.getParkedCar(i).getID()
                    );
                }
            }
        }
    
        static void listRegisteredHandler(int noOfSpaceIn, parkedCarList listIn) {
            int i;
            if(listIn.isEmpty()) { // Check if there is any car objects in the list
                System.out.println("There are no cars in the car park");
            } else {
                System.out.println("List of registered cars currently parked: ");
                for(i = 1; i <= listIn.getTotal(); i++) {
                    parkedCar carObj = listIn.getParkedCar(i);
                    if(carObj.checkCarRegistered() == true) {
                        System.out.println(carObj.getName() 
                                                + "\t\t"
                                                + carObj.getID()
                        );
                    }
                }
            }
        }
    
        static void saveAndQuitHandler(int noOfSpaceIn, parkedCarList listIn) {
            parkedCarFileHandler.saveRecords(noOfSpaceIn, listIn);
        }
    
}
