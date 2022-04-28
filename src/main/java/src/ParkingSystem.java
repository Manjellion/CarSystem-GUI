package src;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ParkingSystem extends Application{

    //attributes
    private int  noOfSpaces;
    private parkedCarList list;

    //Width and Height
    private final int WIDTH = 800;
    private final int HEIGHT = 500;

    //javaFX components as visual components declared as attributes for the class
    //To Add, remove, display and save & quit event handling
    //Visual Components
    private Label headingLabel = new Label("Car Park Application");
    private Label nameAddLabel = new Label("Name:");
    private TextField nameAddField = new TextField();
    private Label idAddLabel = new Label("ID:");
    private TextField idField = new TextField();
    private Button addBtn = new Button("Add to car park");
    private Button removeBtn = new Button("Remove from car park");
    private Button displayBtn = new Button("Display Parked Cars");
    private Button saveAndQuitBtn = new Button("Save and Quit");
    private TextArea displayParkedCar = new TextArea();

    //To display registered cars only and check if a car is registered
    private Label idCheckerLabel = new Label("ID");
    private TextField idField2 = new TextField();
    private Button checkRegisBtn = new Button("Check if Registered");

    private TextArea displayRegisCar = new TextArea();

    //To register a car using their unique car plate number
    private Label regisNameLabel = new Label("Name");
    private TextField regisNameField = new TextField();
    private Label regisIdLabel = new Label("ID");
    private TextField regisIdField = new TextField();
    private Button regisBtn = new Button("Register Car");
    private TextArea regisTextArea = new TextArea();

    //methods
    public static void main(String[] args) {
        launch(args);
    }

    //initialise the stage
    @Override
    public void start(Stage primaryStage) {

        noOfSpaces = getNumberOfSpaces(); //Call private method
        // initialise parked car list
        list = new parkedCarList(noOfSpaces);
        parkedCarFileHandler.readRecord(list); // initialize the list here

        // create HBox
        // To add registered cars
        HBox carDetails = new HBox(10);
        HBox parkedCarBtn = new HBox(10);

        // To display registered cars
        HBox displayRegisDetails = new HBox(10);
        HBox displayRegisteredBtn = new HBox(10);

        // To register a car
        HBox registerDetails = new HBox(10);
        HBox registerBtn = new HBox(10);

        // add components to HBox
        carDetails.getChildren().addAll(nameAddLabel, nameAddField, idAddLabel, idField);
        parkedCarBtn.getChildren().addAll(addBtn, removeBtn, displayBtn, saveAndQuitBtn);

        displayRegisDetails.getChildren().addAll(idCheckerLabel, idField2);
        displayRegisteredBtn.getChildren().addAll(checkRegisBtn);

        registerDetails.getChildren().addAll(regisNameLabel, regisNameField, regisIdLabel, regisIdField);
        registerBtn.getChildren().addAll(regisBtn);

        //create VBox
        VBox root = new VBox(10);
        // add components to VBox
        root.getChildren().addAll(headingLabel, carDetails, parkedCarBtn, displayParkedCar, displayRegisDetails, displayRegisteredBtn, displayRegisCar, registerDetails, registerBtn, regisTextArea);
        // add VBox to the scene
        Scene scene = new Scene(root);

        // set font for heading
        Font font = new Font("Montserrat", 40);
        headingLabel.setFont(font);

        // set alignment for HBoxes
        carDetails.setAlignment(Pos.CENTER);
        parkedCarBtn.setAlignment(Pos.CENTER);
        displayRegisDetails.setAlignment(Pos.CENTER);
        displayRegisteredBtn.setAlignment(Pos.CENTER);
        registerDetails.setAlignment(Pos.CENTER);
        registerBtn.setAlignment(Pos.CENTER);

        // set minimum and maximum width of components
        nameAddField.setMaxWidth(50);
        regisNameField.setMaxWidth(50);

        carDetails.setMinWidth(WIDTH);
        carDetails.setMaxWidth(WIDTH);

        parkedCarBtn.setMinWidth(WIDTH);
        parkedCarBtn.setMaxWidth(WIDTH);

        displayRegisDetails.setMinWidth(WIDTH);
        displayRegisDetails.setMaxWidth(WIDTH);

        displayRegisteredBtn.setMinWidth(WIDTH);
        displayRegisteredBtn.setMaxWidth(WIDTH);

        registerDetails.setMinWidth(WIDTH);
        registerDetails.setMaxWidth(WIDTH);

        registerBtn.setMinWidth(WIDTH);
        registerBtn.setMaxWidth(WIDTH);

        root.setMinSize(WIDTH, HEIGHT);
        root.setMaxSize(WIDTH, HEIGHT);

        displayParkedCar.setMaxSize(WIDTH - 100, HEIGHT / 5);
        displayRegisCar.setMaxSize(WIDTH - 100, HEIGHT / 5);
        regisTextArea.setMaxSize(WIDTH - 100, HEIGHT/ 5);
        displayParkedCar.setEditable(false);
        displayRegisCar.setEditable(false);
        regisTextArea.setEditable(false);

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        // customise the visual components
        // customise the VBox border and background
        BorderStroke style = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2));
        root.setBorder(new Border(style));
        root.setBackground(Background.EMPTY);

        // customise buttons
        addBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
        displayBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
        removeBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
        saveAndQuitBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
        checkRegisBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
        regisBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));

        // call private methods for button event handlers using lambda expression
        addBtn.setOnAction(e -> addHandler());
        removeBtn.setOnAction(e -> removeHandler());
        displayBtn.setOnAction(e -> displayHandler());
        saveAndQuitBtn.setOnAction(e -> saveAndQuitHandler());
        checkRegisBtn.setOnAction(e -> checkRegisteredHandler());
        regisBtn.setOnAction(e -> registerHandler());

        // configure the stage and make the stage visible
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Parking Application"); // Title of the GUI App
        primaryStage.show();
    }

    // this method will return the number of car spaces
    private int getNumberOfSpaces() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("How many car spaces?");
        dialog.setTitle("Car Park Spaces Information Request");

        String response = dialog.showAndWait().get();
        return Integer.parseInt(response);
    }

    private void addHandler() {
        String nameEntered = nameAddField.getText();
        String idEntered = idField.getText();

        parkedCar carObj = list.search(Integer.parseInt(idEntered));

        // check for errors
        if(nameEntered.length() == 0 || idEntered.length() == 0) {
            displayParkedCar.setText("Name and ID must be entered must be entered");
        } else if(list.getTotal() == noOfSpaces){
            displayParkedCar.setText("The car park is currently full, please come back again later when there is space");
        } else { // okay to add the object
            if(carObj == null) {
                displayParkedCar.setText("The car you are  adding isn't registered, please register below");
            } else {
                parkedCar p = new parkedCar(nameEntered, Integer.parseInt(idEntered), true);
                list.addParkedCar(p);
                nameAddField.setText("");
                idField.setText("");
                displayParkedCar.setText("Car for " + nameEntered + " has been successfully parked to the parking system");
            }
        }
    }
    // Button will allow user to enter ID to remove the object holding the variable for ID value
    private void removeHandler(){
        String idEntered = idField.getText();
        int idParsed = Integer.parseInt(idEntered);
        // check for errors
        if(idEntered.length() == 0) {
            displayParkedCar.setText("ID must be entered");
        } else if(list.getTotal() == noOfSpaces) {
            displayParkedCar.setText("The Parking space is full");
        } else if (list.search(idParsed) == null) {
            displayParkedCar.setText("The car doesn't exist in the car park");
        } else { // ok to remove object
            list.leaveCarParked(idParsed);
            displayParkedCar.setText("Your car has successfully left the car park");
        }
    }
    // Button will display all cars parked in the car park
    private void displayHandler(){
        if(list.isEmpty()) { // no objects to display as class collection is empty
            displayParkedCar.setText("The car park is empty");
        } else { // display the objects stored in the parkedCarList class collection
            displayParkedCar.setText("NAME: " + "\t\t\t" + "ID: " + "\n");
            for(int i = 1; i <= list.getTotal(); i++) {
                displayParkedCar.appendText(list.getParkedCar(i).getName() + "\t\t\t" + list.getParkedCar(i).getID() + "\n");
            }
        }
    }
    private void saveAndQuitHandler(){
        parkedCarFileHandler.saveRecords(noOfSpaces, list);
        Platform.exit();
    }
    private void checkRegisteredHandler(){
        String idEntered = idField2.getText();
        int ID = Integer.parseInt(idEntered);
        parkedCar carObj = list.search(ID);

        if(idEntered.length() == 0) {
            displayRegisCar.setText("ID must be entered must be entered");
        } else if(carObj == null) {
            displayRegisCar.setText("Car is not registered, please register below");
        } else {
            displayRegisCar.setText("Car is Registered, thank you for checking " + carObj.getName());
        }
    }

    private void registerHandler(){
        String name = regisNameField.getText();
        int id = Integer.parseInt(regisIdField.getText());

        if(name.length() == 0) {
            regisTextArea.setText("Please enter valid details into the fields above");
        } else {
            parkedCar carObj = new parkedCar(name, id, true);
            list.addParkedCar(carObj);
            regisTextArea.setText("Car has been successfully registered to the system");
        }
    }

}
