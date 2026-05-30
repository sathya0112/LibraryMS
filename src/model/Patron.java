package model;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private int patronId;
    private String name;
    private List<Book> borrowedBooks;
    private List<Book> borrowingHistory;

    public Patron(int patronId, String name) {
        this.patronId = patronId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.borrowingHistory = new ArrayList<>();
    }

    public int getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        borrowingHistory.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "patronId=" + patronId +
                ", name='" + name + '\'' +
                '}';
    }
}