package article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    ArticleService service;

    public ArticleController() {
    this.service = ArticleServiceImpl.getInstance();
    }

    public List<?> findArticles(Scanner sc) throws SQLException {
        return service.findArticles();
    }
}
