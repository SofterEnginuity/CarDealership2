package com.pluralsight;

public class LeaseContract extends Contract{

    private double salesTaxAmount;
    private int processingFee;
    private boolean wantsFinance;
    private double expectedEndingValue;  //50% of original price
    private double leaseFee;  //7% of the original price
    private double monthlyPayment;  //All leases are financed at 4.0% for 36 months


    public LeaseContract(String date, String name, String email, Vehicle vehicleSold, double leaseFee, double expectedValue, boolean wantsFinance, int processingFee, int recordingFee) {
        super(date, name, email, vehicleSold);
        this.leaseFee = leaseFee;
        this.expectedEndingValue = expectedValue;
        this.wantsFinance = wantsFinance;
        this.processingFee = processingFee;

    }


    @Override
    public double getTotalPrice() {
        return (getVehicleSold().getPrice() - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }


}
