package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Child;
import app.Root;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ResultDTO;

import static app.Root.convertPath;

public class ResultListController extends Child implements Initializable {

    public static final String PATH = "view/ResultList.fxml";

    private Stage dialogStage;

    @FXML
    private Accordion accordion;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void buildPanels(ResultDTO results) throws IOException {

        for (var res : results.getSingles()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Root.class.getClassLoader().getResource(convertPath("view/Result.fxml")));
            AnchorPane newPanelContent = (AnchorPane) loader.load();

            ResultController controller = loader.getController();
            controller.setPerson(res.getPerson());
            TitledPane pane = new TitledPane(res.getPerson().getName() + " | " + res.getMessage(), newPanelContent);
            System.out.println(accordion);
            accordion.getPanes().add(pane);
        }

        for (var res : results.getCouples()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Root.class.getClassLoader().getResource(convertPath("view/CoupleResult.fxml")));
            AnchorPane newPanelContent = (AnchorPane) loader.load();

            CoupleResultController controller = loader.getController();
            controller.setData(res);
            TitledPane pane = new TitledPane(res.getMessage(), newPanelContent);
            System.out.println(accordion);
            accordion.getPanes().add(pane);
        }

    }
}
