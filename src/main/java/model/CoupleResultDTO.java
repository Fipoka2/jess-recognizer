package model;

public class CoupleResultDTO extends SingleResultDTO {
    private Person person2;

    public CoupleResultDTO(String message, Person person1, Person person2) {
        super(message, person1);
        this.person2 = person2;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }
}
