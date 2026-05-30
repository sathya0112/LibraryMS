package strategy;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchByAuthor implements SearchStrategy {

    @Override
    public List<Book> search(List<Book> books, String keyword) {

        List<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(keyword)) {
                results.add(book);
            }
        }

        return results;
    }
}