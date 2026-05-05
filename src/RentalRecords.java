class RentalRecord {
    String recordID;
    String bookingID;
    String rentalStartDate;
    String rentalEndDate;
    double totalCost;

    void generateRecord() {
        System.out.println("Record generated");
    }

    double calculateCost(double pricePerDay, int days) {
        totalCost = pricePerDay * days;
        return totalCost;
    }

    String viewRecord() {
        return "Record ID: " + recordID;
    }
}