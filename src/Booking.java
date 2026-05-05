class Booking {
    String bookingID;
    String customerID;
    String carID;
    String bookingDate;
    String returnDate;
    String bookingStatus;

    void createBooking() {
        bookingStatus = "Created";
        System.out.println("Booking created");
    }

    void cancelBooking() {
        bookingStatus = "Cancelled";
        System.out.println("Booking cancelled");
    }

    void updateBookingDate(String newDate) {
        bookingDate = newDate;
    }
}