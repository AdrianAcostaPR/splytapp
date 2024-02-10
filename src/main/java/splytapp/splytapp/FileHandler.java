package splytapp.splytapp;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileHandler {
    public static File readUploadFile(Stage stage) {
        //Open Dialog
        FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(stage);
    }
}
