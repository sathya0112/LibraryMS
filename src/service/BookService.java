package service;

import model.Book;
import repository.BookRepository;
import strategy.SearchStrategy;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {

        for (Book existingBook : bookRepository.getAllBooks()) {

            if (existingBook.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                System.out.println("ISBN already exists.");
                return;
            }
        }

        bookRepository.addBook(book);
    }

    public void removeBook(String isbn) {
        bookRepository.removeBook(isbn);
    }

    public List<Book> searchBooks(SearchStrategy strategy, String keyword) {
        return strategy.search(bookRepository.getAllBooks(), keyword);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public boolean updateBook(String isbn, String title, String author, int year) {
        return bookRepository.updateBook(isbn, title, author, year);
    }

    public Book findBookByISBN(String isbn) {
        return bookRepository.findBookByISBN(isbn);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new java.util.ArrayList<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Book> getBorrowedBooks() {
        List<Book> borrowedBooks = new java.util.ArrayList<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (!book.isAvailable()) {
                borrowedBooks.add(book);
            }
        }

        return borrowedBooks;
    }

    
}