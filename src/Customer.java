class Customer extends User {
    String phoneNumber;
    String licenseNumber;

    void searchCar() {
        System.out.println("Searching cars");
    }

    void rentCar(Booking booking) {
        System.out.println("Renting car with booking " + booking.bookingID);
    }

    void returnCar(Booking booking) {
        System.out.println("Returning car " + booking.carID);
    }
}