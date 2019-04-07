package model;

public class Person {
    private Integer id;
    private String name;
    private String eyeColor;
    private String hairColor;
    private String nationality;

    public Person() {
        this.id = this.hashCode();
    }

    public Person(String name) {
        this.id = this.hashCode();
        this.name = name.toLowerCase();
    }

    public Person(String name, String eyeColor, String hairColor, String nationality) {
        this.id = this.hashCode();
        this.name = name.toLowerCase();
        this.eyeColor = eyeColor.toLowerCase();
        this.hairColor = hairColor.toLowerCase();
        this.nationality = nationality.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor.toLowerCase();
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor.toLowerCase();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality.toLowerCase();
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
