package splytapp.splytapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class HelloController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        boolean useYamlController = shouldUseYamlController();
        String fxmlFile = useYamlController ? "yaml-view.fxml" : "hello-view.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        if (useYamlController) {
            YamlController yamlController = loader.getController();

        } else {
            JsonController jsonController = loader.getController();
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Controller Example");
        primaryStage.show();
    }

    private boolean shouldUseYamlController() {
        // Add your condition here to determine whether to use YamlController or JsonController
        File yamlFile = new File("/Users/adrianacosta/Desktop/yamlFileTest.yml");
        return yamlFile.exists();
    }


}