package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserInterface{

    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;
    private SalesContract contract;

    public void display() {
        init();
        int selection = -1;

        do {
            System.out.println("\nPlease make a selection: ");
            System.out.println("1   Display All Vehicles");
            System.out.println("2   Filter by VIN");
            System.out.println("3   Filter by Price");
            System.out.println("4   Filter by Make and Model");
            System.out.println("5   Filter by Year");
            System.out.println("6   Filter by Color");
            System.out.println("7   Filter by Mileage");
            System.out.println("8   Filter by Vehicle Type");
            System.out.println("9   Add a Vehicle to inventory");
            System.out.println("10  Remove a Vehicle form inventory");
            System.out.println("11  Sales Contracts");
            System.out.println("12  Lease contracts");
            System.out.println("0   Exit");


            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); //
                continue;
            }

            switch (selection) {
                case 1:
                    processGetAllVehiclesRequest();
                    break;
                case 2:
                    processGetVehiclesByVin();
                    break;

                case 3: processGetByPriceRequest();
                    break;

                case 4:
                    processGetByMakeModelRequest();
                    break;
                case 5:
                    processGetByYearRequest();
                    break;
                case 6:
                    processGetByColorRequest();
                    break;
                case 7:
                    processGetByMileageRequest();
                    break;
                case 8:
                    processGetByVehicleTypeRequest();
                    break;
                case 9:
                    processAddVehicleRequest();
                    break;
                case 10:
                    processRemoveVehicleRequest();
                    break;
                case 11:
                    processGetSalesContract();
                    break;
                case 12:
                    processGetLeaseContract();
                    break;
                case 0:
                    System.out.println("Thank you for stopping by my dealership");
                    break;
                default:
                    System.out.println("Invalid selection.");
            }

        } while (selection != 0);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

    }
    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }
    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }
    public void processGetVehiclesByVin() {
        System.out.println("Please enter a vin to search");
        int vin = scanner.nextInt();
        List<Vehicle> vehicleByVin = dealership.getVehiclesByVin(vin);
        displayVehicles(dealership.getVehiclesByVin(vin));

    }
    public void processGetByPriceRequest() {
        System.out.println("Please enter a minimum price:");
        double min = scanner.nextDouble();
        System.out.println("Please enter a maximum price:");
        double max = scanner.nextDouble();
        displayVehicles(dealership.getVehiclesByPrice(min, max));

    }
    public void processGetByMakeModelRequest() {
        System.out.println("Please enter the Make of a Vehicle you would like to search:");
        String requestedMake = scanner.nextLine();
        System.out.println("Please enter the Model of a Vehicle you would like to search:");
        String requestedModel = scanner.nextLine();

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(requestedMake, requestedModel);
        displayVehicles(vehiclesByMakeModel);


    }
    public void processGetByYearRequest() {
        System.out.println("Please enter minimum year you would like to search by:");
        int min = scanner.nextInt();
        System.out.println("Please enter maximum year you would like to search by:");
        int max = scanner.nextInt();
        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(min, max);
        displayVehicles(dealership.getVehiclesByYear(min,max));
    }
    public void processGetByColorRequest() {
        System.out.println("Please enter the Color of Vehicle you would like to search:");
        String requestedColor = scanner.nextLine();
        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(requestedColor);
        displayVehicles(vehiclesByColor);
    }
    public void processGetByMileageRequest() {
        System.out.println("Please enter the minimum Mileage");
        int min = scanner.nextInt();
        System.out.println("Please enter the maximum Mileage:");
        int max = scanner.nextInt();
        List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehiclesByMileage);
    }
    public void processGetByVehicleTypeRequest() {
        System.out.println("Please select a vehicle type");
        System.out.println("1 - Car");
        System.out.println("2 - SUV");
        System.out.println("3 - Truck");
        int selection = scanner.nextInt();
        String vehicleType = null;
        switch (selection) {
            case 1:
                vehicleType = "Car";
                break;
            case 2:
                vehicleType = "SUV";
                break;
            case 3:
                vehicleType = "Truck";
                break;
            default:
                System.out.println("Invalid selection.");
                return;
        }

        List<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehiclesByType);

    }
    public void processAddVehicleRequest() {

        System.out.println("Please enter the Vin Number");
        int vin = scanner.nextInt();
        System.out.println("Enter the Price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the Make ");
        String make = scanner.nextLine();
        System.out.println("Enter the Model");
        String model = scanner.nextLine();
        System.out.println("Enter the Year");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the color");
        String color = scanner.nextLine();
        System.out.println("Enter the Mileage");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Vehicle Type (Car, Truck, SUV)");
        String newVehicleType = scanner.nextLine();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin,year,make,model,newVehicleType,color,mileage,price);
        System.out.println(year + " " + make + " " + model + " added to dealership");
        dealership.addVehicle(vehicle);
        DealershipFileManager.saveDealership(dealership);
    }
    public void processRemoveVehicleRequest() {
        System.out.println("Please enter the VIN number of the vehicle to remove from inventory:");
        int vinToRemove = scanner.nextInt();
        Vehicle vehicleToRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vinToRemove) {
                vehicleToRemove = v;
                break;
            }
        }
        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println(vehicleToRemove.getYear() + " " + vehicleToRemove.getMake() + " " + vehicleToRemove.getModel() + " removed from dealership.");
            DealershipFileManager.saveDealership(dealership);
        } else {
            System.out.println("Vehicle with VIN " + vinToRemove + " not found.");
        }
    }





    private void getSalesContract() {

    }
    public void processGetSalesContract(){
        System.out.println("Please enter a VIN to search:");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle selectedVehicle = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                selectedVehicle = v;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("No vehicle found with VIN: " + vin);
            return;
        }

        System.out.println("Vehicle selected: " + selectedVehicle);


        System.out.print("Please enter the date of purchase: ");
        String date = scanner.nextLine();
        String formattedDate = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6);
        System.out.println(formattedDate);



        System.out.println("Please enter the name of the name of the customer");
        String name = scanner.nextLine();
        System.out.println(name);

        System.out.println("Please enter the email address of the customer");
        String email = scanner.nextLine();
        System.out.println(email);

        System.out.println("Does the customer want to finance? Y - Yes, N - No");
        String financeOption = scanner.nextLine();
        if (financeOption.equalsIgnoreCase("Y")) {
            System.out.println("Wants finance");
        } else {
            System.out.println("Does not want finance");
        }

        System.out.println(financeOption);

        SalesContract contract = new SalesContract(date, name, email, selectedVehicle, vehicleSold, financeOption);



        System.out.println("Grand Total" + contract.getTotalPrice());
        System.out.println("Monthly Payment" + contract.getMonthlyPayment());
    }







    public void processGetLeaseContract(){
        System.out.println("works");
    }



}