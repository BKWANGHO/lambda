package com.turing.api.enums;

import com.turing.api.user.User;
import com.turing.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;

public enum UserRouter {
    JOIN("join",i->{
        try {
            return UserController.getInstance().join(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),



    ;

    private final String menu;

    private final Function<Scanner, Messenger> function;

    UserRouter(String menu, Function<Scanner, Messenger> function) {
        this.menu = menu;
        this.function = function;
    }
}
