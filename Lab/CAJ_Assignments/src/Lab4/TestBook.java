package Lab4;

// Q15: TestBook
public class TestBook {
    public static void main(String[] args) {

        Author author1 = new Author("R.K. Narayan", "rk@gmail.com", 'M');
        Author author2 = new Author("Narayan", "ak@gmail.com", 'M');
        Author author3 = new Author("Murthi", "sk@gmail.com", 'F');

        Book book1 = new Book("Malgudi Days", author1, 450.00);
        Book book2 = new Book("The Guide", author2, 500.00, 10);
        Book book3= new Book("Masters Book",author3,300,15);

        System.out.println("Book 1:");
        System.out.println(book1);
        System.out.println("\nBook 2:");
        System.out.println(book2);
        System.out.println("\nBook 3:");
        System.out.println(book3);

        assert(book1.getAuthor().getName().equals("R.K. Narayan"));
        assert(book2.getAuthor().getName().equals("Narayan"));
        assert(book3.getAuthor().getName().equals("Murthi"));

        System.out.println("\nGetters:");
        System.out.println("Name: " + book2.getName());
        System.out.println("Author: " + book2.getAuthor());
        System.out.println("Price: " + book2.getPrice());
        System.out.println("Quantity: " + book2.getQty());

        System.out.println("\nSetters:");
        book2.setPrice(400.0);
        book2.setQty(8);

        System.out.println(book2);
    }
}
