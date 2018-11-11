package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import model.CoupleResultDTO;
import model.JessCoupleResult;
import model.JessSingleResult;
import model.Person;
import model.Result;
import model.ResultDTO;
import model.SingleResultDTO;
import repository.PersonRepository;

public class ResultDTOBuilder {

    private ResultDTOBuilder() {
    }

    public static SingleResultDTO convertJessToDTO(JessSingleResult jessSingleResult) throws NoSuchElementException {
        Optional<Person> value = PersonRepository.getInstance().getPersons()
                .stream()
                .filter(person -> person.getId() == jessSingleResult.getPersonId())
                .findFirst();
        return new SingleResultDTO(jessSingleResult.getMessage(), value.get());
    }

    public static List<SingleResultDTO> convertJessToDTOs(List<JessSingleResult> jessSingleResults) {
        var resultDTOList = new ArrayList<SingleResultDTO>();
        for (var obj : jessSingleResults) {
            resultDTOList.add(convertJessToDTO(obj));
        }
        return resultDTOList;
    }

    public static CoupleResultDTO convertJessToDTO(JessCoupleResult jessResult) throws NoSuchElementException {
        Optional<Person> value = PersonRepository.getInstance().getPersons()
                .stream()
                .filter(person -> person.getId() == jessResult.getPerson1Id())
                .findFirst();
        Optional<Person> secondValue = PersonRepository.getInstance().getPersons()
                .stream()
                .filter(person -> person.getId() == jessResult.getPerson2Id())
                .findFirst();
        return new CoupleResultDTO(jessResult.getMessage(), value.get(), secondValue.get());
    }

    public static List<CoupleResultDTO> convertJessCoupleToDTOs(List<JessCoupleResult> jessResults) {
        var resultDTOList = new ArrayList<CoupleResultDTO>();
        for (var obj : jessResults) {
            resultDTOList.add(convertJessToDTO(obj));
        }
        return resultDTOList;
    }

    public static ResultDTO convertResultToDTO(Result result) {
        return new ResultDTO(convertJessToDTOs(result.getPersonResults()),convertJessCoupleToDTOs(result.getPersonCoupleResults()));
    }

}
