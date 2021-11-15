package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForagerRepository;
import learn.foraging.models.Forager;
import learn.foraging.models.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ForagerService {

    private final ForagerRepository repository;

    public ForagerService(ForagerRepository repository) {
        this.repository = repository;
    }

    public List<Forager> findByState(String stateAbbr) {
        return repository.findByState(stateAbbr);
    }

    public List<Forager> findByLastName(String prefix) {
        return repository.findAll().stream()
                .filter(i -> i.getLastName().startsWith(prefix))
                .collect(Collectors.toList());
    }

    public Result<Forager> add(Forager forager) throws DataException {

        Result<Forager> result = new Result<>();
        if (forager == null) {
            result.addErrorMessage("Forager must not be null.");
            return result;
        }

        if (forager.getFirstName() == null || forager.getFirstName().isBlank()) {
            result.addErrorMessage("First name is required.");
        }
        if (forager.getLastName() == null || forager.getLastName().isBlank()) {
            result.addErrorMessage("Last name is required.");
        }

        if (forager.getState() == null || forager.getState().isBlank()) {
            result.addErrorMessage("State is required.");
        }  else if (repository.findAll().stream()
                    .anyMatch(i -> i.getFirstName().equalsIgnoreCase(forager.getFirstName())) &&
                    repository.findAll().stream()
                    .anyMatch(i -> i.getLastName().equalsIgnoreCase(forager.getLastName())) &&
                    repository.findAll().stream()
                        .anyMatch(i -> i.getState().equalsIgnoreCase(forager.getState())))
        result.addErrorMessage(String.format("Forager '%s %s %s' is a duplicate.", forager.getFirstName(), forager.getLastName(), forager.getState()));

        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.add((forager)));

        return result;
    }
}
