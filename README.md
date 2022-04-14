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

<br>
It should be clear which JavaFX components we will be using here. We have a selection of buttons on our GUI as shown below. 

![image](https://user-images.githubusercontent.com/77361838/163276778-a7d39f21-d403-47df-81d0-f1f5bf5f4bcc.png)

<br>
The remaining components are Label and TextField. In the examples you saw in the previous Application with a Menu, you saw that we created our visual components within our start method. This made sense as the algorithms for our button event handlers (which needed access to these components) were also contained within the start method. In this application however, we would expect to have much more complicated algorithms for our button event handlers, so we will structure things a little differently. In this parkedCarSystem class we will implement our event handlers in a series of private methods (one for each button).
<br>
One implication of implementing the event handling code in seperate methods is that it makes more sense now to make our visual components accessible throughout the class rather than just in the start method. To do that we make these visual components attributes of the parkedCarSystem  class. In the code snippet below we create these component attributes in the order they appear in our GUI design shown in the example of the design above. 

<img width="685" alt="Screenshot 2022-04-13 at 23 36 47" src="https://user-images.githubusercontent.com/77361838/163281331-9efa68f1-7713-494b-ae59-9fcc88529d3a.png">

<br>

Now let's turn the layout of these components. We will use a mixture of HBox and VBox to organise our layout.

![image](https://user-images.githubusercontent.com/77361838/163281437-7899e3ae-6d55-4299-8a54-d10af3f5cce4.png)

<br>
As always, we use the start method to organise our layout:

<img width="830" alt="Screenshot 2022-04-14 at 00 08 31" src="https://user-images.githubusercontent.com/77361838/163284199-d5c108cb-de13-4db9-b754-88a12735fcab.png">

We have created the HBox and then added the relevant components, we then do the same for the VBox. Finally, we add the VBox to the Scene.
<br>
Eventually we will also customise the look of our visual components (by setting fonts and borders for example) when we present the complete code for the class. But now let's turn our attention to designing the event-handlers for the buttons on our GUI.

## Designing the Event-Handlers

As you saw there are a total of 6 buttons that need to be coded so that they respond in the correct way when pressed:
<br>

• the add object button
• the remove object button
• the display all object that are parked button
• the save and quit button
• the display all object that are registered button
• the register object button
<br>
As always, we will use the setOnAction method of each button to process these button clicks, but (as we said in the previous section) we will place the code for the event-handlers in separate private methods and call these methods from our lambda experssions:
<br>
<img width="611" alt="Screenshot 2022-04-14 at 15 15 46" src="https://user-images.githubusercontent.com/77361838/163409542-61068ad0-6c89-4091-9adf-6b1834829014.png">
<br>
We have summarized below the task that each button's event-handler method must perform, and then gone on to design our algorithms using pseudocode. 

### The Add Button 1.2.1

The purpose of this button is to add a new Object to the list. The values entered in Label and text field must be validated; first of all, they must not be blank; second, the car park space must be greater than the total of parked cars (or less than 0); finally, the room must not be occupied. If all this is okay, then the new object is added (we will make use of the addParkedCar method of parkedCarList class to do this) and a message should be displayed in display area. We can express this in pseudocode as follows:
<br>
read nameField
read IdField
check if registered
IF field blank
  display blank field error in display are
ELSE IF IdFIeld is registered 
   BEGIN
       add object
       blank nameField
       bank IdField
       display message to confirm success in display area
   END
ELSE 
    display invalid ID is not reigstered in display area
 

### The Remove Button 1.2.2

Clicking on this button will remove the object whose ID has been entered into the field.
As with the Add button, the ID entered must be validated; we will use a search method from parkedCarList to scan through the array list in linear time and see if the ID matches with the current index of object. A confirmation message is displayed.
The pseudocode for this event-handler is given as follows:
<br>
IF field blank
      display blank field error in display area
ELSE IF search ID is equal to ID
      remove object from list
      display message to confirm success in display area
ELSE
    display ID does not exist in list in display area
END

### The Display Button 1.2.3

