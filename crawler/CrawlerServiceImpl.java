package crawler;

import account.AccountServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
    public Map<String,?> findNamesFromWeb(Map<String,?> paramMap) throws IOException {
    return repository.save(paramMap);

    }

}
