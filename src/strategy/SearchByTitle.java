package strategy;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchByTitle implements SearchStrategy {

    @Override
    public List<Book> search(List<Book> books, String keyword) {

        List<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword)) {
                results.add(book);
            }
        }

        return results;
    }
}