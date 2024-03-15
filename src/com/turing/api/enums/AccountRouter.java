package com.turing.api.enums;

import com.turing.api.account.AccountController;
import menu.MenuController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    Exit("x",i->{
        System.out.println("Exit");
        return false;
    }),
    CreatAccount("touch",i->{
        System.out.println(AccountController.getInstance().createAccount(i));
        return true;
    }),
    Deposit("depo",i->{
        System.out.println(AccountController.getInstance().deposit(i));
        return true;
    }),
    Withdraw("with",i->{
        System.out.println(AccountController.getInstance().withdraw(i));
        return true;
    }),
    GetBalance("bal",i->{
        System.out.println(AccountController.getInstance().getBalance(i));
        return true;
    }),
    RemoveAccount("rm",i->{
        System.out.println(AccountController.getInstance().removeAccount(i));
        return true;
    }),
    AccountList("ls-a",i->{
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
        System.out.println(MenuController.getInstance().printMain("account"));

        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny().orElseGet(()->Error)
                .predicate.test(sc);
    }
}
