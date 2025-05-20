package com.pluralsight;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.SortedMap;

public class SalesContract extends Contract {

    Vehicle vehicle;
    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean wantsFinance;
    private double monthlyPayment;//if usr chooses to finance:



    public SalesContract(Vehicle vehicle, String date, String name, String email, boolean vehicleSold, double salesTaxAmount, int recordingFee, int processingFee) {
        super(date, name, email, vehicleSold);
        this.vehicle = vehicle;
        this.salesTaxAmount = 0.005;
        this.recordingFee = 100;

        if(getTotalPrice() < 10000) {
            this.processingFee = 295;
            System.out.println("Your processing fee is $" + processingFee);
        }else{
            this.processingFee = 495;
            System.out.println("Your processing fee is $" + processingFee);
        }

        wantsFinance = false;



    }
    public void getSalesContract() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sales Contract");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = now.format(formatter);
        setDate(date);
        System.out.println(getDate());
        System.out.println("Please enter the name of the customer");
        String name = scanner.nextLine();
        setName(name);
        System.out.println(getName());
        System.out.println("Please enter the email address of the customer");
        String email = scanner.nextLine();
        setEmail(email);
        System.out.println(getEmail());

        System.out.println("Has this vehicle been sold?");
        System.out.println("Y - Yes, N - No");
        String isSold = scanner.nextLine();
        if (isSold.equalsIgnoreCase("Y")){
            setVehicleSold(true);
        }else {
           setVehicleSold(false);
        }
        System.out.println(isVehicleSold());

        System.out.println("Sales tax is" + getSalesTaxAmount() + "%.");
        System.out.println("Recording fee is $" + getRecordingFee() + ".");
        System.out.println("Does the customer want to finance?");
        System.out.println("Y - Yes, N - No");

        System.out.println("Does the customer want to finance the vehicle?");
        System.out.println("Y - Yes, N - No");
        String finance = scanner.nextLine();
        if (finance.equalsIgnoreCase("Y")){
            this.wantsFinance = true;
            System.out.println("You have selected for the user to finance");
        }else {
            this.wantsFinance = false;
            System.out.println("You have opted out of financing options");
        }

        System.out.println("Total price for the vehicle is $" + getTotalPrice());
        System.out.println("Monthly payments would be $" + getMonthlyPayment() + "/ mo.");
    }



    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }


    //All loans are at 4.25% for 48 months if the price is $10,000 or more
//Otherwise they are at 5.25% for 24 month
//It is possible that getMonthlyPayment() would return
//0 if they chose the NO loan option.


    @Override
    public double getTotalPrice() {

        double rate;
        int term;
        double totalPrice;
        if (vehicle.getPrice() >= 10000) {
            rate = vehicle.getPrice() * 0.0425;
            totalPrice = vehicle.getPrice() + rate + recordingFee + salesTaxAmount;
        } else {
            rate = vehicle.getPrice() * 0.0525;
            totalPrice = vehicle.getPrice() + rate + recordingFee + salesTaxAmount;;
        }
        return totalPrice;
    }


    @Override
    public double getMonthlyPayment() {
        int term;
        if (getVehicle().getPrice() >= 10000) {
            term = 48;
            monthlyPayment = getTotalPrice() / term;
        } else {
            term = 24;
            monthlyPayment = getTotalPrice() / term;

        } return monthlyPayment;

    }
}
