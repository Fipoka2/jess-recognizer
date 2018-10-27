package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Child;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;

public class PersonEditController extends Child implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private TextField eyeColorField;

    @FXML
    private TextField hairColorField;

    @FXML
    private TextField nationalityField;

    @FXML
    private Button confirmButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    public void setPerson(Person person) {
        this.person = person;

        nameField.setText(person.getName());
        eyeColorField.setText(person.getEyeColor());
        hairColorField.setText(person.getHairColor());
        nationalityField.setText(person.getNationality());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (true) {
            person.setName(nameField.getText());
            person.setEyeColor(eyeColorField.getText());
            person.setHairColor(hairColorField.getText());
            person.setNationality(nationalityField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
