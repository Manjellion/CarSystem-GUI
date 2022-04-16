module com.example.carsystemgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.testng;

    opens src to javafx.fxml;
    exports src;
}