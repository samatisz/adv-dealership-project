package com.pluralsight;

public class SalesContract extends Contract{
    private double salesTaxAmount;
    private double recordingFees;
    private double processingFee;
    private boolean financeOption;
    private double monthlyPayment; //may equal zero if no loan was chosen

    public SalesContract(String dateOfContract, String customerName, boolean vehicleSold, double salesTaxAmount, double recordingFees, double processingFee, boolean financeOption, double monthlyPayment) {
        super(dateOfContract, customerName, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFees = recordingFees;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
        this.monthlyPayment = monthlyPayment;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFees() {
        return recordingFees;
    }

    public void setRecordingFees(double recordingFees) {
        this.recordingFees = recordingFees;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
