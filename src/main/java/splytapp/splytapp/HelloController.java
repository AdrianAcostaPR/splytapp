package splytapp.splytapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label welcomeText2;

    @FXML
    private Label JSONfile;

    @FXML
    private Label YAMLfile;


//    @FXML
//    JSONfile.setText("JSON file");
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        welcomeText2.setText("This is a new app");
    }
}