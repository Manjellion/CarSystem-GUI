# CarSystem-GUI - 1
 A Graphical user interface model for a Car Parking Application able to add user into the parking if they are registered and let them leave, you can also request for reports on list of registered cars and parked cars seperately.
 
 ## Design of the ParkingSystem (JavaFX GUI) 1.1
 Previously we created a parking system UML diagram as a part of our car park application design but didnt give an key details on this class. Here we will consider the ParkingSystem class now and create the UML diagram with the key attributes and methods included. 
 
[imgage][https://user-images.githubusercontent.com/77361838/158159316-21f620bf-e2a2-4f08-b78b-11cb045ca25f.png]
 
 As you can see, the ParkingSystem class requires a single instance of the parkedCarList collection class we developed in our previous design, this instance is recorded as the private list attribute in the ParkingSystem class.
 <br>
 Our Car parking application will have a JavaFX interface, so the ParkingSystem class also needs to inherit from the JavaFX Application class. Consquestnly we need to provide a start method to add components to the Stage and proccess the event-handling routines. This method will also initialise the parkedCar list and read any data into this list from a file (using the aforementioned parkedCarFileHandler class).
 <br>
 In order to initialise the parkedCar list we have to add a noOfSpaces integer attribute to record how many car parking spcaes is limited. We have also added a private method, getNumberOfCarParks, to request this space limit to the user. We have included a main method to launch the application.
