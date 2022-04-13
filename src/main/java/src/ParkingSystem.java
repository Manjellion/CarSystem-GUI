package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class ParkingSystem extends Application{

    //attributes
    private int  noOfSpaces;
    private parkedCarList list;

    private Label headingLabel = new Label("Parking Application");
    private Label nameLabel = new Label("Name: ");
    private TextField nameField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    //methods
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Parking Application"); // Title of the GUI App
        
        StackPane layout = new StackPane();
        layout.getChildren().addAll(headingLabel, nameLabel, nameField);
        primaryStage.setScene(new Scene(layout, 400, 400));
        primaryStage.show();
    }
}
