package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership extends Contract {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    public Dealership(String date, String name, String email, boolean vehicleSold, String name1, String address, String phone, ArrayList<Vehicle> inventory) {
        super(date, name, email, vehicleSold);
        this.name = name1;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> inPriceRange = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if(vehicle.getPrice() <= max && vehicle.getPrice() >= min){
                inPriceRange.add(vehicle);
            }
        } return inPriceRange;
    }
    public List<Vehicle> getVehiclesByMakeModel(String requestedMake, String requestedModel){
        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(requestedMake) && vehicle.getModel().equalsIgnoreCase(requestedModel)){
                vehiclesByMakeModel.add(vehicle);
            }
        } return vehiclesByMakeModel;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            int year = vehicle.getYear();
            if(year >= min && year <= max){
                vehiclesByYear.add(vehicle);
            }
        } return vehiclesByYear;
    }
    public List<Vehicle> getVehiclesByColor(String requestedColor){
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if(requestedColor.equalsIgnoreCase(vehicle.getColor())){
                vehiclesByColor.add(vehicle);
            }
        } return vehiclesByColor;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMileage() >= min && vehicle.getMileage() <= max) {
                vehiclesByMileage.add(vehicle);
            }
        }
        return vehiclesByMileage;
    }
    public List<Vehicle> getVehiclesByVin(int vinToSearch) {
        List<Vehicle> vehiclesByVin = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vinToSearch) {
                vehiclesByVin.add(vehicle);
            }
        }
        return vehiclesByVin;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }


//    public List<Dealership> getAllDealerships() {
//        name = getName();
//        address = getAddress();
//        phone = getPhone();
//    }


}