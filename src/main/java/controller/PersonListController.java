package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Child;
import core.jess.JessEngine;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import jess.JessException;
import model.Person;
import repository.PersonRepository;

import static utils.ResultDTOBuilder.convertResultToDTO;

public class PersonListController extends Child implements Initializable {

    public static final String PATH = "view/PersonList.fxml";
    @FXML
    private ListView<Person> personListView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label eyeColorLabel;

    @FXML
    private Label hairColorLabel;

    @FXML
    private Label nationality;

    @FXML
    private Button processButton;

    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = this.root.showPersonEditDialog(tempPerson);
        if (okClicked) {
            PersonRepository.getInstance().getPersons().add(tempPerson);
        }
    }

    @FXML
    public void handleEditPerson() {
        int selectedIndex = personListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            this.root.showPersonEditDialog(personListView.getItems().get(selectedIndex));
        }
    }

    @FXML
    public void handleDeletePerson() {
        int selectedIndex = personListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personListView.getItems().remove(selectedIndex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Person> persons = PersonRepository.getInstance().getPersons();

        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName("test");
            persons.add(p);
        }
        personListView.setItems(persons);

        personListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    private void showPersonDetails(Person person) {
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

    @FXML
    private void process() throws JessException, IOException {
        JessEngine engine = JessEngine.getInstance();
        var resultList = engine.checkPersons();
        this.root.showResult(convertResultToDTO(resultList));
    }
}
