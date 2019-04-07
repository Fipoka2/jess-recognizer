package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Child;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.CoupleResultDTO;

public class CoupleResultController  extends Child implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Label messageLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label eyeColorLabel;

    @FXML
    private Label hairColorLabel;

    @FXML
    private Label nationality;

    @FXML
    private Label nameLabel2;

    @FXML
    private Label eyeColorLabel2;

    @FXML
    private Label hairColorLabel2;

    @FXML
    private Label nationality2;

    public void setData(CoupleResultDTO dto) {
        if (dto.getMessage() != null) {
            messageLabel.setText(dto.getMessage());
        } else {
            messageLabel.setText("");
        }
        var person1 = dto.getPerson();
        var person2 = dto.getPerson2();
        if (person1 != null) {
            nameLabel.setText(person1.getName());
            eyeColorLabel.setText(person1.getEyeColor());
            hairColorLabel.setText(person1.getHairColor());
            nationality.setText(person1.getNationality());
        } else {
            nameLabel.setText("");
            eyeColorLabel.setText("");
            hairColorLabel.setText("");
            nationality.setText("");
        }
        if (person1 != null) {
            nameLabel2.setText(person2.getName());
            eyeColorLabel2.setText(person2.getEyeColor());
            hairColorLabel2.setText(person2.getHairColor());
            nationality2.setText(person2.getNationality());
        } else {
            nameLabel2.setText("");
            eyeColorLabel2.setText("");
            hairColorLabel2.setText("");
            nationality2.setText("");
        }
    }
}
