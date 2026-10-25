package Lab3;

public class Book {
    int bookId;
    String author;
    String title;
    double price;
    String publisher;
    int stock;

    // Constructor
    public Book(int bookId, String author, String title, double price, String publisher, int stock) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.price = price;
        this.publisher = publisher;
        this.stock = stock;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override // overriding a base function(?)
    public String toString(){
        return "ID: " + getBookId()+
                "\nTitle: " + getTitle()+
                ",\nAuthor: " + getAuthor()+
                ",\nPublisher: " + getPublisher()+
                ",\nPrice: " + getPrice()+
                ",\nStock: " + getStock();
    }

    public boolean searchBookByTitleAuthor(String title, String author) {
        return this.title.equalsIgnoreCase(title)
                && this.author.equalsIgnoreCase(author);
    }

}
