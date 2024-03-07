package article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner sc) throws SQLException {
        ArticleController controller = new ArticleController();

        while (true) {
            System.out.println("[메뉴] 0-종료\n " +
                    "1-글 목록\n" + //o
                    "2-로그인\n " + //o
                    "9-회원수");   // 0
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("=== 글 목록  ===");

                    List<?> list = controller.findArticles(sc);
                    list.forEach(i-> System.out.println(i));

                    break;
                case "2":
                    System.out.println("=== 로그인 ===");
                    break;
            }
        }
    }
}