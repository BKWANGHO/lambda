package com.turing.api.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {

    private static CrawlerController instance = new CrawlerController();
    private CrawlerServiceImpl service;
    private CrawlerController() {
        this.service = CrawlerServiceImpl.getInstance();
    }

    public static CrawlerController getInstance() {
        return instance;
    }

    public Map<String,?> findBugsMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하시오.");
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("URL",sc.next());
        return service.findNamesFromWebBugs(paramMap);
    }

    public Map<String,?> findMelonMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하시오.");
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("URL",sc.next());
        return service.findNamesFromWebMelon(paramMap);
    }
}
