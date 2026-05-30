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
}