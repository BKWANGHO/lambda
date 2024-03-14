package com.turing.api.enums;

import com.turing.api.account.AccountController;
import menu.MenuController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    Exit("0",i->{
        System.out.println("Exit");
        return false;
    }),
    CreatAccount("1",i->{
        System.out.println(AccountController.getInstance().createAccount(i));
        return true;
    }),
    Deposit("2",i->{
        System.out.println(AccountController.getInstance().deposit(i));
        return true;
    }),
    Withdraw("3",i->{
        System.out.println(AccountController.getInstance().withdraw(i));
        return true;
    }),
    GetBalance("4",i->{
        System.out.println(AccountController.getInstance().getBalance(i));
        return true;
    }),
    RemoveAccount("5",i->{
        System.out.println(AccountController.getInstance().removeAccount(i));
        return true;
    }),
    AccountList("6",i->{
        System.out.println(AccountController.getInstance().accountList());
        return true;
    }),
    Error("error",i->{
        System.out.println("다시입력하세요");
        return true;
    })
    ;

    private final String name ;
    private final Predicate<Scanner> predicate;

    AccountRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean getview(Scanner sc) throws SQLException {
        System.out.println(MenuController.getInstance().printAccount());

        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny().orElseGet(()->Error)
                .predicate.test(sc);
    }
}
