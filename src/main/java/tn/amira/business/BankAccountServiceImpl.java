package tn.amira.business;

import tn.amira.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {

    private List<BankAccount> bankAccountList = new ArrayList<BankAccount>();

    @Override
    public BankAccount addBankAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountList;
    }

    @Override
    public BankAccount getBankAccountById(String id){
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getAccountId().equals(id)){
                return bankAccount;
            }
        }
        throw new RuntimeException("Bank account not found");
    }

    @Override
    public void addRandomData(int size) {

    }

    @Override
    public void credit(String accountId, double amount) {

    }

    @Override
    public void debit(String accountId, double amount) {

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) {

    }
}
