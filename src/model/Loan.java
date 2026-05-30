package model;

import java.time.LocalDate;

public class Loan {

    private Book book;
    private Patron patron;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
        this.borrowDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}