package com.turing.api.enums;

import com.turing.api.account.AccountController;
import com.turing.api.crawler.CrawlerController;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum CrawlerRouter {
    Exit("0",i->{
        System.out.println("Exit");
        return false;
    }),
    bugsMusic("1",i->{
        System.out.println("=== 벅스뮤직 ===");
        Map<String,?> map = null;
        try {
            map = CrawlerController.getInstance().findBugsMusic(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator<Element> rank = (Iterator<Element>) map.get("bugs.rank");
        Iterator<Element> title = (Iterator<Element>) map.get("bugs.title");
        Iterator<Element> artist = (Iterator<Element>) map.get("bugs.artist");

        System.out.println("벅스뮤직 결과 : " );
        while (rank.hasNext()){
            System.out.println(rank.next().text() + "위 "
                    + artist.next().text() + " - "
                    + title.next().text());
        }
        return true;
    }),
    MelonMusic("2",i->{
        System.out.println("=== 멜론뮤직 ===");
        Map<String,?> melon = null;
        try {
            melon = CrawlerController.getInstance().findMelonMusic(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator<Element> rank1 = (Iterator<Element>) melon.get("melon.rank");
        Iterator<Element> title1 = (Iterator<Element>) melon.get("melon.title");
        Iterator<Element> artist1 = (Iterator<Element>) melon.get("melon.artist");

        System.out.println("멜론뮤직 결과 : " );
        while (rank1.hasNext()){
            System.out.println(rank1.next().text() + "위 "
                    + artist1.next().text() + " - "
                    + title1.next().text());
        }
        return true;
    }),
    Error("error",i->{
        System.out.println("다시입력하세요");
        return true;
    })
    ;
    ;


    private final String name;
    private final Predicate<Scanner> predicate;

    CrawlerRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean getview(Scanner sc) {
        System.out.println("[메뉴] 0-종료\n " +
                "1-벅스뮤직\n" +
                "2-멜론뮤직\n ");
        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny().orElseGet(()->Error)
                .predicate.test(sc)
                ;
    }
}
