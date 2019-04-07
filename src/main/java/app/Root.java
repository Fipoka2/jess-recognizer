package app;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import controller.PersonEditController;
import controller.PersonListController;
import controller.ResultListController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;
import model.ResultDTO;

public class Root extends Application {

    private static final String MAIN_VIEW_PATH;
    // при
    private static final int BASE_WIDTH = 800;
    private static final int BASE_HEIGHT = 400;
    private static final String OS;

    static {
        OS = System.getProperty("os.name");
        MAIN_VIEW_PATH = convertPath("view\\main.fxml");
    }

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
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }

    private void showPersons() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Root.class.getClassLoader().getResource(convertPath(PersonListController.PATH)));
        AnchorPane personOverview = loader.load();
        rootLayout.setCenter(personOverview);

        PersonListController personListController = loader.getController();
        personListController.setRoot(this);
    }

    public static void main(String[] args) {
        launch();
    }

    public static String convertPath(String path) {
        if (OS.equals("Linux")) {
            return path.replace('\\', '/');
        } else {
            return path.replace('/', '\\');
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public boolean showPersonEditDialog(Person person) {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Root.class.getClassLoader().getResource(convertPath(PersonEditController.PATH)));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            PersonEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showResult(ResultDTO results) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Root.class.getClassLoader().getResource(convertPath(ResultListController.PATH)));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Результаты");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ResultListController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.buildPanels(results);
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}