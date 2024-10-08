package splytapp.splytapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/main-view.fxml")));
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        //scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/tailwind.css")).toExternalForm());

        stage.setTitle("Splyt!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}