import account.AccountView;
import board.BoardView;
import user.UserView;
import crawler.CrawlerView;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);



        while (true) {
            System.out.println(
                    "0-종료  1-게시판  2-사용자관리 3-통장관리 4-Crawler");
            switch (sc.next()) {
                case "0": return ;
                case "1": UserView.main(sc);  break;
                case "2": BoardView.main(); break;
                case "3": AccountView.main(sc); break;
                case "4": CrawlerView.main(sc); break;
            }
        }


    }
}