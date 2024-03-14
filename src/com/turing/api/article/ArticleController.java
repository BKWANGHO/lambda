package com.turing.api.article;

import com.turing.api.account.AccountController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    private ArticleService service;

    private static ArticleController instance = new ArticleController();
    private ArticleController() {
    this.service = ArticleServiceImpl.getInstance();
    }

    public static ArticleController getInstance() {
        return instance;
    }

    public List<?> findAll(Scanner sc) throws SQLException {
        return service.findAll();
    }
}
