import com.fasterxml.jackson.core.JsonProcessingException;
import tn.amira.model.BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
public class App2 {
    public static void main(String[] args) throws JsonProcessingException {
        BankAccount[] myBankAccount = new BankAccount[4];
        myBankAccount[0] = new BankAccount(444, "usd");
        myBankAccount[1] = new BankAccount(333, "fr");
        myBankAccount[2] = new BankAccount(222, "tn");
        myBankAccount[3] = new BankAccount(111, "ita");
        for (int i = 0; i < myBankAccount.length; i++) {
            System.out.println(myBankAccount[i]);
        }
        for (BankAccount account : myBankAccount) {
            System.out.println(account.getBalance());
        }
        System.out.println("pour les listes");
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(new BankAccount(555, "cha"));
        bankAccountList.add(new BankAccount(666, "chb"));
        bankAccountList.add(new BankAccount(777, "chc"));
        bankAccountList.add(new BankAccount(888, "chd"));
        for (BankAccount account : bankAccountList) {
            System.out.println(account.getBalance());
        }
        System.out.println("pour les maps");
        Map<String,BankAccount> bankAccountMap = new HashMap<>();
        bankAccountMap.put("cc1",new BankAccount(453, "usd"));
        bankAccountMap.put("cc2",new BankAccount(443, "usd"));
        bankAccountMap.put("cc3",new BankAccount(412, "usd"));
        bankAccountMap.put("cc4",new BankAccount(445, "usd"));

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
