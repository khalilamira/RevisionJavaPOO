package tn.amira.business;

import tn.amira.Exceptions.AccountNotFoundException;
import tn.amira.model.BankAccount;
import java.util.List;
public interface BankAccountService {
    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getBankAccounts();
    BankAccount getBankAccountById(String id) throws AccountNotFoundException;
    void addRandomData(int size);
    void credit(String accountId,double amount);
    void debit(String accountId,double amount);
    void transfer(String accountSource,String accountDestination,double amount);

}
