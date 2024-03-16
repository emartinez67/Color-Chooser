module com.example.colorchooser {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.colorchooser to javafx.fxml;
    exports com.example.colorchooser;
}