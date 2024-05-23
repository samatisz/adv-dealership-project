package com.pluralsight;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ContractFileManager {
    private void saveContract(Contract contract) {
        //need to use instanceOf

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("contract.txt", true));
            String typeOfContract = "";

            if (contract instanceof SalesContract) {
                typeOfContract = "Sale!";
            }

            else if (contract instanceof LeaseContract) {
                typeOfContract = "Lease!";
            }

            SalesContract salesContract = (SalesContract) contract;
            String contractInfoForSale = typeOfContract + "|" + salesContract.getDateOfContract()  + "|" + salesContract.getCustomerName() + "|" + salesContract.getCustomerEmail();

            contract.getVehicleSold();


            LeaseContract leaseContract = (LeaseContract) contract;
           // String contractInfoForLease = typeOfContract + "|"








        } catch (IOException e) {
        }

    }
}
