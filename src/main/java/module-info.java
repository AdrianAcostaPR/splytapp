module splytapp.splytapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens splytapp.splytapp to javafx.fxml;
    exports splytapp.splytapp;
}