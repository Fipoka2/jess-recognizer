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
        this.name = name;
    }

    public Person(String name, String eyeColor, String hairColor, String nationality) {
        this.id = this.hashCode();
        this.name = name;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
