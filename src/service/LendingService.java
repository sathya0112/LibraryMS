package service;

import model.Book;
import model.Loan;
import model.Patron;
import repository.LoanRepository;

import java.time.LocalDate;
import java.util.logging.Logger;

public class LendingService {

    private LoanRepository loanRepository;
    private static final Logger logger = Logger.getLogger(LendingService.class.getName());

    public LendingService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void checkoutBook(Book book, Patron patron) {

        if (!book.isAvailable()) {
            logger.warning("Book is not available.");
            return;
        }

        book.setAvailable(false);
        patron.borrowBook(book);

        Loan loan = new Loan(book, patron);
        loanRepository.addLoan(loan);

        logger.info("Book checked out successfully.");
    }

    public void returnBook(Book book, Patron patron) {

        book.setAvailable(true);
        patron.returnBook(book);

        for (Loan loan : loanRepository.getAllLoans()) {
            if (loan.getBook().equals(book) && loan.getReturnDate() == null) {
                loan.setReturnDate(LocalDate.now());
            }
        }

        logger.info("Book returned successfully.");
    }
}