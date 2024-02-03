package splytapp.splytapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Scene scene = new Scene(root, 300, 275);

        primaryStage.setTitle("Splyt");
        primaryStage.setScene(scene);
        primaryStage.show();

        boolean useYamlController = shouldUseYamlController();
       // String fxmlFile = useYamlController ? "yaml-view.fxml" : "hello-view.fxml";
        //FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));


//        if (useYamlController) {
//            YamlController yamlController = loader.getController();
//
//        } else {
//            JsonController jsonController = loader.getController();
//        }

       //Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Main Controller Example");
//        primaryStage.show();
    }

    private boolean shouldUseYamlController() {
        // Add your condition here to determine whether to use YamlController or JsonController
        File yamlFile = new File("/Users/adrianacosta/Desktop/yamlFileTest.yml");
        return yamlFile.exists();
    }


}