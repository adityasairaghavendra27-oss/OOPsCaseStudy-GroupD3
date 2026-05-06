import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Car[] cars = new Car[3];

        cars[0] = new Car();
        cars[0].carID = "C1";
        cars[0].brand = "Toyota";
        cars[0].model = "Corolla";
        cars[0].pricePerDay = 5000;
        cars[0].updateAvailability(true);

        cars[1] = new Car();
        cars[1].carID = "C2";
        cars[1].brand = "Honda";
        cars[1].model = "Civic";
        cars[1].pricePerDay = 6000;
        cars[1].updateAvailability(true);

        cars[2] = new Car();
        cars[2].carID = "C3";
        cars[2].brand = "Ford";
        cars[2].model = "Focus";
        cars[2].pricePerDay = 5500;
        cars[2].updateAvailability(true);

        Customer customer = new Customer();

        System.out.println("=================================");
        System.out.println("ENTER CUSTOMER DETAILS");
        System.out.println("=================================");

        System.out.print("Enter Customer ID: ");
        customer.id = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customer.name = sc.nextLine();

        System.out.print("Enter Email: ");
        customer.email = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        customer.phoneNumber = sc.nextLine();

        System.out.print("Enter License Number: ");
        customer.licenseNumber = sc.nextLine();

        Admin admin = new Admin();

        admin.id = "A1";
        admin.name = "System Admin";
        admin.email = "admin@gmail.com";
        admin.adminID = "AD101";

        admin.addCar(cars[0]);
        admin.manageUsers();

        System.out.println("=================================");
        System.out.println("SYSTEM INITIALIZED");
        System.out.println("=================================");
        System.out.println("Admin ID    : " + admin.adminID);
        System.out.println("Admin Name  : " + admin.name);
        System.out.println("Cars Loaded : " + cars.length);
        System.out.println("=================================");

        Booking booking = new Booking();
        Payment payment = new Payment();
        RentalRecord record = new RentalRecord();

        int choice = 0;
        int days = 0;

        while (choice != 7) {

            System.out.println("=================================");
            System.out.println("       CAR RENTAL SYSTEM");
            System.out.println("=================================");
            System.out.println("1. View Available Cars");
            System.out.println("2. Book a Car");
            System.out.println("3. Make Payment");
            System.out.println("4. View Rental Record");
            System.out.println("5. Modify Booking");
            System.out.println("6. Cancel Booking");
            System.out.println("7. Exit");
            System.out.println("=================================");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                customer.searchCar();

                System.out.println("------ AVAILABLE CARS ------");

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i].checkAvailability()) {

                        System.out.println("Car Number : " + (i + 1));
                        System.out.println("Car ID     : " + cars[i].carID);
                        System.out.println("Car Name   : "
                                + cars[i].displayCarDetails());
                        System.out.println("Price/Day  : ₹"
                                + cars[i].pricePerDay);
                        System.out.println("----------------------------");
                    }
                }
            }

            else if (choice == 2) {

                System.out.println("------ BOOK A CAR ------");

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i].checkAvailability()) {

                        System.out.println((i + 1) + ". "
                                + cars[i].displayCarDetails());
                    }
                }

                System.out.print("Select Car Number: ");
                int num = sc.nextInt();

                if (num >= 1 && num <= cars.length) {

                    if (cars[num - 1].checkAvailability()) {

                        sc.nextLine();

                        booking.bookingID = "B" + num;
                        booking.customerID = customer.id;
                        booking.carID = cars[num - 1].carID;

                        System.out.print("Enter Booking Date: ");
                        booking.bookingDate = sc.nextLine();

                        System.out.print("Enter Return Date: ");
                        booking.returnDate = sc.nextLine();

                        booking.bookingStatus = "Booked";

                        booking.createBooking();

                        customer.rentCar(booking);

                        cars[num - 1].updateAvailability(false);

                        System.out.println("Car Booked Successfully");
                        System.out.println("Booking ID : "
                                + booking.bookingID);
                        System.out.println("Customer   : "
                                + customer.name);
                        System.out.println("Car        : "
                                + cars[num - 1].displayCarDetails());

                    } else {

                        System.out.println("Car Already Booked");
                    }

                } else {

                    System.out.println("Invalid Car Number");
                }
            }

            else if (choice == 3) {

                System.out.println("------ PAYMENT SECTION ------");

                System.out.print("Enter Number of Days: ");
                days = sc.nextInt();

                double total = 0;

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i].carID.equals(booking.carID)) {

                        total = cars[i].pricePerDay * days;

                        payment.paymentID = "P" + i;
                        payment.bookingID = booking.bookingID;
                        payment.amount = total;

                        sc.nextLine();

                        System.out.print("Enter Payment Date: ");
                        payment.paymentDate = sc.nextLine();

                        payment.paymentStatus = "Paid";

                        payment.process();

                        System.out.println("Payment Successful");
                        System.out.println("Payment ID   : "
                                + payment.paymentID);
                        System.out.println("Booking ID   : "
                                + payment.bookingID);
                        System.out.println("Amount Paid  : ₹"
                                + payment.amount);

                        System.out.println(payment.generateInvoice());
                    }
                }
            }

            else if (choice == 4) {

                System.out.println("------ RENTAL RECORD ------");

                record.recordID = "R1";
                record.bookingID = booking.bookingID;
                record.rentalStartDate = booking.bookingDate;
                record.rentalEndDate = booking.returnDate;

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i].carID.equals(booking.carID)) {

                        record.totalCost =
                                record.calculateCost(
                                        cars[i].pricePerDay, days);
                    }
                }

                record.generateRecord();

                System.out.println("Record ID       : "
                        + record.recordID);
                System.out.println("Booking ID      : "
                        + record.bookingID);
                System.out.println("Rental Start    : "
                        + record.rentalStartDate);
                System.out.println("Rental End      : "
                        + record.rentalEndDate);
                System.out.println("Total Cost      : ₹"
                        + record.totalCost);

                System.out.println(record.viewRecord());

                admin.viewRentalRecords();
            }

            else if (choice == 5) {

                sc.nextLine();

                System.out.print("Enter New Booking Date: ");
                String newDate = sc.nextLine();

                booking.updateBookingDate(newDate);

                System.out.println("Booking Updated Successfully");
                System.out.println("New Booking Date : "
                        + booking.bookingDate);
            }

            else if (choice == 6) {

                booking.cancelBooking();

                customer.returnCar(booking);

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i].carID.equals(booking.carID)) {

                        cars[i].updateAvailability(true);
                    }
                }

                admin.deleteCar("C3");

                System.out.println("Booking Cancelled Successfully");
            }

            else if (choice == 7) {

                System.out.println("Thank You For Using The System");
            }

            else {

                System.out.println("Invalid Choice");
            }
        }
    }
}