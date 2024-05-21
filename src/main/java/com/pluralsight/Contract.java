package com.pluralsight;

public abstract class Contract {
    private String dateOfContract;
    private String customerName;
    private boolean vehicleSold;

    public Contract(String dateOfContract, String customerName, boolean vehicleSold) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.vehicleSold = vehicleSold;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(boolean vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}
