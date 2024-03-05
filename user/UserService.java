package user;

import java.util.List;
import java.util.Map;

public interface UserService {

    String login(User user);

    Map<String, ?> addUsers();

    String findUserBYId(User user);

    String updatePassword(User user);

    List<?> findUserByName(String name);

    List<?> findUserByJob(String job);

    Map<String, ?> findUserByNameFromMap(String name);

}

