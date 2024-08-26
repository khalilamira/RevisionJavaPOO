package tn.amira;

import com.fasterxml.jackson.core.JsonProcessingException;
import tn.amira.model.BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.amira.model.CurrentAccount;
import tn.amira.model.SavingAccount;

public class App2 {
    public static void main(String[] args) throws JsonProcessingException {
        BankAccount[] myBankAccount = new BankAccount[4];
        myBankAccount[0] = new CurrentAccount(43,"effe",2333);
        myBankAccount[1] = new CurrentAccount(43,"effe",2333);
        myBankAccount[2] = new SavingAccount(45,"FRR",456);
        myBankAccount[3] = new SavingAccount(45,"FRR",456);
        for (int i = 0; i < myBankAccount.length; i++) {
            System.out.println(myBankAccount[i]);
        }
        for (BankAccount account : myBankAccount) {
            System.out.println(account.getBalance());
        }
        System.out.println("pour les listes");
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(new CurrentAccount(43,"effe",2333));
        bankAccountList.add(new CurrentAccount(43,"effe",2333));
        bankAccountList.add(new SavingAccount(45,"FRR",456));
        bankAccountList.add(new SavingAccount(45,"FRR",456));
        System.out.println("$$$$$$$$$$$$$ polymorphisme");
        for (BankAccount account : bankAccountList) {
            System.out.println(account.getType());
            if (account instanceof SavingAccount) {
                System.out.println("Rate="+((SavingAccount) account).getInterestRate());
            }else if (account instanceof CurrentAccount) {
                System.out.println("Overdraft="+((CurrentAccount) account).getOverDraft());
            }
        }
        System.out.println("pour les maps");
        Map<String,BankAccount> bankAccountMap = new HashMap<>();
        bankAccountMap.put("cc1",new CurrentAccount(43,"effe",2333));
        bankAccountMap.put("cc2",new CurrentAccount(43,"effe",2333));
        bankAccountMap.put("cc3",new SavingAccount(45,"FRR",456));
        bankAccountMap.put("cc4",new SavingAccount(45,"FRR",456));

        BankAccount acc = bankAccountMap.get("cc1");
        System.out.println(acc.toString());

        for (String key : bankAccountMap.keySet()) {
            System.out.println(bankAccountMap.get(key));
        }

        for (BankAccount ba : bankAccountMap.values()) {
            System.out.println(toJson(ba));
        }

    }

    public static String toJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}
