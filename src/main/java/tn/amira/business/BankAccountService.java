package tn.amira.business;

import tn.amira.model.BankAccount;
import java.util.List;
public interface BankAccountService {
    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getBankAccounts();
    BankAccount getBankAccountById(int id);
    void addRandomData(int size);
    void credit(String accountId,double amount);
    void debit(String accountId,double amount);
    void transfer(String accountSource,String accountDestination,double amount);

}
