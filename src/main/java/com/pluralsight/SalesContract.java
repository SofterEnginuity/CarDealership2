package com.pluralsight;

public class SalesContract extends Contract{

    Vehicle vehile;
    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean wantsFinance;
    private  double monthlyPayment;//if usr choses to finance:



    public SalesContract(String date, String name, String email, boolean vehicleSold, double salesTaxAmount, int recordingFee, int processingFee) {
        super(date, name, email, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
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
        if(vehicle.getPrice() >= 10000) {
            rate = vehicle.getPrice() * 0.0425;
            term = 48;
           totalPrice = vehicle.getPrice() + rate;

        }else{
            rate = vehicle.getPrice() * 0.0525;
            term = 24;
            totalPrice = vehicle.getPrice() + rate;
        }

        return totalPrice;
    }


    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    //be mindful of finance options, be sure to test and account for that

}
