
package Lab5;

//Q18: Test_Pizza
public class Test_Pizza {
    public static void main(String[] args) {

        System.out.println(" > TEST CIRCLE PIZZA < ");

        Circle circle = new Circle(3.0);
        Pizza pizza1 = new Pizza(250.0, circle);

        System.out.println("Shape: " + pizza1.getShape());
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Price: " + pizza1.getPrice());


        System.out.println("\n > TEST RECTANGLE PIZZA < ");

        Rectangle rectangle = new Rectangle(4.0, 5.0);
        Pizza pizza2 = new Pizza(300.0, rectangle);

        System.out.println("Shape: " + pizza2.getShape());
        System.out.println("Height: " + rectangle.getHeight());
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Price: " + pizza2.getPrice());


        System.out.println("\n > TEST POLYMORPHISM < ");

        IShape shape1 = new Circle(2.0);
        IShape shape2 = new Rectangle(3.0, 6.0);

        System.out.println("Circle area: " + shape1.getArea());
        System.out.println("Rectangle area: " + shape2.getArea());


        System.out.println("\n > TEST PIZZA OBJECTS < ");

        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}
