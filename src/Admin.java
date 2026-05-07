class Admin extends User {

    void addCar(Car car) {

        String addedCar = car.brand + " " + car.model;

    }

    void deleteCar(String carID) {

        String deletedCar = carID;

    }

    void manageUsers() {

        int totalUsers = 1;

    }

    void viewRentalRecords() {

        String status = "Viewing Rental Records";

    }
}