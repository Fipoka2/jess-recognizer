package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Child;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Person;

public class ResultController extends Child implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Label eyeColorLabel;

    @FXML
    private Label hairColorLabel;

    @FXML
    private Label nationality;

    public void setPerson(Person person) {
        if (person != null) {
            nameLabel.setText(person.getName());
            eyeColorLabel.setText(person.getEyeColor());
            hairColorLabel.setText(person.getHairColor());
            nationality.setText(person.getNationality());
        } else {
            nameLabel.setText("");
            eyeColorLabel.setText("");
            hairColorLabel.setText("");
            nationality.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
