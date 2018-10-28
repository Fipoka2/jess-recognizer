package model;

public class JessResult {
    private int personId;
    private String message;

    public JessResult(int personId, String message) {
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
