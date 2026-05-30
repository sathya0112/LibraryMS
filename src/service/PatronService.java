package service;

import model.Patron;
import repository.PatronRepository;

public class PatronService {

    private PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public void addPatron(Patron patron) {
        patronRepository.addPatron(patron);
    }

    public Patron getPatronById(int id) {
        return patronRepository.findPatronById(id);
    }
}