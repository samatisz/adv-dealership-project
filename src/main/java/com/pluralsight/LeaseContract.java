package com.pluralsight;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;
    private double forMonthlyPayment;

    public LeaseContract(String dateOfContract, String customerName, boolean vehicleSold, double expectedEndingValue, double leaseFee, double forMonthlyPayment) {
        super(dateOfContract, customerName, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
        this.forMonthlyPayment = forMonthlyPayment;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getForMonthlyPayment() {
        return forMonthlyPayment;
    }

    public void setForMonthlyPayment(double forMonthlyPayment) {
        this.forMonthlyPayment = forMonthlyPayment;
    }
}
