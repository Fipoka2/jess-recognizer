package model;

import java.util.List;

public class ResultDTO {
    private List<SingleResultDTO> singles;
    private List<CoupleResultDTO> couples;

    public ResultDTO(List<SingleResultDTO> singles, List<CoupleResultDTO> couples) {
        this.singles = singles;
        this.couples = couples;
    }

    public List<SingleResultDTO> getSingles() {
        return singles;
    }

    public void setSingles(List<SingleResultDTO> singles) {
        this.singles = singles;
    }

    public List<CoupleResultDTO> getCouples() {
        return couples;
    }

    public void setCouples(List<CoupleResultDTO> couples) {
        this.couples = couples;
    }
}
