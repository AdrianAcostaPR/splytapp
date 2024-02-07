package splytapp.splytapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.File;


public class MainController {

    final String ENTER = "\n\r";
    final String TAB = "\t";
    final String SPACE = " ";

    Stage stage = new Stage();

    @FXML
    private Label chooseFileText; //To resolve alert on hello-view.fxml.

    //JsonController.jsonGeneratorMethod(ENTER, TAB, SPACE);
    //Needs to be created / copied from old project
    //YamlController.yamlGeneratorMethod(ENTER, TAB, SPACE);
    @FXML
    private Label welcomeText;

    @FXML //These RadioButtons are being redirected to the hello-vew.fxlm
    private RadioButton yamlRadioBtn;
    @FXML
    private RadioButton jsonRadioBtn;


    @FXML
    private void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();
        yamlRadioBtn.setToggleGroup(toggleGroup);
        jsonRadioBtn.setToggleGroup(toggleGroup);
    }

    @FXML
    private Label onClickText;
    @FXML
    protected void onHelloButtonClick() {
        //Validates which option is chosen by the user.
        if(!yamlRadioBtn.isSelected() && !jsonRadioBtn.isSelected()) {
            onClickText.setText("Please choose an option before proceeding!");
        } else if (yamlRadioBtn.isSelected()) {
            onClickText.setText("You chose YAML!");
        } else { //Otherwise, the other button available is the JSON button.

            JsonController.jsonGeneratorMethod("ENTER", "TAB", "SPACE", stage);
            onClickText.setText("You chose JSON!");
        }
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
}