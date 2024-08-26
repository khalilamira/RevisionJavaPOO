package tn.amira;

import tn.amira.Exceptions.AccountNotFoundException;
import tn.amira.Exceptions.BalanceNotSufficientException;
import tn.amira.business.BankAccountService;
import tn.amira.business.BankAccountServiceImpl;
import tn.amira.model.BankAccount;
import tn.amira.model.CurrentAccount;
import tn.amira.model.SavingAccount;
import tn.amira.utilis.DataTransformationUtils;

public class APP3 {

    public static void main(String[] args) throws AccountNotFoundException, BalanceNotSufficientException {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        BankAccount bankAccount1 = new CurrentAccount(700,"effe",2333);
        BankAccount bankAccount2 = new SavingAccount(1000,"FRR",2.2);
        bankAccountService.addBankAccount(bankAccount1);
        bankAccountService.addBankAccount(bankAccount2);
        System.out.println(DataTransformationUtils.toJson(bankAccount1));
        System.out.println(DataTransformationUtils.toJson(bankAccount2));
        bankAccount1.setAccountId("Jad");
        bankAccount2.setAccountId("Khalil");
        System.out.println("====================================");
        System.out.println(DataTransformationUtils.toJson(bankAccount1));
        System.out.println(DataTransformationUtils.toJson(bankAccount2));
        try {
            bankAccountService.debit("Jad",500);
        } catch (AccountNotFoundException | BalanceNotSufficientException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("====================================");
        System.out.println(DataTransformationUtils.toJson(bankAccount1));
        System.out.println(DataTransformationUtils.toJson(bankAccount2));
        System.out.println("================transfer====================");
        bankAccountService.transfer("Jad","Khalil",500);
        System.out.println("====================================");
        System.out.println(DataTransformationUtils.toJson(bankAccount1));
        System.out.println(DataTransformationUtils.toJson(bankAccount2));
    }
}
