class Payment extends Transaction {
    String bookingID;
    String paymentDate;
    String paymentStatus;

    void process() {
        System.out.println("Processing payment of " + amount);
        paymentStatus = "Done";
    }

    String generateInvoice() {
        return "Invoice for booking " + bookingID;
    }
}