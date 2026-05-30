package repository;

import model.Patron;

import java.util.ArrayList;
import java.util.List;

public class PatronRepository {

    private List<Patron> patrons = new ArrayList<>();

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public List<Patron> getAllPatrons() {
        return patrons;
    }

    public Patron findPatronById(int id) {
        for (Patron patron : patrons) {
            if (patron.getPatronId() == id) {
                return patron;
            }
        }
        return null;
    }
}