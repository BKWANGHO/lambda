package com.turing.api;

import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.user.UserView;
import com.turing.api.crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);



        while (true) {
            System.out.println(
                    "x-Exit u-com.turing.api.user a-Article ac-Account c-Crawler ");
            switch (sc.next()) {
                case "x": return ;
                case "u": UserView.main(sc);  break;
                case "a": ArticleView.main(sc); break;
                case "ac": AccountView.main(sc); break;
                case "c": CrawlerView.main(sc); break;
                case "b": BoardView.main(); break;
            }
        }


    }
}