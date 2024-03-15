package com.turing.api.enums;

import com.turing.api.user.UserController;
import menu.MenuController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouter {

    EXIT("x",i->{
        return Messenger.EXIT;
    }),
    JOIN("joi",i->{
            System.out.println("=== 회원가입 ===");
            System.out.println("ID,비밀번호," +
                    "이름,전화번호,직업," +
                    "키,몸무게를 입력해주세요");
        try {
            return UserController.getInstance().join(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    LOGIN("log",i->{
        try {
            System.out.println("아이디, 비밀번호 입력");
            return UserController.getInstance().login(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    GetUser("cat",i->{
        try {
            System.out.println("아이디 입력");
            return UserController.getInstance().getUser(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    CREATETABLE("mk",i->{
        try {
            return UserController.getInstance().touchTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    List("ls-a",i->{
        try {
            System.out.println("=== 회원목록 ===");
            return UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    RE("er",i->{
        System.out.println("다시입력해주세요");
        return null;
    })
    ;
    private final String menu;

    private final Function<Scanner, Messenger> function;

    UserRouter(String menu, Function<Scanner, Messenger> function) {
        this.menu = menu;
        this.function = function;
    }

    public static void getview(Scanner sc) throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println(MenuController.getInstance().printMain("user"));
            String msg = sc.next();
             Messenger result = Stream.of(UserRouter.values())
                     .filter(i -> i.menu.equals(msg))
                     .findAny().orElse(RE)
                     .function.apply(sc);
            System.out.println(result);

            running = !result.equals(Messenger.EXIT);
        }

    }
}
