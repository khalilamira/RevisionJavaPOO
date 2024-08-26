package tn.amira.business;

import tn.amira.Exceptions.AccountNotFoundException;
import tn.amira.model.AccountStatus;
import tn.amira.model.BankAccount;
import tn.amira.model.CurrentAccount;
import tn.amira.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public BankAccount getBankAccountById(String id) throws AccountNotFoundException{
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getAccountId().equals(id)){
                return bankAccount;
            }
        }
        throw new AccountNotFoundException("Bank account not found");
    }

    @Override
    public void addRandomData(int size) {
        AccountStatus[] values = AccountStatus.values();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            BankAccount bankAccount;
            if (Math.random() > 0.5) {
                bankAccount = new CurrentAccount(Math.random()*100000,Math.random()>0.5?"MAD":"USD", Math.random()*5000);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }else {
                bankAccount = new SavingAccount(Math.random()*100000,Math.random()>0.5?"MAD":"USD", 3 + Math.random()*7);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
            bankAccountList.add(bankAccount);
        }
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
