# CarSystem-GUI - 1
 A Graphical user interface model for a Car Parking Application able to add user into the parking if they are registered and let them leave, you can also request for reports on list of registered cars and parked cars seperately.
 
 ## Design of the ParkingSystem (JavaFX GUI) 1.1
 Previously we created a parking system UML diagram as a part of our car park application design but didnt give an key details on this class. Here we will consider the ParkingSystem class now and create the UML diagram with the key attributes and methods included. 
 
![image](https://read-api.kortext.com/mvc/e/396806/OEBPS/images/467128_4_En_12_Chapter/467128_4_En_12_Fig1_HTML.png)
 
 As you can see, the ParkingSystem class requires a single instance of the parkedCarList collection class we developed in our previous design, this instance is recorded as the private list attribute in the ParkingSystem class.
 <br>
 Our Car parking application will have a JavaFX interface, so the ParkingSystem class also needs to inherit from the JavaFX Application class. Consquestnly we need to provide a start method to add components to the Stage and proccess the event-handling routines. This method will also initialise the parkedCar list and read any data into this list from a file (using the aforementioned parkedCarFileHandler class).
 <br>
 In order to initialise the parkedCar list we have to add a noOfSpaces integer attribute to record how many car parking spcaes is limited. We have also added a private method, getNumberOfCarParks, to request this space limit to the user. We have included a main method to launch the application.
 <br>
<img width="617" alt="Screenshot 2022-04-13 at 22 46 50" src="https://user-images.githubusercontent.com/77361838/163275828-487b5ff2-bd0f-476e-bb0d-172b06853789.png">
<br>

You can see, in the start method, we have called the private getNumberOfSpaces method uses a standard text window for output and the keyboard input. The readRecords method of the parkedCarFileHandler class is then used in the start method to load into the parkedCar list any pre-existing parkedCar records saved to file.
<br>
Remaining code within this class will relate to the GUI for this application so lets consider the design of the GUI now.

## Design of the GUI 1.2

There will be two aspects to design of the grpahical interface. FIrstly, we need to design the visual side of things, then we need to design the algorithm for our event handling routines so that the buttons do the jobs we want them to do, like adding or displaying parked cars.
<br> 
Let's start with the visual design. We need to choose which graphics components we are going to use and how to lay them out. One way to do this is to make a preliminary sktech such as the one shown below.

![image](https://user-images.githubusercontent.com/77361838/163276562-c9872adf-fa28-443e-ba24-25ec68dfe314.png)

