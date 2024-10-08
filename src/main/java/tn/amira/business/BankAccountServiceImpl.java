package tn.amira.business;

import tn.amira.Exceptions.AccountNotFoundException;
import tn.amira.Exceptions.BalanceNotSufficientException;
import tn.amira.model.AccountStatus;
import tn.amira.model.BankAccount;
import tn.amira.model.CurrentAccount;
import tn.amira.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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


        //declarative approche
        /*return bankAccountList
                .stream()
                .filter(account -> account.getAccountId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(String.format("Bank account %s not found",id)));*/
        //Imperative approche
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getAccountId().equals(id)) {
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
    public void credit(String accountId, double amount) throws AccountNotFoundException {
        BankAccount bankAccount = getBankAccountById(accountId);
        bankAccount.setBalance(bankAccount.getBalance()+amount);
    }

    @Override
    public void debit(String accountId, double amount) throws AccountNotFoundException,BalanceNotSufficientException {
        BankAccount bankAccount = getBankAccountById(accountId);
        if (bankAccount.getBalance()-amount<0) throw new BalanceNotSufficientException("Balance not sufficient");
        bankAccount.setBalance(bankAccount.getBalance()+amount);
    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        debit(accountSource,amount);
        credit(accountDestination,amount);
    }
}
