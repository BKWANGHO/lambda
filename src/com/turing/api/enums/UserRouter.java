package com.turing.api.enums;

import com.turing.api.user.UserController;
import menu.MenuController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouter {

    EXIT("exit",i->{
        return Messenger.EXIT;
    }),
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

    public static void getview(Scanner sc) throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println(MenuController.getInstance().printUser());
//            System.out.println("[메뉴] exit-종료\n " +
//                    "join-회원가입\n" +
//                    "login-로그인\n " +
//                    "findID-ID검색\n " +
//                    "updatepw-비번변경\n " +
//                    "delete-탈퇴\n " +
//                    "userls-회원목록\n " +
//                    "findname-이름검색\n" +
//                    "findjob-직업검색\n" +
//                    "usercount-회원수\n" +
//                    "touch-테이블 생성\n" +
//                    "rm-테이블 삭제");
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
