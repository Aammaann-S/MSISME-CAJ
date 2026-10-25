
package Lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q14 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Brezza", "VX", "02/10/2017", "White", 650500.00));
        cars.add(new Car("Venue", "SX", "20/9/2018", "White", 750000.00));
        cars.add(new Car("Ciaz", "VX", "15/12/2015", "White", 600000.00));
        cars.add(new Car("Ecosport", "LX", "21/6/2018", "Blue", 500500.00));
        cars.add(new Car("Nexon", "SX", "15/10/2019", "Green", 850500.00));
        int option;

        do {
            System.out.println("\n>>> Used Car Shop <<<");
            System.out.println("1. Display Available Cars");
            System.out.println("2. Book a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your option: ");

            option = sc.nextInt();

            switch (option) {

                case 1:
                    if (cars.isEmpty()) {
                        System.out.println("No cars available.");
                    } else {
                        System.out.println("\nAvailable Cars:");

                        for (int i = 0; i < cars.size(); i++) {
                            System.out.println("\nCar Number: " + (i + 1));
                            System.out.println(cars.get(i));
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 2:
                    if (cars.isEmpty()) {
                        System.out.println("No cars available for booking.");
                        break;
                    }

                    System.out.println("\nSelect a car to book:");

                    for (int i = 0; i < cars.size(); i++) {
                        System.out.println((i + 1) + ". "
                                + cars.get(i).getName()
                                + " - INR "
                                + String.format("%.2f",
                                cars.get(i).getPrice()));
                    }

                    System.out.print("Enter car number: ");
                    int carNumber = sc.nextInt();

                    if (carNumber >= 1 && carNumber <= cars.size()) {
                        Car bookedCar = cars.remove(carNumber - 1);
                        System.out.println("\nCar booked successfully!");
                        System.out.println("Booked Car Details:");
                        System.out.println(bookedCar);

                        System.out.println(
                                "Car removed from available inventory.");

                    } else {
                        System.out.println("Invalid car number.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 3);

        sc.close();
    }
}
