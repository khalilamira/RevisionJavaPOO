package tn.amira;

import tn.amira.model.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setCurrency("jad");
        account1.setBalance(455);
        printAccount(account1);
        BankAccount account2 = new BankAccount(12345, "kha");
        printAccount(account2);
        BankAccount account3 = new BankAccount(12345, "kha");
        printAccount(account3);
        account3.setAccountId(account2.getAccountId());
        System.out.println("..................");
        System.out.println(account2.hashCode());
        System.out.println(account3.hashCode());
        if(account2.hashCode() == account3.hashCode()) {
            System.out.println("les deux comptes ont les méme état ");
        } else {
            System.out.println("les deux compte n'ont pas le meme etat");
        }
        account3.setCurrency("lol");
        if(account2.hashCode() == account3.hashCode()) {
            System.out.println("les deux comptes ont les méme état ");
        } else {
            System.out.println("les deux compte n'ont pas le meme etat");
        }
        System.out.println("========================");

        System.out.println(account2.getAccountId());
        System.out.println(account3.getAccountId());
        System.out.println(account2.equals(account3));
        System.out.println("========================");
    }

    public static void printAccount(BankAccount account){
        System.out.println("$$$$$$$$$$$$$$$");
        System.out.println(account.getAccountId());
        System.out.println(account.getBalance());
        System.out.println(account.getStatus());
        System.out.println(account.getCurrency());
        System.out.println(account.toString());
        System.out.println(account.hashCode());
        System.out.println(account.equals(account));
        System.out.println("$$$$$$$$$$$$$$$");
    }
}