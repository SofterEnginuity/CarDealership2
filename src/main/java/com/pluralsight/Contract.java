package com.pluralsight;

public abstract class Contract {
    Vehicle vehicle;
    private String date;
    private String name;
    private String email;
    private boolean vehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String name, String email, boolean vehicleSold) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicleSold = vehicleSold;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(boolean vehicleSold) {
        this.vehicleSold = vehicleSold;
    }


    public double getTotalPrice() {
        return totalPrice; //based on contract type


    }

    public double getMonthlyPayment() {
        return monthlyPayment;//based on contract type

    }


    public Vehicle getVehicle(){
        return vehicle;
    }
}

