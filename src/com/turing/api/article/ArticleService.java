package com.turing.api.article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleService {

    List<?> findAll() throws SQLException;
}
