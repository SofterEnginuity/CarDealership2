package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;
        String fileName = "newInventory.csv";

        try (BufferedReader bufRead = new BufferedReader(new FileReader(fileName))) {
            String line;
//            bufRead.readLine();
            while ((line = bufRead.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String address = parts[1].trim();
                    String phoneNumber = parts[2].trim();
                    dealership = new Dealership(name, address, phoneNumber);
                } else {
                    int vin = Integer.parseInt(parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String make = parts[2].trim();
                    String model = parts[3].trim();
                    String vehicleType = parts[4].trim();
                    String color = parts[5].trim();
                    int mileage = Integer.parseInt(parts[6].trim());
                    double price = Double.parseDouble(parts[7].trim());

                    if (dealership != null) {
                        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, mileage, price));
                    }
                }
            }
        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }




    public static void saveDealership(Dealership dealership) {
        try (FileWriter fw = new FileWriter("newInventory.csv");
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();


            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String vehicleDetails = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getMileage(), vehicle.getPrice());
                bw.write(vehicleDetails);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
