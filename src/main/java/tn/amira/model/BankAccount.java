package tn.amira.model;


import java.util.Objects;
import java.util.UUID;

public abstract class BankAccount {
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public BankAccount() {
        this.accountId = UUID.randomUUID().toString();
        this.status = AccountStatus.CREATED;
    }

    public BankAccount(double balance, String currency) {
        this();
        this.balance = balance;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        BankAccount account = (BankAccount) obj;
        if (this.accountId.equals(account.accountId)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return  Objects.hashCode(this.accountId)+
                Objects.hashCode(this.currency)+
                Objects.hashCode(this.balance)+
                Objects.hashCode(this.status);
    }

    public abstract String getType();
}
