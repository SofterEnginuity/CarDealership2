package com.pluralsight;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractFileManager {
//    Contract contract = null;

    private static final String FILE_NAME = "contracts.csv";
    public void saveContract(Contract contract) {

        try {
            FileWriter fw = new FileWriter(FILE_NAME,true);
            PrintWriter pw = new PrintWriter(new PrintWriter(FILE_NAME));
            if(contract instanceof SalesContract){
                SalesContract salesContract = new SalesContract(contract.getDate(),contract.getName(), contract.getEmail(), contract.getVehicleSold(), ((SalesContract) contract).getSalesTaxAmount(), ((SalesContract) contract).getRecordingFee(), ((SalesContract) contract).getProcessingFee(), ((SalesContract) contract).isFinanceOption());

            }else if(contract instanceof LeaseContract){
            LeaseContract leaseContract = new LeaseContract(contract.getDate(),contract.getName(), contract.getEmail(), contract.getVehicleSold(), ((LeaseContract) contract).getLeaseFee(),((LeaseContract) contract).getExpectedEndingValue());
            }else{
                System.out.println("Please make a valid selection");
            }
            saveContract(contract);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }System.out.println("Error reading file: ");

    }


    }

