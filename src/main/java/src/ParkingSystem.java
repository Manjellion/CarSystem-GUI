package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class ParkingSystem extends Application{

    private Label headingLabel = new Label("Parking Application");

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Parking System");
        Button priBtn = new Button();
        priBtn.setText("Click here");
        priBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello World");
            }
        });



        StackPane layout = new StackPane();
        layout.getChildren().add(priBtn);

        primaryStage.setScene(new Scene(layout, 400, 400));
        primaryStage.show();
    }
}
