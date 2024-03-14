package com.turing.api.account;


import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) {
        AccountController accountController = new AccountController();

        while (true) {
            System.out.println("[Account] 0-Exit\n " +
                    "1-Creat\n" +
                    "2-Deposit\n " +
                    "3-Withdraw\n " +
                    "4-GetBalance\n " +
                    "5-RemoveAccount\n "+
                    "6-AccountList\n "
            );
            switch (sc.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    System.out.println("=== CreatAccount ===");
                    System.out.println(accountController.createAccount(sc));
                    break;
                case "2":
                    System.out.println("=== Deposit ===");
                    System.out.println(accountController.deposit(sc));
                    break;
                case "3":
                    System.out.println("=== Withdraw ===");
                    System.out.println(accountController.withdraw(sc));
                    break;
                case "4":
                    System.out.println("=== getBalance ===");
                    System.out.println(accountController.getBalance(sc));


                    break;
                case "5":
                    System.out.println("=== RemoveAccount ===");
                    accountController.removeAccount(sc);
                    break;
                case "6":
                    System.out.println("=== AccountList ===");
                    System.out.println(accountController.accountList());
                    break;
            }


        }


    }
}
