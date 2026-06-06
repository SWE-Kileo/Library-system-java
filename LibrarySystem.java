import java.util.HashMap;
import java.util.Scanner;

/**
 * LibrarySystem - A basic library management program.
 * Allows users to add, borrow, and return books.
 *
 * @author Programming 1 Assignment
 */
public class LibrarySystem {

    // Stores book titles mapped to their details (author + quantity)
    private static HashMap<String, String[]> library = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("========================================");
        System.out.println("       Welcome to the Library System    ");
        System.out.println("========================================");

        while (running) {
            printMenu();

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            // Validate that input is a number
            if (!input.matches("[1-4]")) {
                System.out.println("\n[ERROR] Invalid choice. Please enter 1, 2, 3, or 4.\n");
                continue;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    borrowBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    System.out.println("\nThank you for using the Library System. Goodbye!");
                    running = false;
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Prints the main menu options.
     */
    private static void printMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
    }

    /**
     * Handles adding a new book or updating the quantity of an existing book.
     *
     * @param scanner the Scanner object for user input
     */
    private static void addBook(Scanner scanner) {
        System.out.println("\n--- Add Books ---");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        // Validate title is not empty
        if (title.isEmpty()) {
            System.out.println("[ERROR] Book title cannot be empty.");
            return;
        }

        // Use lowercase key for case-insensitive matching
        String key = title.toLowerCase();

        // If the book already exists, only ask for quantity (author is already stored)
        if (library.containsKey(key)) {
            System.out.print("Enter quantity to add: ");
            String qtyInput = scanner.nextLine().trim();

            int quantity = parsePositiveInt(qtyInput);
            if (quantity == -1) {
                System.out.println("[ERROR] Quantity must be a positive whole number.");
                return;
            }

            // Update existing quantity
            String[] bookData = library.get(key);
            int currentQty = Integer.parseInt(bookData[1]);
            bookData[1] = String.valueOf(currentQty + quantity);
            library.put(key, bookData);

            System.out.println("[SUCCESS] Updated \"" + title + "\" — New quantity: " + bookData[1]);

        } else {
            // New book — ask for author and quantity
            System.out.print("Enter author name: ");
            String author = scanner.nextLine().trim();

            if (author.isEmpty()) {
                System.out.println("[ERROR] Author name cannot be empty.");
                return;
            }

            System.out.print("Enter quantity: ");
            String qtyInput = scanner.nextLine().trim();

            int quantity = parsePositiveInt(qtyInput);
            if (quantity == -1) {
                System.out.println("[ERROR] Quantity must be a positive whole number.");
                return;
            }

            // Store: bookData[0] = author, bookData[1] = quantity
            String[] bookData = {author, String.valueOf(quantity)};
            library.put(key, bookData);

            System.out.println("[SUCCESS] Added \"" + title + "\" by " + author
                    + " — Quantity: " + quantity);
        }
    }

    /**
     * Handles borrowing a book from the library.
     *
     * @param scanner the Scanner object for user input
     */
    private static void borrowBook(Scanner scanner) {
        System.out.println("\n--- Borrow Books ---");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("[ERROR] Book title cannot be empty.");
            return;
        }

        String key = title.toLowerCase();

        // Check if book exists in the library
        if (!library.containsKey(key)) {
            System.out.println("[ERROR] \"" + title + "\" is not found in the library.");
            return;
        }

        System.out.print("Enter number of books to borrow: ");
        String qtyInput = scanner.nextLine().trim();

        int quantity = parsePositiveInt(qtyInput);
        if (quantity == -1) {
            System.out.println("[ERROR] Quantity must be a positive whole number.");
            return;
        }

        String[] bookData = library.get(key);
        int available = Integer.parseInt(bookData[1]);

        // Check if enough copies are available
        if (quantity > available) {
            System.out.println("[ERROR] Not enough copies available. Requested: "
                    + quantity + " | Available: " + available);
        } else {
            bookData[1] = String.valueOf(available - quantity);
            library.put(key, bookData);
            System.out.println("[SUCCESS] You borrowed " + quantity + " copy/copies of \""
                    + title + "\". Remaining: " + bookData[1]);
        }
    }

    /**
     * Handles returning a book to the library.
     *
     * @param scanner the Scanner object for user input
     */
    private static void returnBook(Scanner scanner) {
        System.out.println("\n--- Return Books ---");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("[ERROR] Book title cannot be empty.");
            return;
        }

        String key = title.toLowerCase();

        // Book must exist in the library system to be returned
        if (!library.containsKey(key)) {
            System.out.println("[ERROR] \"" + title
                    + "\" does not belong to this library system. Cannot process return.");
            return;
        }

        System.out.print("Enter number of books to return: ");
        String qtyInput = scanner.nextLine().trim();

        int quantity = parsePositiveInt(qtyInput);
        if (quantity == -1) {
            System.out.println("[ERROR] Quantity must be a positive whole number.");
            return;
        }

        String[] bookData = library.get(key);
        int currentQty = Integer.parseInt(bookData[1]);
        bookData[1] = String.valueOf(currentQty + quantity);
        library.put(key, bookData);

        System.out.println("[SUCCESS] Returned " + quantity + " copy/copies of \""
                + title + "\". New quantity: " + bookData[1]);
    }

    /**
     * Parses and validates a positive integer from a string.
     *
     * @param input the string to parse
     * @return the positive integer value, or -1 if invalid
     */
    private static int parsePositiveInt(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) return -1;
            return value;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}