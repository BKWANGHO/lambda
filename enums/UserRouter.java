package com.turing.api.enums;

import com.turing.api.user.User;
import com.turing.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouter {

    JOIN("join",i->{

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
    LOGIN("login",i->{
        try {
            System.out.println("아이디, 비밀번호 입력");
            return UserController.getInstance().login(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    CREATETABLE("createtable",i->{
        try {
            return UserController.getInstance().touchTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    RE("er",i->{
        System.out.println("다시입력해주세요");
        return Messenger.SUCCESS;
    })
    ;
    private final String menu;

    private final Function<Scanner, Messenger> function;

    UserRouter(String menu, Function<Scanner, Messenger> function) {
        this.menu = menu;
        this.function = function;
    }

    public static void getview(Scanner sc){
        String msg = sc.next();


        while (true){
            System.out.println(Stream.of(UserRouter.values())
                    .filter(i->i.menu.equals(msg))
                    .findAny().orElse(RE)
                    .function.apply(sc));
        }
    }


}
