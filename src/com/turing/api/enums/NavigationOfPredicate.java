package com.turing.api.enums;

import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationOfPredicate {

    EXIT ("x", (sc)-> {
        return false;
    }),
    USER ("u", (sc)-> {
        //            UserView.main(sc);
        UserRouter.getview(sc);
        return true;
    }),
    ARTICLE ("a", (sc)-> {
        //            ArticleView.main(sc);
        while(ArticleRouter.getview(sc));

        return true;
    }),
    ACCOUNT ("ac", (sc)-> {
//        AccountView.main(sc);
        while (AccountRouter.getview(sc));
        return true;
    }),
    CRAWLER ("c", (sc)-> {
        //            CrawlerView.main(sc);
        while (CrawlerRouter.getview(sc));
        return true;}),
    BOARD ("b", (sc)->{
        while (BoardRouter.getview(sc));
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
    public static boolean selectMain(Scanner sc){
        System.out.println(
                "x-Exit u-user a-Article ac-Account c-Crawler b-Board");
        String msg = sc.next();
        return Stream.of(NavigationOfPredicate.values())
                .filter(i->i.menu.equals(msg))
                .findAny().orElse(ERROR)
                .predicate.test(sc);
    }
}