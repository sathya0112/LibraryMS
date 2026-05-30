import model.Book;
import model.Patron;
import repository.BookRepository;
import repository.LoanRepository;
import repository.PatronRepository;
import service.BookService;
import service.LendingService;
import service.PatronService;
import strategy.SearchByAuthor;
import strategy.SearchByISBN;
import strategy.SearchByTitle;
// import strategy.SearchByYear;
import util.TablePrinter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BookRepository bookRepository = new BookRepository();
        PatronRepository patronRepository = new PatronRepository();
        LoanRepository loanRepository = new LoanRepository();

        BookService bookService = new BookService(bookRepository);
        PatronService patronService = new PatronService(patronRepository);
        LendingService lendingService = new LendingService(loanRepository);

        boolean running = true;

        while (running) {

            System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Books");
            System.out.println("4. Remove Book");
            System.out.println("5. Search Book By Title");
            System.out.println("6. Search Book By Author");
            System.out.println("7. Search Book By ISBN");
            System.out.println("8. Add Patron");
            System.out.println("9. Update Patron");
            System.out.println("10. Checkout Book");
            System.out.println("11. Return Book");
            System.out.println("12. View Patron Borrowed Books");
            System.out.println("13. View Borrowing History");
            System.out.println("14. View Available Books");
            System.out.println("15. View Borrowed Books");
            System.out.println("16. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter Publication Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    Book newBook = new Book(title, author, isbn, year);
                    bookService.addBook(newBook);

                    System.out.println("Book added successfully.");
                    break;

                case 2:

                    System.out.println("===== ALL BOOKS =====");
                    TablePrinter.printBooks(bookService.getAllBooks());
                    break;

                case 3:
                    System.out.print("Enter ISBN: ");
                    String updateISBN = scanner.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter New Author: ");
                    String newAuthor = scanner.nextLine();

                    System.out.print("Enter New Year: ");
                    int newYear = scanner.nextInt();
                    scanner.nextLine();

                    boolean updated = bookService.updateBook(updateISBN, newTitle, newAuthor, newYear);
                    System.out.println(updated ? "Book updated successfully." : "Book not found.");
                    break;

                case 4:

                    System.out.print("Enter ISBN to remove: ");
                    String removeISBN = scanner.nextLine();
                    bookService.removeBook(removeISBN);
                    System.out.println("Book removed successfully.");
                    break;


                case 5:

                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    TablePrinter.printBooks(bookService.searchBooks(new SearchByTitle(), searchTitle));
                    break;

                case 6:

                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    TablePrinter.printBooks(bookService.searchBooks(new SearchByAuthor(), searchAuthor));
                    break;

                case 7:

                    System.out.print("Enter ISBN to search: ");
                    String searchISBN = scanner.nextLine();
                    TablePrinter.printBooks(bookService.searchBooks(new SearchByISBN(), searchISBN));
                    break;

                case 8:

                    System.out.print("Enter Patron ID: ");
                    int patronId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Patron Name: ");
                    String patronName = scanner.nextLine();

                    Patron patron = new Patron(patronId, patronName);
                    patronService.addPatron(patron);

                    System.out.println("Patron added successfully.");
                    break;

                case 9:
                    System.out.print("Enter Patron ID: ");
                    int updatePatronId = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter New Name: ");
                    String updatedName = scanner.nextLine();
                    
                    boolean patronUpdated = patronService.updatePatron(updatePatronId, updatedName);
                    System.out.println(patronUpdated ? "Patron updated successfully." : "Patron not found.");
                    break;

                case 10:

                    System.out.print("Enter Patron ID: ");
                    int checkoutPatronId = scanner.nextInt();
                    scanner.nextLine();

                    Patron checkoutPatron = patronService.getPatronById(checkoutPatronId);

                    if (checkoutPatron == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.print("Enter ISBN of book to checkout: ");
                    String checkoutISBN = scanner.nextLine();

                    Book checkoutBook = null;

                    for (Book book : bookService.getAllBooks()) {
                        if (book.getIsbn().equals(checkoutISBN)) {
                            checkoutBook = book;
                            break;
                        }
                    }

                    if (checkoutBook == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    lendingService.checkoutBook(checkoutBook, checkoutPatron);
                    break;

                case 11:

                    System.out.print("Enter Patron ID: ");
                    int returnPatronId = scanner.nextInt();
                    scanner.nextLine();

                    Patron returnPatron = patronService.getPatronById(returnPatronId);

                    if (returnPatron == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.print("Enter ISBN of book to return: ");
                    String returnISBN = scanner.nextLine();

                    Book returnBook = null;

                    for (Book book : bookService.getAllBooks()) {
                        if (book.getIsbn().equals(returnISBN)) {
                            returnBook = book;
                            break;
                        }
                    }

                    if (returnBook == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    lendingService.returnBook(returnBook, returnPatron);
                    break;

                case 12:

                    System.out.print("Enter Patron ID: ");
                    int borrowedPatronId = scanner.nextInt();
                    scanner.nextLine();

                    Patron borrowedPatron = patronService.getPatronById(borrowedPatronId);

                    if (borrowedPatron == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.println("Borrowed Books:");

                    for (Book book : borrowedPatron.getBorrowedBooks()) {
                        System.out.println(book);
                    }

                    break;

                case 13:
                    System.out.print("Enter Patron ID: ");

                    int historyId = scanner.nextInt();
                    scanner.nextLine();
                    Patron historyPatron = patronService.getPatronById(historyId);
                    
                    if (historyPatron == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.println("Borrowing History");

                    for (Book book : historyPatron.getBorrowingHistory()) {

                        System.out.println(book);
                    }

                    break;

                case 14:
                    TablePrinter.printBooks(bookService.getAvailableBooks());
                    break;

                case 15:

                    TablePrinter.printBooks(bookService.getBorrowedBooks());
                    break;

                case 16:

                    running = false;
                    System.out.println("Exiting Library Management System...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}