package model;

public class JessCoupleResult {

    private String message;
    private int person2Id;
    private int person1Id;

    public JessCoupleResult(String message, int person1Id, int person2Id) {
        this.person1Id = person1Id;
        this.message = message;
        this.person2Id = person2Id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPerson1Id() {
        return person1Id;
    }

    public void setPerson1Id(int personId) {
        this.person1Id = personId;
    }

    public int getPerson2Id() {
        return person2Id;
    }

    public void setPerson2Id(int person2Id) {
        this.person2Id = person2Id;
    }
}
