package com.pluralsight;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractFileManager {
//    Contract contract = null;

    private static final String FILE_NAME = "contracts.csv";
    public void saveContract(Contract contract) {

        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            PrintWriter pw = new PrintWriter(fw);

            if (contract instanceof SalesContract) {
//                pw.println(
//                        contract.getDate() + "|" +
//                                contract.getName() + "|" +
//                                contract.getEmail() + "|" +
//                                contract.getVehicleSold().getVin() + "|" +
//                                ((SalesContract) contract).getSalesTaxAmount() + "|" +
//                                ((SalesContract) contract).getRecordingFee() + "|" +
//                                ((SalesContract) contract).getProcessingFee() + "|" +
//                                ((SalesContract) contract).isFinanceOption()
//                );
            } else if (contract instanceof LeaseContract) {
//                pw.println(
//                        contract.getDate() + "|" +
//                                contract.getName() + "|" +
//                                contract.getEmail() + "|" +
//                                contract.getVehicleSold().getVin() + "|" +
//                                ((LeaseContract) contract).getLeaseFee() + "|" +
//                                ((LeaseContract) contract).getExpectedEndingValue();
//
            } else {
                System.out.println("Please make a valid selection");
            }

            pw.close();
            System.out.println("File written? " + new File("contracts.csv").exists());

        } catch (IOException ex) {
            System.out.println("Error writing file: " + ex.getMessage());
        }


    }


    }

