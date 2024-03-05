package crawler;

import user.UserController;

import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) {
        CrawlerController ctrl =new CrawlerController();

        while (true) {
            System.out.println("[메뉴] 0-종료\n " +
                    "1-벅스뮤직\n" + //o
                    "2-로그인\n " + //o
                    "3-ID검색\n " +
                    "4-비번변경\n " + // 0
                    "5-탈퇴\n " +  //0
                    "6-회원목록\n " + //0
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");   // 0
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("=== 벅스뮤직 ===");
                    Map<String,?> map = ctrl.findBugsMusic(sc);
                    System.out.println("벅스뮤직 결과 : ");

                    break;
                case "2":
                    System.out.println("=== 로그인 ===");
                    break;
                case "3":
                    System.out.println("=== ID검색 ===");
                    break;
                case "4":
                    System.out.println("아이디를 입력하세요");
                    break;
                case "5":
                    break;
                case "6":
                    System.out.println("=== 회원목록 ===");
                    break;
                case "7":
                    System.out.println("=== 이름으로검색 ===");
                    System.out.println("이름을 입력하세요");
                    break;
                case "8":
                    System.out.println("=== 직업검색 ===");
                    System.out.println("직업을 입력하세요");

                    break;
                case "9":
                    System.out.println("=== 회원수 ===");
                    break;
            }
        }
    }
}
