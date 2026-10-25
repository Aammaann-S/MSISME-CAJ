package Lab3;

public class Car {

    private String name;
    private String model;
    private String yearOfPurchase;
    private String color;
    private double price;

    // Constructor
    public Car(String name, String model, String yearOfPurchase,
               String color, double price) {
        this.name = name;
        this.model = model;
        this.yearOfPurchase = yearOfPurchase;
        this.color = color;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getYearOfPurchase() {
        return yearOfPurchase;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfPurchase(String yearOfPurchase) {
        this.yearOfPurchase = yearOfPurchase;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override the inherited toString() method
    @Override
    public String toString() {
        return "Car Name: " + name
                + "\nModel: " + model
                + "\nYear of Purchase: " + yearOfPurchase
                + "\nColor: " + color
                + "\nPrice: INR " + String.format("%.2f", price);
    }
}
