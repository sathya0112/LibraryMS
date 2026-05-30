package util;

import model.Book;

import java.util.List;

public class TablePrinter {

    public static void printBooks(List<Book> books) {

        System.out.printf(
                "%-30s %-25s %-12s %-8s %-10s%n",
                "TITLE",
                "AUTHOR",
                "ISBN",
                "YEAR",
                "AVAILABLE"
        );

        System.out.println(
                "------------------------------------------------------------------------------------------"
        );

        for (Book book : books) {

            System.out.printf(
                    "%-30s %-25s %-12s %-8d %-10s%n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getIsbn(),
                    book.getPublicationYear(),
                    book.isAvailable()
            );
        }
    }
}