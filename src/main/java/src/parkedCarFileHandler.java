package src;

import java.io.*;
// Class to handle file
public class parkedCarFileHandler {
    // two parameters that will take in is the MAX (Array List max) and the list of the all the cars parked
    // This method will save the object input by the user to the collection class inside an array
    public static void saveRecords(int noOfSpaceIn, parkedCarList listIn) {
        try {
            // create a file output to write and represent by the specified File output
            FileOutputStream carFile = new FileOutputStream("Cars.dat");
            // Allows us to manipulate the file
            DataOutputStream carWriter = new DataOutputStream(carFile);
            carWriter.writeInt(listIn.getTotal());
            // Will go through the whole array and print the Name and ID
            for(int i = 1; i <= noOfSpaceIn; i++) {
                if(listIn.getParkedCar(i) != null) {
                    carWriter.writeUTF(listIn.getParkedCar(i).getName());
                    carWriter.writeInt(listIn.getParkedCar(i).getID());
                    carWriter.writeBoolean(listIn.getParkedCar(i).getRegister());
                }
            }
            carWriter.flush();
            carWriter.close();
        } catch(IOException err) {
            System.out.println("Error with writing the file, error syntax: " + err);
        }
    }

    public static void readRecord(parkedCarList listIn) {
        try {
            FileInputStream carFile = new FileInputStream("Cars.dat");
            DataInputStream carReader = new DataInputStream(carFile);

            String tempName = new String("");
            int tempID = 0;
            boolean tempRegis = true;
            parkedCar tempParkedCar = null;
            int total = 0;

            total = carReader.readInt();
            for(int i = 1; i <= total; i++) {
                tempName = carReader.readUTF();
                tempID = carReader.readInt();
                tempRegis = carReader.readBoolean();
                tempParkedCar = new parkedCar(tempName, tempID, tempRegis);
                listIn.addParkedCar(tempParkedCar);
            }
            carReader.close();
        } catch(IOException err) {
            System.out.println("No records are found in this file, error syntax: " + err);
        }
    }
}
