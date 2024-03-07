package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService{

    ArticleRepository repository;
    private static ArticleService instance = new ArticleServiceImpl();

    private ArticleServiceImpl() {
        this.repository = ArticleRepository.getInstance();
    }
    public static ArticleService getInstance(){
        return instance;
    }

    @Override
    public List<?> findArticles() throws SQLException {
        return repository.findArticles();
    }
}
