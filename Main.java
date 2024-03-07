import account.AccountView;
import article.ArticleView;
import board.BoardView;
import user.UserView;
import crawler.CrawlerView;

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
                    "0-종료  1-사용자관리  2-게시판 3-통장관리 4-Crawler 5-Article");
            switch (sc.next()) {
                case "0": return ;
                case "1": UserView.main(sc);  break;
                case "2": BoardView.main(); break;
                case "3": AccountView.main(sc); break;
                case "4": CrawlerView.main(sc); break;
                case "5": ArticleView.main(sc); break;
            }
        }


    }
}