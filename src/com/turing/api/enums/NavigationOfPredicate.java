package com.turing.api.enums;

import menu.MenuController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationOfPredicate {

    EXIT ("x", (sc)-> {
        return false;
    }),
    USER ("usr", (sc)-> {
        //            UserView.main(sc);
        try {
            UserRouter.getview(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ARTICLE ("art", (sc)-> {
        //            ArticleView.main(sc);
        while(true) {
            try {
                if (!ArticleRouter.getview(sc)) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ;
        }

        return true;
    }),
    ACCOUNT ("acc", (sc)-> {
//        AccountView.main(sc);
        while (true) {
            try {
                if (!AccountRouter.getview(sc)) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ;
        }
        return true;
    }),
    CRAWLER ("cwl", (sc)-> {
        //            CrawlerView.main(sc);
        while (true) {
            try {
                if (!CrawlerRouter.getview(sc)) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ;
        }
        return true;}),
    BOARD ("bbs", (sc)->{
        while (true) {
            try {
                if (!BoardRouter.getview(sc)) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ;
        }
        return true;
    }),
    SOCCER ("ssc", (sc)->{


        return true;
    }),
    ERROR("er",(sc)-> {
        System.out.println("다시입력하세요.");
        return true;
    });

    private final String menu;
    private final Predicate<Scanner> predicate;

    NavigationOfPredicate(String menu, Predicate<Scanner> predicate) {
        this.menu = menu;
        this.predicate = predicate;
    }
    public static boolean selectMain(Scanner sc) throws SQLException {
        System.out.println(MenuController.getInstance().printMain("navigate"));
        String msg = sc.next();
        return Stream.of(NavigationOfPredicate.values())
                .filter(i->i.menu.equals(msg))
                .findAny().orElse(ERROR)
                .predicate.test(sc);
    }
}