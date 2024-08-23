package tn.amira.model;

public class SavingAccount extends BankAccount{

    private double interestRate;

    public SavingAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingAccount(double balance, String currency, double interestRate) {
        super(balance, currency);
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "interestRate=" + interestRate + super.toString() +
                '}';
    }

    @Override
    public String getType() {
        return "SAVING-ACCOUNT";
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


}
