package model;

public class JessSingleResult {
    private int personId;
    private String message;

    public JessSingleResult(String message, int personId) {
        this.personId = personId;
        this.message = message;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
