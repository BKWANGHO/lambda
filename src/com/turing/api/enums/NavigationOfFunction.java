package com.turing.api.enums;

import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    EXIT ("x", (sc)-> "exit"
    ),
    USER ("u", (sc)-> {
        //            UserView.main(sc);
        try {
            UserRouter.getview(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "user";
    }),
    ARTICLE ("a", (sc)-> {
        try {
            ArticleView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "article";
    }),
    ACCOUNT ("ac", (sc)-> {
        AccountView.main(sc);
        return "account";
    }),
    CRAWLER ("c", (sc)-> {
        try {
            CrawlerView.main(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "crawler";
    }),
    BOARD ("b", (sc)->{
        BoardView.main();
        return "board";
    }),
    ERROR("er",(sc)-> {
        System.out.println("에러입니다.");
        return "error";
    });
    ;


    private final String menu ;
    private final Function<Scanner,String> function;

    NavigationOfFunction(String menu, Function<Scanner, String> function) {
        this.menu = menu;
        this.function = function;
    }

    public static String selectMain(Scanner sc) {
        System.out.println(
                "x-exit u-user a-Article ac-Account c-Crawler b-Board");
        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.menu.equals(msg))
                .findAny().orElse(ERROR)
                .function.apply(sc);
    }
}
