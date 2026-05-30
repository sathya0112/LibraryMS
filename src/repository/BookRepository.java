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

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean updateBook(String isbn, String newTitle, String newAuthor, int newYear) {
        Book book = findBookByISBN(isbn);
        if (book == null) {
            return false;
        }
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setPublicationYear(newYear);
        return true;
    }
}