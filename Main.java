package com.turing.api;

import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.enums.Navigation;
import com.turing.api.user.UserView;
import com.turing.api.crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);

        while (Navigation.selectmain(sc)) {

<<<<<<< HEAD

        while (true) {
            System.out.println(
                    "0-종료  1-게시판  2-사용자관리 3-통장관리 4-Crawler");
            switch (sc.next()) {
                case "0": return ;
                case "1": UserView.main(sc);  break;
                case "2": BoardView.main(); break;
                case "3": AccountView.main(sc); break;
                case "4": CrawlerView.main(sc); break;
=======
>>>>>>> develop-1.1
            }
        }



    }
