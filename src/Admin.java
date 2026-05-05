class Admin extends User {
    String adminID;

    void addCar(Car car) {
        System.out.println("Car added: " + car.model);
    }

    void deleteCar(String carID) {
        System.out.println("Car deleted: " + carID);
    }

    void manageUsers() {
        System.out.println("Managing users");
    }

    void viewRentalRecords() {
        System.out.println("Viewing rental records");
    }
}