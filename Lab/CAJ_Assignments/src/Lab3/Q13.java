package Lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q13 {
    static List<Book> books = new ArrayList<Book>();
    static int option;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n>>> Book Store <<<");
        System.out.print("Number of Books:");
        int bno = sc.nextInt();
        for (int i = 0; i < bno; i++) {
            System.out.println("\nBook " + (i + 1) + " Details:");
            System.out.print("Book Id:");
            int bookId = sc.nextInt();
            System.out.print("Author:");
            String author = sc.next();
            System.out.print("Title:");
            String title = sc.next();
            System.out.print("Publisher:");
            String publisher = sc.next();
            System.out.print("Price:");
            double price = sc.nextDouble();
            System.out.print("Stock:");
            int stock = sc.nextInt();
            System.out.println("Adding Book " + (i + 1) + "'s Data...");
            books.add(new Book(bookId, author, title, price, publisher, stock));

            System.out.println("Book " + (i + 1) + " Added.");
        }
        do {
            System.out.println("\n MENU Options>>>");
            System.out.println("1. Display Books");
            System.out.println("2. Search/Purchase Book By");
            System.out.println("3. Add Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");

            System.out.print("\nEnter your option: ");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.println("\nAll Book Details:");
                    for (Book b : books) {
                        System.out.println(b);
                        System.out.println("---------------------");
                    }
                    break;

                case 2:
                    System.out.println("\nSearching Book >>>");
                    System.out.print("\nGive Book Title:");
                    String searchTitle = sc.next();

                    System.out.print("Give Author Name:");
                    String searchAuthor = sc.next();

                    boolean found = false;
                    for(Book b:books){
                        //    if(b.searchBookByTitleAuthor(searchTitle,searchAuthor)){
                        //        System.out.println(b);
                        //        break;
                        //    }
                        if (b.getTitle().equalsIgnoreCase(searchTitle)
                                && b.getAuthor().equalsIgnoreCase(searchAuthor)) {

                            System.out.println("\nBook Found!");
                            System.out.println("---------------------");
                            System.out.println(b);
                            System.out.println("---------------------");

                            System.out.println("Enter Number of Copies Required:");
                            int requiredCopies = sc.nextInt();

                            if (requiredCopies <= 0) {
                                System.out.println("Enter a positive number of copies.");
                            }
                            else if (requiredCopies <= b.getStock()) {
                                double totalCost = requiredCopies * b.getPrice();
                                System.out.println("Total Cost: " + totalCost);
                            }
                            else {
                                System.out.println("Required copies not in stock");
                            }

                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nAdd Book >>>");
                    System.out.print("Book Id:");
                    int bookId = sc.nextInt();

                    System.out.print("Author:");
                    String author = sc.next();
                    System.out.print("Title:");
                    String title = sc.next();
                    System.out.print("Price:");
                    double price = sc.nextDouble();
                    System.out.print("Publisher:");
                    String publisher = sc.next();
                    System.out.print("Stock:");
                    int stock = sc.nextInt();
                    System.out.println("Adding New Book's Data...");
                    books.add(new Book(bookId, author, title, price, publisher, stock));
                    System.out.println("New Book Added.");
                    break;

                case 4:
                    System.out.println("\nDelete Book >>>");
                    System.out.println("Give Book Id:");
                    int deleteId = sc.nextInt();
                    boolean deleted = false;
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getBookId() == deleteId) {
                            System.out.println("Book Found:");
                            System.out.println(books.get(i));
                            books.remove(i);
                            System.out.println("Book Removed Successfully.");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Book with Id " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid Option!");
            }

        } while (option != 5);

    }
}
