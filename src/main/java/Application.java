import tn.amira.business.BankAccountService;
import tn.amira.business.BankAccountServiceImpl;
import tn.amira.model.CurrentAccount;
import tn.amira.model.SavingAccount;

public class Application {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addBankAccount(new CurrentAccount(43,"effe",2333));
        bankAccountService.addBankAccount(new SavingAccount(45,"FRR",456));
        bankAccountService.getBankAccounts().forEach(System.out::println);

    }
}
