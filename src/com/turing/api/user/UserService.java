package com.turing.api.user;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    Messenger login(User user) throws SQLException;
    String addUsers();
    Messenger updatePassword(User user);
    List<?> findUserByName(String name);
    List<?> findUserByJob(String job);
    Messenger findUsers() throws SQLException;
    Messenger getUser(String id) throws SQLException;
    Messenger touchTable() throws SQLException;
    Messenger removeTable() throws SQLException;
}