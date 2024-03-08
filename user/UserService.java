package user;

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
    public String touchTable() throws SQLException;

    String removeTable() throws SQLException;
}

