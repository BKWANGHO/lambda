package com.turing.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    private ArticleService service;

    public ArticleController() {
    this.service = ArticleServiceImpl.getInstance();
    }

    public List<?> findAll(Scanner sc) throws SQLException {
        return service.findAll();
    }
}
