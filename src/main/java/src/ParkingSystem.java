package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    private Label nameAddLabel = new Label("Name");
    private TextField nameAddField = new TextField();
    private Label idAddLabel = new Label("ID");
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

    //initialise the stage
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
        displayRegisteredBtn.getChildren().addAll(checkRegisBtn, displayRegisBtn);

        registerDetails.getChildren().addAll(regisNameLabel, regisNameField, regisIdLabel, regisIdField);
        registerBtn.getChildren().addAll(regisBtn);

        //create VBox
        VBox root = new VBox(20);
        // add components to VBox
        root.getChildren().addAll(headingLabel, carDetails, parkedCarBtn, displayParkedCar, displayRegisDetails, displayRegisteredBtn, displayRegisCar, registerDetails, registerBtn);
        // add VBox to the scene
        Scene scene = new Scene(root, Color.ALICEBLUE);

        // set font for heading
        Font font = new Font("Calibri", 40);
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

        displayParkedCar.setMaxSize(WIDTH - 80, HEIGHT / 5);
        displayRegisCar.setMaxSize(WIDTH - 80, HEIGHT / 5);

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        // customise the visual components

        // customise the VBox border and background
        BorderStroke style = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2));
        root.setBorder(new Border(style));
        root.setBackground(Background.EMPTY);

        // customise buttons
        addBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        displayBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        removeBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        saveAndQuitBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        checkRegisBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        displayRegisBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        // call private methods for button event handlers using lambda expression
        addBtn.setOnAction(e -> addHandler());
        removeBtn.setOnAction(e -> removeHandler());
        displayBtn.setOnAction(e -> displayHandler());
        saveAndQuitBtn.setOnAction(e -> saveAndQuitHandler());
        checkRegisBtn.setOnAction(e -> checkRegisteredHandler());
        displayRegisBtn.setOnAction(e -> displayRegisHandler());
        regisBtn.setOnAction(e -> registerHandler());

        // configure the stage and make the stage visible
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // this method will return the number of car spaces
    private int getNumberOfSpaces() {
        System.out.println("Enter number of Car Park Spaces: ");
        int num = EasyScanner.nextInt();
        return num;
    }

    

}
