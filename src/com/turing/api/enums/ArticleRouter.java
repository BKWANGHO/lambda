package com.turing.api.enums;

import com.turing.api.account.AccountController;
import com.turing.api.article.ArticleController;
import menu.MenuController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ArticleRouter {
    Exit("exit",i->{
        System.out.println("Exit");
        return false;
    }),
    FindAll("ls",i->{
        System.out.println("=== 글 목록  ===");
        try {
            ArticleController.getInstance().findAll(i).forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Error("error",i->{
        System.out.println("다시입력하세요");
        return true;
    })
    ;
    private final String name;
    private final Predicate<Scanner> predicate;

    ArticleRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean getview(Scanner sc) throws SQLException {
        System.out.println(MenuController.getInstance().printMain("article"));

        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny().orElseGet(()->Error)
                .predicate.test(sc);
    }
}
