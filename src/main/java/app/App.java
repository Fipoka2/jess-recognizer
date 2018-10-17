package app;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    private static final String MAIN_VIEW_PATH = "view\\main.fxml";
    private static final int BASE_WIDTH = 800;
    private static final int BASE_HEIGHT = 400;

    private Stage primaryStage;
    private BorderPane rootLayout;


    @Override
    public void start(Stage primaryStage) throws IOException {
        URL mainView = getClass().getClassLoader().getResource(MAIN_VIEW_PATH);
        this.rootLayout = FXMLLoader.load(Objects.requireNonNull(mainView));
        primaryStage.setTitle("Jess recognizer");
        primaryStage.setScene(new Scene(rootLayout, BASE_WIDTH, BASE_HEIGHT));
        primaryStage.show();
        this.primaryStage = primaryStage;
        showPersons();
        primaryStage.setOnCloseRequest(event ->  {
            Platform.exit();
            System.exit(0);
        });
    }

    public void showPersons() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getClassLoader().getResource("view\\PersonList.fxml"));
        AnchorPane personOverview = loader.load();
        rootLayout.setCenter(personOverview);
    }

    public static void main(String[] args) {
        launch();
    }

}