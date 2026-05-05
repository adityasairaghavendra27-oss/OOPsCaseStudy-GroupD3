class Car {
    String carID;
    String brand;
    String model;
    double pricePerDay;
    boolean availabilityStatus;

    boolean checkAvailability() {
        return availabilityStatus;
    }

    void updateAvailability(boolean status) {
        availabilityStatus = status;
    }

    String displayCarDetails() {
        return brand + " " + model;
    }
}