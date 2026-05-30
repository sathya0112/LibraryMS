package repository;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);    
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}