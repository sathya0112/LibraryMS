package service;

import model.Patron;
import repository.PatronRepository;

public class PatronService {

    private PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public void addPatron(Patron patron) {
        if (patronRepository.patronExists(patron.getPatronId())) {
            System.out.println("Patron ID already exists.");
            return;
        }
        patronRepository.addPatron(patron);
    }

    public Patron getPatronById(int id) {
        return patronRepository.findPatronById(id);
    }

    public boolean updatePatron(int id, String newName) {
        return patronRepository.updatePatron(id, newName);
    }
}