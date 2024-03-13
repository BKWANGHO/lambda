package com.turing.api.enums;

import com.turing.api.Main;
import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.user.UserView;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum Navigation {

    EXIT ("x", (sc)-> {
        return false;
    }),
    USER ("u", (sc)-> {
        //            UserView.main(sc);
        UserRouter.getview(sc);
        return true;
    }),
    ARTICLE ("a", (sc)-> {
        try {
            ArticleView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ACCOUNT ("ac", (sc)-> {
        AccountView.main(sc);
        return true;
    }),
    CRAWLER ("c", (sc)-> {
        try {
            CrawlerView.main(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    BOARD ("b", (sc)->{
        BoardView.main();
        return true;
    }),
    NAVIGATION_ERROR("er",(sc)-> {
        System.out.println("에러입니다.");
        return true;
    });

    private final String menu;
    private final Predicate<Scanner> predicate;


    Navigation(String menu,Predicate<Scanner> predicate) {
        this.menu = menu;
        this.predicate = predicate;

    }
    public static boolean selectmain(Scanner sc){
        System.out.println(
                "x-Exit u-user a-Article ac-Account c-Crawler b-Board");
        String msg = sc.next();
        return Stream.of(Navigation.values())
                .filter(i->i.menu.equals(msg))
                .findAny().orElse(NAVIGATION_ERROR)
                .predicate.test(sc);
    }



}
