package crawler;


import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        CrawlerController ctrl =new CrawlerController();

        while (true) {
            System.out.println("[메뉴] 0-종료\n " +
                    "1-벅스뮤직\n" +
                    "2-멜론뮤직\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n " +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("=== 벅스뮤직 ===");
                    Map<String,?> map = ctrl.findBugsMusic(sc);
                    Iterator<Element> rank = (Iterator<Element>) map.get("bugs.rank");
                    Iterator<Element> title = (Iterator<Element>) map.get("bugs.title");
                    Iterator<Element> artist = (Iterator<Element>) map.get("bugs.artist");

                    System.out.println("벅스뮤직 결과 : " );
                    while (rank.hasNext()){
                        System.out.println(rank.next().text() + "위 "
                                + artist.next().text() + " - "
                                + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("=== 멜론뮤직 ===");
                    Map<String,?> melon = ctrl.findMelonMusic(sc);
                    Iterator<Element> rank1 = (Iterator<Element>) melon.get("melon.rank");
                    Iterator<Element> title1 = (Iterator<Element>) melon.get("melon.title");
                    Iterator<Element> artist1 = (Iterator<Element>) melon.get("melon.artist");

                    System.out.println("멜론뮤직 결과 : " );
                    while (rank1.hasNext()){
                        System.out.println(rank1.next().text() + "위 "
                                + artist1.next().text() + " - "
                                + title1.next().text());
                    }
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
