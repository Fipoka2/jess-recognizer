package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Person;
import repository.RepositoryManager;

public class PersonListController implements Initializable {

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

    private ObservableList<Person> list;

    public void handleNewPerson() {}

    public void handleEditPerson() {}

    public void handleDeletePerson() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        var tempList = RepositoryManager.getInstance().getRepository().getPersons();
        for (int i = 0; i< 10; i++) {
            Person p = new Person();
            p.setName("test");
            tempList.add(p);
        }
        list = FXCollections.observableArrayList(tempList);
        personListView.setItems(list);

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
}
