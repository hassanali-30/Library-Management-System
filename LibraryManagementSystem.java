public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isIssued=" + isIssued +
                '}';
    }
}
public class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LibraryManagementSystem {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private HashMap<String, String> issuedBooks;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        issuedBooks = new HashMap<>();
    }

    public void addBook(String id, String title, String author) {
        books.add(new Book(id, title, author));
    }

    public void registerUser(String userId, String name) {
        users.add(new User(userId, name));
    }

    public void issueBook(String bookId, String userId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && !book.isIssued()) {
                book.setIssued(true);
                issuedBooks.put(bookId, userId);
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String bookId) {
        if (issuedBooks.containsKey(bookId)) {
            for (Book book : books) {
                if (book.getId().equals(bookId)) {
                    book.setIssued(false);
                    issuedBooks.remove(bookId);
                    System.out.println("Book returned successfully.");
                    return;
                }
            }
        } else {
            System.out.println("Book not issued.");
        }
    }

    public void viewBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void viewUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void viewIssuedBooks() {
        for (String bookId : issuedBooks.keySet()) {
            System.out.println("Book ID: " + bookId + ", Issued to User ID: " + issuedBooks.get(bookId));
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Users");
            System.out.println("7. View Issued Books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book id: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    system.addBook(bookId, title, author);
                    break;
                case 2:
                    System.out.print("Enter user id: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    system.registerUser(userId, name);
                    break;
                case 3:
                    System.out.print("Enter book id to issue: ");
                    String issueBookId = scanner.nextLine();
                    System.out.print("Enter user id: ");
                    String issueUserId = scanner.nextLine();
                    system.issueBook(issueBookId, issueUserId);
                    break;
                case 4:
                    System.out.print("Enter book id to return: ");
                    String returnBookId = scanner.nextLine();
                    system.returnBook(returnBookId);
                    break;
                case 5:
                    system.viewBooks();
                    break;
                case 6:
                    system.viewUsers();
                    break;
                case 7:
                    system.viewIssuedBooks();
                    break;
                case 8:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
