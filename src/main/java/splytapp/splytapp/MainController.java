package splytapp.splytapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;


public class MainController {
    final String ENTER = "\n\r";
    final String TAB = "\t";
    final String SPACE = " ";
    Stage stage = new Stage();

    @FXML
    private Label chooseFileText; //To resolve alert on main-view.fxml.

    @FXML
    private Label welcomeText;

    @FXML //These RadioButtons are being redirected to the hello-vew.fxml
    private RadioButton yamlRadioBtn;
    @FXML
    private RadioButton jsonRadioBtn;
    @FXML
    private TextArea outputText;

    @FXML
    private void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();
        yamlRadioBtn.setToggleGroup(toggleGroup);
        jsonRadioBtn.setToggleGroup(toggleGroup);
    }

    @FXML
    private Label onClickText;
    @FXML
    protected void onUploadButtonClick() {
        //Validates which option is chosen by the user.
        if(!yamlRadioBtn.isSelected() && !jsonRadioBtn.isSelected()) {
            onClickText.setText("Please choose an option before proceeding!");
        } else if (yamlRadioBtn.isSelected()) {
            //The JsonController is executed because we need to turn it into a json file.
            String jsonOutput = JsonController.jsonGeneratorMethod(ENTER, TAB, SPACE, stage);
            outputText.setText(jsonOutput);
            onClickText.setText("You chose YAML!");
        } else { //Otherwise, the other button available is the JSON button.
            //The YamlController is executed because we need to turn it into a yaml file.
            String yamlOutput = YamlController.yamlGeneratorMethod(ENTER, TAB, SPACE, stage);
            outputText.setText(yamlOutput);
            onClickText.setText("You chose JSON!");
        }
    }
}