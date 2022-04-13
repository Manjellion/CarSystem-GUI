package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class ParkingSystem extends Application{

    //attributes
    private int  noOfSpaces;
    private parkedCarList list;

    //javaFX components as visual components declared as attributes for the class
    //To Add, remove, display and save & quit event handling
    private Label headingLabel = new Label("Car Park Application");
    private Label nameAddLabel = new Label("Name");
    private TextField nameAddField = new TextField();
    private Label idAddLabel = new Label("ID");
    private TextField idField = new TextField();
    private Button addBtn = new Button("Add to car park");
    private Button removeBtn = new Button("Remove from car park");
    private Button displayBtn = new Button("Display Parked Cars");
    private Button saveAndQuitBtn = new Button("Save and Quit");
    private TextArea displayParkedCar = new TextArea();

    //To display registered cars only
    private Label idCheckerLabel = new Label("ID");
    private TextField idField2 = new TextField();
    private Button displayRegisBtn = new Button("Display Registered Cars");
    private TextArea displayRegisCar = new TextArea();

    //To register a car using their unique car plate number
    private Label regisNameLabel = new Label("Name");
    private TextField regisNameField = new TextField();
    private Label regisIdLabel = new Label("ID");
    private TextField regisIdField = new TextField();
    private Button regisBtn = new Button("Register Car");

    //methods
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Parking Application"); // Title of the GUI App

        noOfSpaces = getNumberOfSpaces(); //Call private method
        // initialise parked car list
        list = new parkedCarList(noOfSpaces);
        parkedCarFileHandler.readRecord(list); // initialize the list here

        // create HBox
        // To add registered cars
        HBox carDetails = new HBox(20);
        HBox parkedCarBtn = new HBox(20);

        // To display registered cars
        HBox displayRegisDetails = new HBox(20);
        HBox displayRegisteredBtn = new HBox(20);

        // To register a car
        HBox registerDetails = new HBox(20);
        HBox registerBtn = new HBox(20);

        // add components to HBox
        carDetails.getChildren().addAll(nameAddLabel, nameAddField, idAddLabel, idField);
        parkedCarBtn.getChildren().addAll(addBtn, removeBtn, displayBtn, saveAndQuitBtn);

        displayRegisDetails.getChildren().addAll(idCheckerLabel, idField2);
        displayRegisteredBtn.getChildren().addAll(displayRegisBtn);

        registerDetails.getChildren().addAll(regisNameLabel, regisNameField, regisIdLabel, regisIdField);
        registerBtn.getChildren().addAll(regisBtn);

        //create VBox
        VBox root = new VBox(20);
        // add components to VBox
        root.getChildren().addAll(headingLabel, carDetails, parkedCarBtn, displayParkedCar, displayRegisDetails, displayRegisteredBtn, displayRegisCar, registerDetails, registerBtn);
        // add VBox to the scene
        Scene scene = new Scene(root, Color.ALICEBLUE);
    }

    // this method will return the number of car spaces
    private int getNumberOfSpaces() {
        System.out.println("Enter number of Car Park Spaces: ");
        int num = EasyScanner.nextInt();
        return num;
    }

}
