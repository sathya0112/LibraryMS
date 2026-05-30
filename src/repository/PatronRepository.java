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

    public boolean updatePatron(int id, String newName) {
        Patron patron = findPatronById(id);
        if (patron == null) {
            return false;
        }
        patron.setName(newName);
        return true;
    }

    public boolean patronExists(int id) {
        return findPatronById(id) != null;
    }
}