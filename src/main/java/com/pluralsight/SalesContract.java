package com.pluralsight;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean financeOption;

    public SalesContract(String date, String name, String email, Vehicle vehicleSold, double salesTaxAmount, int recordingFee, int processingFee, boolean financeOption) {
        super(date, name, email, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Sales Contract");
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String date = now.format(formatter);
//        setDate(date);
//        System.out.println(getDate());
//        System.out.println("Please enter the name of the customer");
//        String name = scanner.nextLine();
//        setName(name);
//        System.out.println(getName());
//        System.out.println("Please enter the email address of the customer");
//        String email = scanner.nextLine();
//        setEmail(email);
//        System.out.println(getEmail());
//
//        System.out.println("Has this vehicle been sold?");
//        System.out.println("Y - Yes, N - No");
//        String isSold = scanner.nextLine();
//        if (isSold.equalsIgnoreCase("Y")){
//            setVehicleSold(true);
//        }else {
//           setVehicleSold(false);
//        }
//        System.out.println(isVehicleSold());
//
//        System.out.println("Sales tax is" + getSalesTaxAmount() + "%.");
//        System.out.println("Recording fee is $" + getRecordingFee() + ".");
//        System.out.println("Does the customer want to finance?");
//        System.out.println("Y - Yes, N - No");
//
//        System.out.println("Does the customer want to finance the vehicle?");
//        System.out.println("Y - Yes, N - No");
//        String finance = scanner.nextLine();
//        if (finance.equalsIgnoreCase("Y")){
//            this.wantsFinance = true;
//            System.out.println("You have selected for the user to finance");
//        }else {
//            this.wantsFinance = false;
//            System.out.println("You have opted out of financing options");
//        }
//
//        System.out.println("Total price for the vehicle is $" + getTotalPrice());
//        System.out.println("Monthly payments would be $" + getMonthlyPayment() + "/ mo.");

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

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }


    //All loans are at 4.25% for 48 months if the price is $10,000 or more
//Otherwise they are at 5.25% for 24 month
//It is possible that getMonthlyPayment() would return
//0 if they chose the NO loan option.

    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financeOption) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }
}
/*    @Override
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

    }*/

