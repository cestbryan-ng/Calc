package javafxtest.calcfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class MainPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("MainPageUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 215, 305);
        URL styleres = this.getClass().getResource("MainPageUI.css");
        scene.getStylesheets().add(styleres.toExternalForm());
        stage.setTitle("Calc");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}