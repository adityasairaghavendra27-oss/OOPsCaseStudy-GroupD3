import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Car[] cars = new Car[3];

        cars[0] = new Car();
        cars[0].carID = "C1";
        cars[0].brand = "Toyota";
        cars[0].model = "Corolla";
        cars[0].pricePerDay = 50;
        cars[0].availabilityStatus = true;

        cars[1] = new Car();
        cars[1].carID = "C2";
        cars[1].brand = "Honda";
        cars[1].model = "Civic";
        cars[1].pricePerDay = 60;
        cars[1].availabilityStatus = true;

        cars[2] = new Car();
        cars[2].carID = "C3";
        cars[2].brand = "Ford";
        cars[2].model = "Focus";
        cars[2].pricePerDay = 55;
        cars[2].availabilityStatus = true;

        Customer customer = new Customer();
        customer.id = "U1";
        customer.name = "Guest";

        Booking booking = new Booking();
        Payment payment = new Payment();
        RentalRecord record = new RentalRecord();

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n--- Car Rental System ---");
            System.out.println("1. View Cars");
            System.out.println("2. Book Car");
            System.out.println("3. Make Payment");
            System.out.println("4. View Rental Record");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("Cars List:");

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i] != null) {

                        if (cars[i].availabilityStatus == true) {
                            System.out.println((i + 1) + ". " + cars[i].brand + " " + cars[i].model);
                        }

                    }

                }

            }

            else if (choice == 2) {

                System.out.println("Select car number:");

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i] != null) {

                        if (cars[i].availabilityStatus == true) {
                            System.out.println((i + 1) + ". " + cars[i].brand + " " + cars[i].model);
                        }

                    }

                }

                int num = sc.nextInt();

                if (num >= 1 && num <= cars.length) {

                    if (cars[num - 1] != null) {

                        if (cars[num - 1].availabilityStatus == true) {

                            booking.bookingID = "B" + num;
                            booking.carID = cars[num - 1].carID;
                            booking.customerID = customer.id;

                            booking.createBooking();

                            cars[num - 1].availabilityStatus = false;

                            System.out.println("Booked: " + cars[num - 1].brand + " " + cars[num - 1].model);

                        } else {
                            System.out.println("Car already booked");
                        }

                    }

                } else {
                    System.out.println("Wrong number");
                }

            }

            else if (choice == 3) {

                System.out.print("Enter number of days: ");
                int days = sc.nextInt();

                double total = 0;

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i] != null) {

                        if (cars[i].availabilityStatus == false) {
                            total = cars[i].pricePerDay * days;
                        }

                    }

                }

                payment.bookingID = booking.bookingID;
                payment.amount = total;
                payment.process();

                record.recordID = "R1";
                record.bookingID = booking.bookingID;
                record.totalCost = total;

                System.out.println("Payment done. Total: " + total);

            }

            else if (choice == 4) {

                System.out.println(record.viewRecord());
                System.out.println("Total Cost: " + record.totalCost);

            }

            else if (choice == 5) {
                System.out.println("Exit");
            }

            else {
                System.out.println("Invalid choice");
            }

        }
    }
}