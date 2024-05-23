package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner myScanner;

    public UserInterface() {
        myScanner = new Scanner(System.in);
    }

    public void display() {
        init();
        boolean quit = false;
        while (!quit) {
            System.out.println("          Welcome!          ");
            System.out.println("============================");
            System.out.println("      Choose an option      ");
            System.out.println(" ");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("10. Lease a vehicle.");
            System.out.println("11. Buy a vehicle");
            System.out.println("0. Quit");

            System.out.print("Enter your choice: ");
            String choice = myScanner.nextLine();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    processLeaseAVehicle();
                    break;
                case "11":
                    processVehicleSale();
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = myScanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = myScanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = myScanner.nextLine();
        System.out.print("Enter model: ");
        String model = myScanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = myScanner.nextInt();
        System.out.print("Enter maximum year: ");
        int max = myScanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = myScanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = myScanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = myScanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = myScanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter vehicle vin: ");
        int vin = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter vehicle make: ");
        String make = myScanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = myScanner.nextLine();

        System.out.print("Enter vehicle year: ");
        int year = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter vehicle price: ");
        double price = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.print("Enter vehicle color: ");
        String color = myScanner.nextLine();

        System.out.print("Enter vehicle mileage: ");
        int mileage = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter vehicle type (Car, Truck, SUV, Motorcycle): ");
        String type = myScanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);

        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter the VIN of the vehicle you wish to remove: ");
        int vin = myScanner.nextInt();

        boolean vehicleRemoved = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed successfully!");
                vehicleRemoved = true;
                break;
            }
        }

        if (!vehicleRemoved) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        }

        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    private void processLeaseAVehicle() {
        System.out.println("Please enter the date in the following format (YYYYMMDD)");
        String date = myScanner.nextLine();
        System.out.println("Please enter the name of the customer.");
        String customerName = myScanner.nextLine();
        System.out.println("Please enter the email of the customer.");
        String customerEmail = myScanner.nextLine();
        System.out.println("Please enter the vehicle's VIN number:");
        int vin = myScanner.nextInt();

    }

    private void processVehicleSale() {
        System.out.println("Please enter the date in the following format (YYYYMMDD");
        String date = myScanner.nextLine();
        System.out.println("Please enter the name of the customer.");
        String customerName = myScanner.nextLine();
        System.out.println("Please enter the email of the customer.");
        String customerEmail = myScanner.nextLine();
        System.out.println("Please enter the vehicle's VIN number:");
        int vin = myScanner.nextInt();

    }

}