package splytapp.splytapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.File;


public class MainController extends Application {

    final String ENTER = "\n\r";
    final String TAB = "\t";
    final String SPACE = " ";
    //JsonController.jsonGeneratorMethod(ENTER, TAB, SPACE);
    //Needs to be created / copied from old project
    //YamlController.yamlGeneratorMethod(ENTER, TAB, SPACE);
    @FXML
    private Label welcomeText;

    Label appTile = new Label("Welcome to Splyt!");
    TilePane tilePane = new TilePane();

    @FXML
    private RadioButton yamlRadioBtn;
    @FXML
    private RadioButton jsonRadioBtn;
    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

//    if (useYamlController) {
//            YamlController yamlController = loader.getController();
//
//    } else {
//        JsonController jsonController = loader.getController();
//    }

    private boolean shouldUseYamlController() {
        // Add your condition here to determine whether to use YamlController or JsonController
        File yamlFile = new File("/Users/adrianacosta/Desktop/yamlFileTest.yml");
        return yamlFile.exists();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}