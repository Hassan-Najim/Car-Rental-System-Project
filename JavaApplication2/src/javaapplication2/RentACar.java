package javaapplication2;

import java.util.ArrayList;

public class RentACar {
    private ArrayList<CarInfo> cars;
    private ArrayList<Customer> customers;

    public RentACar() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        // Initializes two ArrayLists to store car and customer objects
    }

    // Method to rent a car
    public void rentCar(int carIndex, Customer customer) {
        CarInfo car = cars.get(carIndex); // Retrieving a car by it's index and assigning it to a new customer
        if (car.isAvailable()) { // Checks if car is avaialable
            car.isAvailable(); // Set's car to flase to rent it out
            car.setRenter(customer); // assign customer
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    // Method to display already rented cars
    public void manageRentedCars() {
        for (int i = 0; i < cars.size(); i++) {
            CarInfo car = cars.get(i);
            if (!car.isAvailable()) {
                System.out.println(
                        "Rented Car: " + car.getBrand() + " " + car.getModel() + " by " + car.getRenter().getName());
            }
        }
    }

    // Remove methods are managed by indexes

    // Method to add a new car
    public void addCar(CarInfo car) {
        cars.add(car);
        System.out.println("Car added successfully");
    }

    // Method to remove a car
    public void removeCar(int carIndex) {
        cars.remove(carIndex);
        System.out.println("Car removed successfully!");
    }

    // Method to update car information with a new car, replacing the old one
    public void updateCar(int carIndex, CarInfo newCar) {
        cars.set(carIndex, newCar);
        System.out.println("Car information updated successfully!");
    }

    // Method to add a new customer (into arraylist)
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully!");
    }

    // Method to remove a customer
    public void removeCustomer(int customerIndex) {
        customers.remove(customerIndex);
        System.out.println("Customer removed successfully!");
    }

}
