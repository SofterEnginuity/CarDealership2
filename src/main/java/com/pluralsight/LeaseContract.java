package com.pluralsight;

public class LeaseContract extends Contract{

    private double salesTaxAmount;
    private int processingFee;
    private boolean wantsFinance;
    private double expectedValue;  //50% of original price
    private double leaseFee;  //7% of the original price
    private double monthlyPayment;  //All leases are financed at 4.0% for 36 months


    public LeaseContract(String date, String name, String email, boolean vehicleSold, double leaseFee, double expectedValue, boolean wantsFinance, int processingFee, int recordingFee) {
        super(date, name, email, vehicleSold);
        this.leaseFee = leaseFee;
        this.expectedValue = expectedValue;
        this.wantsFinance = wantsFinance;
        this.processingFee = processingFee;

    }


    @Override
    public double getTotalPrice() {
        double rate;
        int term;
        double totalPrice;
        if(vehicle.getPrice() >= 10000) {
            rate = vehicle.getPrice() * 0.0425;
            term = 48;
            totalPrice = vehicle.getPrice() + rate;

        }else{
            rate = vehicle.getPrice() * 0.0525;
            term = 24;
            totalPrice = vehicle.getPrice() + rate;
        }
        return super.getTotalPrice();
    }


    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }



}
