package article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleService {
    List<?> findArticles() throws SQLException;
}