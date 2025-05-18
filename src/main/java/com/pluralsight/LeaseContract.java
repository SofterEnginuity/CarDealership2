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
        return super.getTotalPrice();
    }


    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }



}
