package model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<JessSingleResult> personResults;
    private List<JessCoupleResult> personCoupleResults;

    public Result(List<JessSingleResult> personResults, List<JessCoupleResult> personCoupleResults) {
        this.personResults = personResults;
        this.personCoupleResults = personCoupleResults;
    }

    public Result() {
        this.personResults = new ArrayList<>();
        this.personCoupleResults = new ArrayList<>();
    }

    public List<JessSingleResult> getPersonResults() {
        return personResults;
    }

    public void setPersonResults(List<JessSingleResult> personResults) {
        this.personResults = personResults;
    }

    public List<JessCoupleResult> getPersonCoupleResults() {
        return personCoupleResults;
    }

    public void setPersonCoupleResults(List<JessCoupleResult> personCoupleResults) {
        this.personCoupleResults = personCoupleResults;
    }
}
