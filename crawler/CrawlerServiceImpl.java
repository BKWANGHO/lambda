package com.turing.api.crawler;

import java.io.IOException;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService{
    private CrawlerRepository repository;
    private static CrawlerServiceImpl instance = new CrawlerServiceImpl();

    private CrawlerServiceImpl() {
        this.repository = CrawlerRepository.getInstance();
    }
    public static CrawlerServiceImpl getInstance() {
        return instance;
    }


    @Override
    public Map<String, ?> findNamesFromWebMelon(Map<String, String> paramMap) throws IOException {
        return repository.saveMelon(paramMap);
    }

    @Override
    public Map<String,?> findNamesFromWebBugs(Map<String,String> paramMap) throws IOException {

        return repository.saveBugs(paramMap);

    }
}
