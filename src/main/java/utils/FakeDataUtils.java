package utils;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

public class FakeDataUtils {

    public static ObservableList<Person> getPersons() {
        var list = new ArrayList<Person>() {{
            add(new Person("Olivier Francis Renaud ", "Синий", "Рыжий", "Француз"));
            add(new Person("Путинцев Виктор Валерьянович", "Янтарный", "Шатен", "Русский"));
            add(new Person("Schmitz Inge Alexa", "Карий", "Блондин", "Немец"));
            add(new Person("Bengtsson Lennart Jakob", "Зелёный", "Рыжий", "Швед"));
            add(new Person("Сакис Толис", "Синий", "Шатен", "Грек"));
            add(new Person("Яблоновская Алла Артемовна", "Синий", "Блондин", "Русский"));
            add(new Person("María Fajardo García de Estefa", "Оливковый", "Красный", "Испанец"));
            add(new Person("Carli Alessandro Giustino ", "Жёлтый", "Шатен", "Итальянец"));
            add(new Person("Villadsen Marie Susanne", "Зелёный", "Седой", "Датчанин"));
            add(new Person("Arnold Emery Thomas", "Янтарный", "Брюнет", "Англичанин"));
        }};
        return FXCollections.observableArrayList(list);
    }
}
