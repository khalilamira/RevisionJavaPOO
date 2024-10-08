package tn.amira;

import tn.amira.Exceptions.AccountNotFoundException;
import tn.amira.business.BankAccountService;
import tn.amira.business.BankAccountServiceImpl;
import tn.amira.model.BankAccount;
import tn.amira.utilis.DataTransformationUtils;

import java.util.Optional;

public class Application {
    public static void main(String[] args){
        BankAccountService bankAccountService = new BankAccountServiceImpl();
       /* bankAccountService.addBankAccount(new CurrentAccount(43,"effe",2333));
        bankAccountService.addBankAccount(new SavingAccount(45,"FRR",456));
        BankAccount  account3 = new CurrentAccount(43,"effe",2333);
        account3.setAccountId("C1");
        bankAccountService.addBankAccount(account3);
        bankAccountService.getBankAccounts().forEach(System.out::println);

        System.out.println("chercher un compte");
        try{
            BankAccount accountbyid = bankAccountService.getBankAccountById("C4");
            System.out.println(accountbyid);
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }*/
        System.out.println("les comptes avec random");
        bankAccountService.addRandomData(20);

        bankAccountService.getBankAccounts()
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);
        bankAccountService.getBankAccounts().stream().findFirst().ifPresent(account -> account.setAccountId("JAD"));
        Optional<BankAccount> any = bankAccountService.getBankAccounts().stream().findAny();


        try {
            System.out.println(DataTransformationUtils.toJson(bankAccountService.getBankAccountById("JAD")));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("+++++++++++");
    }
}
