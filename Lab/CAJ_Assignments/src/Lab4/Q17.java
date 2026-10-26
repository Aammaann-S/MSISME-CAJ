package Lab4;

public class Q17 {
    public static void main(String[] args) {

        System.out.println(" > TEST SHAPE < ");
        Shape s1 = new Shape();
        Shape s2 = new Shape("Blue", false);

        System.out.println(s1);
        System.out.println(s2);

        s1.setColor("Red");
        s1.setFilled(false);

        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());
        System.out.println(s1);


        System.out.println("\n > TEST CIRCLE < ");
        Circle c1 = new Circle();
        Circle c2 = new Circle(5.0);
        Circle c3 = new Circle(3.0, "Blue", false);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Area: " + c2.getArea());
        System.out.println("Perimeter: " + c2.getPerimeter());

        c2.setRadius(7.0);
        System.out.println("Updated radius: " + c2.getRadius());


        System.out.println("\n > TEST RECTANGLE < ");
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4.0, 6.0);
        Rectangle r3 = new Rectangle(3.0, 5.0, "Yellow", true);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        System.out.println("Width: " + r2.getWidth());
        System.out.println("Length: " + r2.getLength());
        System.out.println("Area: " + r2.getArea());
        System.out.println("Perimeter: " + r2.getPerimeter());

        r2.setWidth(8.0);
        r2.setLength(10.0);

        System.out.println("Updated rectangle: " + r2);


        System.out.println("\n > TEST SQUARE < ");
        Square sq1 = new Square();
        Square sq2 = new Square(5.0);
        Square sq3 = new Square(4.0, "Purple", false);

        System.out.println(sq1);
        System.out.println(sq2);
        System.out.println(sq3);

        System.out.println("Side: " + sq2.getSide());
        System.out.println("Area: " + sq2.getArea());
        System.out.println("Perimeter: " + sq2.getPerimeter());

        System.out.println("\nTesting setWidth(8):");
        sq2.setWidth(8.0);
        System.out.println("Width: " + sq2.getWidth());
        System.out.println("Length: " + sq2.getLength());

        System.out.println("\nTesting setLength(3):");
        sq2.setLength(3.0);
        System.out.println("Width: " + sq2.getWidth());
        System.out.println("Length: " + sq2.getLength());

        System.out.println(sq2);


        System.out.println("\n > TEST POLYMORPHISM < ");
        Shape shape = new Circle(2.0, "Green", true);
        System.out.println(shape);
    }
}

