package tn.amira.model;

public class CurrentAccount extends BankAccount{
    private double overDraft;

    public CurrentAccount(double overDraft) {
        this.overDraft = overDraft;
    }

    public CurrentAccount(double balance, String currency, double overDraft) {
        super(balance, currency);
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "overDraft=" + overDraft + super.toString() +
                '}';
    }

    @Override
    public String getType() {
        return "Current-Account";
    }
}
