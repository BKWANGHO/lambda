package com.turing.api.user;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    String login(User user);
    String addUsers();
    String updatePassword(User user);
    List<?> findUserByName(String name);
    List<?> findUserByJob(String job);
    String test();
    List<?> findUsers() throws SQLException;
    User getUser(String id);
    Messenger touchTable() throws SQLException;
    Messenger removeTable() throws SQLException;
}